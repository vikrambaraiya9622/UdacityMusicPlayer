package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.yadu1c.udacitymusicplayer.Adapter.SongApapter;
import com.yadu1c.udacitymusicplayer.Adapter.SongGridViewAdapter;
import com.yadu1c.udacitymusicplayer.Model.Song;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
  static boolean nowplaying=false;
    static Song[] songs;

    @Override
    protected void onResume() {
        super.onResume();
        if (nowplaying==true)
        {
            LinearLayout ll=findViewById(R.id.nowplayingfooter);
            ll.setVisibility(View.VISIBLE);
        }
        Toast.makeText(this,""+nowplaying,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context=getApplicationContext();
        Switch changeview=findViewById(R.id.switchstate);

         songs = new Song[]{ new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
        new Song("Beedi2 (from Omkara)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
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
                Intent intent=new Intent(context ,NowPlaying.class);
                Bundle bundle=new Bundle();
                bundle.putString("Songname",songobj.getmName());
                bundle.putString("SongSinger",songobj.getmSinger());
                bundle.putDouble("songstarttime",songobj.getmStartTime());
                bundle.putDouble("songendttime",songobj.getmEndTime());
                bundle.putInt("songimg",songobj.getmThumbnail());
                bundle.putInt("curentposition",position);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        songsGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o=songsGridview.getItemAtPosition(i);
                Song songsgridobj=(Song)o;
                Log.d("GridViewClicked","Grid View clicked for songlist ");
                Toast.makeText(MainActivity.this, songsgridobj.getmName() +" " + songsgridobj.getmSinger() + "" + songsgridobj.getmEndTime() , Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context ,NowPlaying.class);
                Bundle bundle=new Bundle();
                bundle.putString("Songname",songsgridobj.getmName());
                bundle.putString("SongSinger",songsgridobj.getmSinger());
                bundle.putDouble("songstarttime",songsgridobj.getmStartTime());
                bundle.putDouble("songendttime",songsgridobj.getmEndTime());
                bundle.putInt("songimg",songsgridobj.getmThumbnail());
                intent.putExtras(bundle);
                startActivity(intent);
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