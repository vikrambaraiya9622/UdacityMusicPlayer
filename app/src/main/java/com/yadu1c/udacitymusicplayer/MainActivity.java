package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

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

        songlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = songlistview.getItemAtPosition(position);
                Song songobj= (Song) o;
                Log.d("ListViewClick","List View clicked for song list ");
                Toast.makeText(MainActivity.this, songobj.getmName() +" " + songobj.getmSinger() + "" + songobj.getmEndTime() , Toast.LENGTH_SHORT).show();
                // prestationEco str = (prestationEco)o; //As you are using Default String Adapter
                //  Toast.makeText(getBaseContext(),str.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        songsGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o=songsGridview.getItemAtPosition(i);
                Song songsgridobj=(Song)o;
                Log.d("GridViewClicked","Grid View clicked for songlist ");
                Toast.makeText(MainActivity.this, songsgridobj.getmName() +" " + songsgridobj.getmSinger() + "" + songsgridobj.getmEndTime() , Toast.LENGTH_SHORT).show();

            }
        });
        changeview.setOnCheckedChangeListener((compoundButton, b) -> {
                if (b){
                    songlistview.setVisibility(View.INVISIBLE);
                    songsGridview.setVisibility(View.VISIBLE);


                }else
                {
                    songlistview.setVisibility(View.VISIBLE);
                    songsGridview.setVisibility(View.INVISIBLE);
                  //  songlistview.setOnItemClickListener((adapterView, view, i, l) -> );

                }
                });


    }
}