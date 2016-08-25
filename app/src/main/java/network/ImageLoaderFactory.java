package network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2016/8/22.
 */
public class ImageLoaderFactory {
    private static ImageLoader mImageLoader;

    private ImageLoaderFactory(Context context) {
        RequestQueue mRequestQueue = RequestQueueFactory.getRequestQueue(context);

        mRequestQueue.start();
        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized ImageLoader getImageLoader(Context context) {
        if (mImageLoader == null) {
            new ImageLoaderFactory(context);
        }
        return mImageLoader;
    }
}
