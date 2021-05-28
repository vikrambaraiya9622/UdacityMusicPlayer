package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.yadu1c.udacitymusicplayer.Model.Adapter.SongApapter;
import com.yadu1c.udacitymusicplayer.Model.Adapter.SongGridViewAdapter;
import com.yadu1c.udacitymusicplayer.Model.Song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Song[] songs = { new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign)
        };
        SongApapter songsadapter=new SongApapter(this, Arrays.asList(songs));
        ListView songlistview=findViewById(R.id.songlistview);
        songlistview.setAdapter(songsadapter);
        SongGridViewAdapter songsgridadapter=new SongGridViewAdapter(this,Arrays.asList(songs));
        GridView songsGridview=findViewById(R.id.songsGridView);
        songsGridview.setAdapter(songsgridadapter);

    }
}