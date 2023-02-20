package com.example.carparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoView = (VideoView)findViewById(R.id.videoView);
        String videoPath = new StringBuilder("android.resource://")
                .append(getPackageName())
                .append("/raw/splash")
                .toString();
        videoView.setVideoPath(videoPath);
        //Event
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion (MediaPlayer mediaPlayer) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        finish();
                    }
                },500);
            }

            });
        videoView.start();
    }
}