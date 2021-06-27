package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.yadu1c.udacitymusicplayer.Model.Song;

import java.util.Random;

public class NowPlaying extends AppCompatActivity {
   private  Boolean shuffle=false;
    private Boolean repeat=false;
    private Boolean playing=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        updateplayingsong(MainActivity.currentsong);

        Button backbtn=findViewById(R.id.btnback);
        Button nextbtn=findViewById(R.id.btnnext);
        Button shufflebtn=findViewById(R.id.btnshuffle);
        Button repeatbtn=findViewById(R.id.btnrepeat);
        Button playpausebtn=findViewById(R.id.btnplaypause);

        backbtn.setOnClickListener(view -> backsong());

        nextbtn.setOnClickListener(view -> nextsong());

        repeatbtn.setOnClickListener(view -> repeatsong());
        shufflebtn.setOnClickListener(view -> shufflesong());
        playpausebtn.setOnClickListener(view -> playpausesong());






    }

    private void updateplayingsong(int currentSong) {
        Song songobj= MainActivity.songs[currentSong];


        String songname=songobj.getmName();
        int thumbnail=songobj.getmThumbnail();
        double starttime=songobj.getmStartTime();
        double endttime=songobj.getmEndTime();


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


    public void backsong() {


        if(shuffle){
            Random randomNumber=new Random();
            int size=MainActivity.songs.length;
            int shufflesong=randomNumber.nextInt(size);
            updateplayingsong(shufflesong);
        }
        else if(repeat){
            updateplayingsong(MainActivity.currentsong);
        }
        else{
            if(MainActivity.currentsong>0){
                MainActivity.currentsong -=1;
            }
            else
                MainActivity.currentsong=MainActivity.songs.length-1;
            updateplayingsong( MainActivity.currentsong);
        }
    }

    public void playpausesong() {
        if(playing){

            MaterialButton playbtn=findViewById(R.id.btnplaypause);
            playbtn.setIcon(getResources().getDrawable(R.drawable.ic_pause));
            playing=false;
           //stop progress bar

        } else {

            MaterialButton playbtn=findViewById(R.id.btnplaypause);
            playbtn.setIcon(getResources().getDrawable(R.drawable.ic_play));
            playing=true;


        }
    }

    public void nextsong() {
        if(shuffle){
            Random randomNumber=new Random();
            int size=MainActivity.songs.length;
            int shufflesong=randomNumber.nextInt(size);
            updateplayingsong(shufflesong);
        }
        else if(repeat){
            updateplayingsong(MainActivity.currentsong);
        }
        else {
            if(MainActivity.currentsong<MainActivity.songs.length-1){
                MainActivity.currentsong+=1;
            }
            else{
                MainActivity.currentsong=0;}
            updateplayingsong(MainActivity.currentsong);
        }
    }

    public void shufflesong() {

        repeat=false;
        Button repeatbtn=findViewById(R.id.btnrepeat);
        repeatbtn.setBackgroundColor(getResources().getColor(R.color.primarylight));
        Button shufflebtn=findViewById(R.id.btnshuffle);
        if(!shuffle){

            shuffle=true;
            shufflebtn.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else
        {

            shuffle=false;
            shufflebtn.setBackgroundColor(getResources().getColor(R.color.primarylight));

        }

    }

    public void repeatsong() {

        shuffle=false;
        shuffle=false;
        Button shufflebtn=findViewById(R.id.btnshuffle);
        shufflebtn.setBackgroundColor(getResources().getColor(R.color.primarylight));

        Button repeatbtn=findViewById(R.id.btnrepeat);
        if(!repeat){

            repeat=true;
            repeatbtn.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else
        {

            repeat=false;
            repeatbtn.setBackgroundColor(getResources().getColor(R.color.primarylight));

        }

    }
}
