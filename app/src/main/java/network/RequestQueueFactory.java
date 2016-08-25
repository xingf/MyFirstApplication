package network;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by Administrator on 2016/8/22.
 */
public class RequestQueueFactory {

    private static RequestQueue mRequestQueue = null;
    private static Cache cache;
    private static Network network;


    public static synchronized RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            // Instantiate the cache
            cache = new DiskBasedCache(context.getCacheDir(), 10*1024 * 1024); // 10MB cap
            // Set up the network to use HttpURLConnection as the HTTP client.
            network = new BasicNetwork(new HurlStack());
            // Instantiate the RequestQueue with the cache and network.
             mRequestQueue = new RequestQueue(cache, network);
        }
        return mRequestQueue;
    }

}
