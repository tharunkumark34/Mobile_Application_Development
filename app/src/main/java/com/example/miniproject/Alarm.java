package com.example.miniproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer m = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
        m.start();
        Toast.makeText(context, "WAKE-UP", Toast.LENGTH_LONG).show();
    }
}

