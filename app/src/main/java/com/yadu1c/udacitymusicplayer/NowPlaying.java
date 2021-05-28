package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Bundle bundle=getIntent().getExtras();
        String songname=bundle.getString("Songname");
        String singername=bundle.getString("SongSinger");
        int thumbnail=bundle.getInt("songimg");
        double starttime=bundle.getDouble("songstarttime");
        double endttime=bundle.getDouble("songendtime");
        TextView songnametv=findViewById(R.id.nowplayingsongname);
        TextView sttv=findViewById(R.id.nowplayingst);
        TextView ettv=findViewById(R.id.nowplayinget);
        ImageView thumbnailimg=findViewById(R.id.nowplayingthumbnail);
        songnametv.setText(songname);
        thumbnailimg.setImageResource(thumbnail);

        sttv.setText(""+starttime);
        ettv.setText(""+endttime);
        MainActivity.nowplaying=true;


    }
}