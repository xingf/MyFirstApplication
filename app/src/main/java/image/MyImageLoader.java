package image;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.xw.myfirstapplication.R;

import network.RequestQueueFactory;

/**
 * Created by Administrator on 2016/8/23.
 */
public class MyImageLoader {

    public static MyImageLoader imageLoader = null;
    private RequestQueue queue; // = RequestQueueFactory.getRequestQueue();
    private Bitmap image;
    private CorrectionResponser correctionResponser;
    private ErrResponser errResponser;
    private ImageView imageView;

    private MyImageLoader(Context context){
        queue = RequestQueueFactory.getRequestQueue(context);
        correctionResponser = new CorrectionResponser();
        errResponser = new ErrResponser();

    }

    public static synchronized MyImageLoader getImageLoader(Context context){
        if(imageLoader == null){
            imageLoader = new MyImageLoader(context);
        }
        return imageLoader;
    }
    private class CorrectionResponser implements  Response.Listener<Bitmap>{

        @Override
        public void onResponse(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
            queue.stop();
        }
    }
    private class ErrResponser implements Response.ErrorListener{
        @Override
        public void onErrorResponse(VolleyError error) {
           /* imageView.setImageResource(R.drawable.image_load_error);
            queue.stop();*/
        }
    }


    /**
     * Set an Bitmap image object at the specific url to 
     * an ImageView object
     * @param url
     * @param imageView
     */
    public void set(ImageView imageView, String url){
        this.imageView = imageView;
        this.queue.start();
        ImageRequest request = new ImageRequest(url,
                correctionResponser, 0, 0, null, Bitmap.Config.RGB_565,
               errResponser);
        this.queue.add(request);
    }

}
