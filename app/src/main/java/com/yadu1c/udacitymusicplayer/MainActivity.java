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

        updatePlaylist();

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

    private void updatePlaylist() {
        songs = new Song[]{ new Song("Beedi (from Omkara)", "Monty Sharma", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Swawariya(swawariya)", "Monty sharma", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Kuch To Hua Hai (Kal ho na Ho)", "Sony Music India", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Hawa Hawai 2.0 (Tumhari Sulu)", "Kavita Krishnamurty", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Boro Boro (Radio Edit)", "Arash", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Koi Ladki Hai (Kuch Kuch Hota Hai)", "Lata Mangeshkar", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Swag se swagat (Tiger Zinda Hai)", "Vishal Dadlani", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Bumbro (Mission Kashmir)", "Shankar Mahadevan", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Crazy kiya re (Dhoom)", "Sunidhi Chauhan", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Uska hi banana (1920)", "Arjit singh", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Ik Vaari Aa (Parindey)", "Shirley Setia", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Tum Itna Jo (Mtv Unlugged)", "Papon", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Channa ve (from Omkara)", "Akhil Sachdeva", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Tere Bin (Simba)", "Rahat Fateh Ali", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Khalibali (Padmavat)", "Shivam Pathak", 00.00, 04.53, R.drawable.finaldesign),
       new Song("sun le Zara (Singham)", "Arjit Singh", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Bulleya (Omkara)", "Papon", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Thodi Der (Half Girlfriend)", "Shreya Ghoshal", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Sajde (Singham returns)", "Arjit Singh", 00.00, 04.53, R.drawable.finaldesign),
       new Song("Titli (Chennai Express)", "Gopi Sunder", 00.00, 04.53, R.drawable.finaldesign)
       };
    }
}