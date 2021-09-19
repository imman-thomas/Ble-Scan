package com.example.foregroundservice;


import static com.example.foregroundservice.App.CHANNEL_ID;
import static com.example.foregroundservice.MainActivity.TAG;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import java.security.Provider;

public class ForegroundService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra(TAG);
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,notificationIntent,0);
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pi)
                .build();

        startForeground(1,notification);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
