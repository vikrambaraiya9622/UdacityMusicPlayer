package com.yadu1c.udacitymusicplayer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.yadu1c.udacitymusicplayer.Model.Song;

import java.util.Random;

public class NowPlaying extends AppCompatActivity {
    private Boolean shuffleFlag = false;
    private Boolean repeatFlag = false;
    private Boolean playingFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        updatePlayingSong(MainActivity.currentSong);
        Button backBtn = findViewById(R.id.btnBack);
        Button nextBtn = findViewById(R.id.btnNext);
        Button shuffleBtn = findViewById(R.id.btnShuffle);
        Button repeatBtn = findViewById(R.id.btnRepeat);
        Button playPauseBtn = findViewById(R.id.btnPlayPause);
        backBtn.setOnClickListener(view -> backSong());
        nextBtn.setOnClickListener(view -> nextSong());
        repeatBtn.setOnClickListener(view -> repeatSong());
        shuffleBtn.setOnClickListener(view -> shuffleSong());
        playPauseBtn.setOnClickListener(view -> playPauseSong());
    }

    @SuppressLint("SetTextI18n")
    private void updatePlayingSong(int currentSong) {
        Song songObj = MainActivity.songs[currentSong];
        String songName = songObj.getmName();
        int thumbnail = songObj.getmThumbnail();
        double startTime = songObj.getmStartTime();
        double endTime = songObj.getmEndTime();
        TextView songNameTV = findViewById(R.id.nowplayingsongname);
        TextView startTimeTV = findViewById(R.id.nowplayingst);
        TextView endTimeTV = findViewById(R.id.nowplayinget);
        ImageView thumbnailImg = findViewById(R.id.nowplayingthumbnail);
        songNameTV.setText(songName);
        thumbnailImg.setImageResource(thumbnail);
        startTimeTV.setText("" + startTime);
        endTimeTV.setText("" + endTime);
        MainActivity.nowPlayingFooterFlag = true;
    }


    public void backSong() {
        if (shuffleFlag) {
            Random randomNumber = new Random();
            int size = MainActivity.songs.length;
            int shuffleSong = randomNumber.nextInt(size);
            updatePlayingSong(shuffleSong);
        } else if (repeatFlag) {
            updatePlayingSong(MainActivity.currentSong);
        } else {
            if (MainActivity.currentSong > 0) {
                MainActivity.currentSong -= 1;
            } else
                MainActivity.currentSong = MainActivity.songs.length - 1;
            updatePlayingSong(MainActivity.currentSong);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void playPauseSong() {
        if (playingFlag) {
            MaterialButton playPauseBtn = findViewById(R.id.btnPlayPause);
            playPauseBtn.setIcon(getResources().getDrawable(R.drawable.ic_pause));
            playingFlag = false;
        } else {
            MaterialButton playPauseBtn = findViewById(R.id.btnPlayPause);
            playPauseBtn.setIcon(getResources().getDrawable(R.drawable.ic_play));
            playingFlag = true;
        }
    }

    public void nextSong() {
        if (shuffleFlag) {
            Random randomNumber = new Random();
            int size = MainActivity.songs.length;
            int shuffleSong = randomNumber.nextInt(size);
            updatePlayingSong(shuffleSong);
        } else if (repeatFlag) {
            updatePlayingSong(MainActivity.currentSong);
        } else {
            if (MainActivity.currentSong < MainActivity.songs.length - 1) {
                MainActivity.currentSong += 1;
            } else {
                MainActivity.currentSong = 0;
            }
            updatePlayingSong(MainActivity.currentSong);
        }
    }

    public void shuffleSong() {
        repeatFlag = false;
        Button repeatBtn = findViewById(R.id.btnRepeat);
        repeatBtn.setBackgroundColor(getResources().getColor(R.color.primarylight));
        Button shuffleBtn = findViewById(R.id.btnShuffle);
        if (!shuffleFlag) {
            shuffleFlag = true;
            shuffleBtn.setBackgroundColor(getResources().getColor(R.color.white));
        } else {
            shuffleFlag = false;
            shuffleBtn.setBackgroundColor(getResources().getColor(R.color.primarylight));
        }
    }

    public void repeatSong() {
        shuffleFlag = false;
        shuffleFlag = false;
        Button shuffleBtn = findViewById(R.id.btnShuffle);
        shuffleBtn.setBackgroundColor(getResources().getColor(R.color.primarylight));
        Button repeatBtn = findViewById(R.id.btnRepeat);
        if (!repeatFlag) {
            repeatFlag = true;
            repeatBtn.setBackgroundColor(getResources().getColor(R.color.white));
        } else {
            repeatFlag = false;
            repeatBtn.setBackgroundColor(getResources().getColor(R.color.primarylight));
        }
    }
}
