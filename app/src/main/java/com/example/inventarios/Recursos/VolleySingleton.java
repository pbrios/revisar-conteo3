package com.example.inventarios.Recursos;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static com.example.inventarios.Recursos.VolleySingleton singleton;
    private RequestQueue requestQueue;
    private static Context ctx;

    private VolleySingleton(Context context){
        ctx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized com.example.inventarios.Recursos.VolleySingleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new com.example.inventarios.Recursos.VolleySingleton(context);
        }
        return singleton;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
