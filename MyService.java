package com.example.serviceweek4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer MP;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started.", Toast.LENGTH_LONG).show();
        int musicChoice = intent.getIntExtra("music_choice", 1);
        int musicResource = R.raw.music1;
        switch (musicChoice) {
            case 1:
                musicResource = R.raw.music1;
                break;
            case 2:
                musicResource = R.raw.music2;
                break;
            case 3:
                musicResource = R.raw.music3;
                break;
        }
        MP = MediaPlayer.create(this, musicResource);
        MP.setLooping(true);
        MP.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped.", Toast.LENGTH_LONG).show();
        if (MP != null) {
            MP.stop();
            MP.release();
            MP = null;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
