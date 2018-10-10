package com.example.harshitvaish.restexamplejava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiverClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Context taken",Toast.LENGTH_SHORT).show();
    }
}
