package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Switch;

import com.yadu1c.udacitymusicplayer.Adapter.SongApapter;
import com.yadu1c.udacitymusicplayer.Adapter.SongGridViewAdapter;
import com.yadu1c.udacitymusicplayer.Model.Song;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch changeview=findViewById(R.id.switchstate);
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

        changeview.setChecked(false);
        songlistview.setVisibility(View.VISIBLE);
        songsGridview.setVisibility(View.INVISIBLE);


        changeview.setOnCheckedChangeListener((compoundButton, b) -> {
                if (b){
                    songlistview.setVisibility(View.INVISIBLE);
                    songsGridview.setVisibility(View.VISIBLE);


                }else
                {
                    songlistview.setVisibility(View.VISIBLE);
                    songsGridview.setVisibility(View.INVISIBLE);
                }
                });


    }
}