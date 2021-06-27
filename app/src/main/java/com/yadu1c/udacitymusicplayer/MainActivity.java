package com.yadu1c.udacitymusicplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.yadu1c.udacitymusicplayer.Adapter.SongApapter;
import com.yadu1c.udacitymusicplayer.Adapter.SongGridViewAdapter;
import com.yadu1c.udacitymusicplayer.Model.Song;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    static boolean nowPlayingFooterFlag = false;
    static Song[] songs;
    public static int currentSong;

    @Override
    protected void onResume() {
        super.onResume();
        if (nowPlayingFooterFlag) {
            displayNowPlayingFooter();
        }
    }

    private void displayNowPlayingFooter() {
        LinearLayout ll = findViewById(R.id.nowPlayingFooterLayout);
        ll.setVisibility(View.VISIBLE);
        TextView footertv = findViewById(R.id.noPlayingFooterSongName);
        footertv.setText(songs[currentSong].getmName());
        TextView footersingertv = findViewById(R.id.nowPlayingFooterSingerName);
        footersingertv.setText(songs[currentSong].getmSinger());
        ImageView thumbnail = findViewById(R.id.nowPlayingFooterThumbnail);
        int thumbnailImg = songs[currentSong].getmThumbnail();
        thumbnail.setImageResource(thumbnailImg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch changeview = findViewById(R.id.switchState);
        updatePlaylist();
        SongApapter songsListAdapter = new SongApapter(this, Arrays.asList(songs));
        ListView songListView = findViewById(R.id.songsListViewLayout);
        songListView.setAdapter(songsListAdapter);
        SongGridViewAdapter songsGridAdapter = new SongGridViewAdapter(this, Arrays.asList(songs));
        GridView songsGridview = findViewById(R.id.songsGridViewLayout);
        songsGridview.setAdapter(songsGridAdapter);
        changeview.setChecked(false);
        songListView.setVisibility(View.VISIBLE);
        songsGridview.setVisibility(View.INVISIBLE);
        Button cancelNowPlayingFooterSong = findViewById(R.id.stopFooterSong);
        cancelNowPlayingFooterSong.setOnClickListener(view -> stopCurrentPlayingsong());
        songListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(context, NowPlaying.class);
            currentSong = position;
            startActivity(intent);
        });
        songsGridview.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(context, NowPlaying.class);
            currentSong = i;
            startActivity(intent);
        });
        changeview.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                songListView.setVisibility(View.INVISIBLE);
                songsGridview.setVisibility(View.VISIBLE);
            } else {
                songListView.setVisibility(View.VISIBLE);
                songsGridview.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void updatePlaylist() {
        songs = new Song[]{new Song("Beedi (from Omkara)", "Monty Sharma", 00.00, 04.53, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song1), getString(R.string.singer1), 00.00, 04.20, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song2), getString(R.string.singer2), 00.00, 02.33, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song3), getString(R.string.singer3), 00.00, 01.53, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song4), getString(R.string.singer4), 00.00, 04.53, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song5), getString(R.string.singer5), 00.00, 02.16, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song6), getString(R.string.singer6), 00.00, 03.19, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song7), getString(R.string.singer7), 00.00, 04.58, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song8), getString(R.string.singer8), 00.00, 05.11, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song9), getString(R.string.singer9), 00.00, 06.27, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song10), getString(R.string.singer10), 00.00, 03.37, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song11), getString(R.string.singer11), 00.00, 02.53, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song12), getString(R.string.singer12), 00.00, 05.42, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song13), getString(R.string.singer13), 00.00, 03.55, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song14), getString(R.string.singer14), 00.00, 04.41, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song15), getString(R.string.singer15), 00.00, 04.17, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song16), getString(R.string.singer16), 00.00, 03.29, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song17), getString(R.string.singer17), 00.00, 03.54, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song18), getString(R.string.singer18), 00.00, 02.40, R.drawable.ic_thumbnail),
                new Song(getString(R.string.song19), getString(R.string.singer19), 00.00, 11.29, R.drawable.ic_thumbnail)
        };
    }

    public void stopCurrentPlayingsong() {
        LinearLayout ll = findViewById(R.id.nowPlayingFooterLayout);
        ll.setVisibility(View.INVISIBLE);
        nowPlayingFooterFlag = false;
    }
}