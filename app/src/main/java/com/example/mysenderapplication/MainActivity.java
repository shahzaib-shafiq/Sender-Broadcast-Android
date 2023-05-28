package com.example.mysenderapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{


    private BroadcastReceiver myBroadCastReciver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if("com.example.mysenderapplication.ACTION_SEND".equals(intent.getAction()))
            {
                String extra = intent.getStringExtra("com.example.mysenderapplication");

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void SendBroadCast(View view) {
        Intent intent = new Intent("com.example.mysenderapplication.ACTION_SEND");
        String key="com.example.mysenderapplication.EXTRA";
        intent.putExtra(key,"I am in Sender Application");
        sendBroadcast(intent);



    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter  = new  IntentFilter("com.example.mysenderapplication.ACTION_SEND");
        registerReceiver(myBroadCastReciver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadCastReciver);
    }
}