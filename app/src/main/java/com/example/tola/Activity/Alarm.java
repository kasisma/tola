package com.example.tola.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.tola.R;

public class Alarm extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        this.mediaPlayer= MediaPlayer.create(this,R.raw.sing_test);
        this.mediaPlayer.start();



        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        close();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
            if(this.mediaPlayer !=null){
                this.mediaPlayer.release();
                this.mediaPlayer=null;
            }

    }

    public void close(){
        if(this.mediaPlayer.isPlaying()){
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer=null;
        }

        finish();
    }

}