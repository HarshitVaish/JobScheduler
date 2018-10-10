package com.example.harshitvaish.restexamplejava;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  public static final String Url="";
    BroadcastReceiverClass broadcastReceiverClass=new BroadcastReceiverClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RequestQueue  requestQueue= Volley.newRequestQueue(this);
//
//        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET,Url,null,  new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("success",response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("success",error.toString());
//            }
//        });
       // RequestQueue
        broadcastReceiverClass=new BroadcastReceiverClass();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiverClass,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiverClass);
    }
}
