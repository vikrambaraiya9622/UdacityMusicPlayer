package com.yadu1c.udacitymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.yadu1c.udacitymusicplayer.Adapter.SongApapter;
import com.yadu1c.udacitymusicplayer.Adapter.SongGridViewAdapter;
import com.yadu1c.udacitymusicplayer.Model.Song;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
  static boolean nowplaying=false;
    static Song[] songs;
    public static int currentsong;
    @Override
    protected void onResume() {
        super.onResume();
        if (nowplaying)
        {
            displaynowplayingfooter();

        }

    }

    private void displaynowplayingfooter() {
        LinearLayout ll=findViewById(R.id.nowplayingfooter);
        ll.setVisibility(View.VISIBLE);
        TextView footertv=findViewById(R.id.footersongname);
        footertv.setText(songs[currentsong].getmName());
        TextView footersingertv=findViewById(R.id.footersinger);
        footersingertv.setText(songs[currentsong].getmSinger());
        ImageView thumbnail=findViewById(R.id.currentThumbnail);
        int thumbnailImg=songs[currentsong].getmThumbnail();

        thumbnail.setImageResource(thumbnailImg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context=getApplicationContext();

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch changeview=findViewById(R.id.switchstate);

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
        Button cancelNowPlayingSong=findViewById(R.id.stopcurrentsong);
        cancelNowPlayingSong.setOnClickListener(view -> stopcurrentplayingsong());

        songlistview.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent=new Intent(context ,NowPlaying.class);
            currentsong=position;
            startActivity(intent);

        });
        songsGridview.setOnItemClickListener((adapterView, view, i, l) -> {

            Intent intent=new Intent(context ,NowPlaying.class);
            currentsong=i;
            startActivity(intent);
        });
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

    private void updatePlaylist() {
        songs = new Song[]{ new Song("Beedi (from Omkara)", "Monty Sharma", 00.00, 04.53, R.drawable.ic_thumbnail),
       new Song("Swawariya(swawariya)", "Monty sharma", 00.00, 04.20, R.drawable.ic_thumbnail),
       new Song("Kuch To Hua Hai (Kal ho na Ho)", "Sony Music India", 00.00, 02.33,R.drawable.ic_thumbnail),
       new Song("Hawa Hawai 2.0 (Tumhari Sulu)", "Kavita Krishnamurty", 00.00, 01.53,R.drawable.ic_thumbnail),
       new Song("Boro Boro (Radio Edit)", "Arash", 00.00, 04.53, R.drawable.ic_thumbnail),
       new Song("Koi Ladki Hai (Kuch Kuch Hota Hai)", "Lata Mangeshkar", 00.00, 02.16, R.drawable.ic_thumbnail),
       new Song("Swag se swagat (Tiger Zinda Hai)", "Vishal Dadlani", 00.00, 03.19, R.drawable.ic_thumbnail),
       new Song("Bumbro (Mission Kashmir)", "Shankar Mahadevan", 00.00, 04.58, R.drawable.ic_thumbnail),
       new Song("Crazy kiya re (Dhoom)", "Sunidhi Chauhan", 00.00, 05.11, R.drawable.ic_thumbnail),
       new Song("Uska hi banana (1920)", "Arjit singh", 00.00, 06.27, R.drawable.ic_thumbnail),
       new Song("Ik Vaari Aa (Parindey)", "Shirley Setia", 00.00, 03.37, R.drawable.ic_thumbnail),
       new Song("Tum Itna Jo (Mtv Unlugged)", "Papon", 00.00, 02.53, R.drawable.ic_thumbnail),
       new Song("Channa ve (from Omkara)", "Akhil Sachdeva", 00.00, 05.42, R.drawable.ic_thumbnail),
       new Song("Tere Bin (Simba)", "Rahat Fateh Ali", 00.00, 03.55, R.drawable.ic_thumbnail),
       new Song("Khalibali (Padmavat)", "Shivam Pathak", 00.00, 04.41, R.drawable.ic_thumbnail),
       new Song("sun le Zara (Singham)", "Arjit Singh", 00.00, 04.17, R.drawable.ic_thumbnail),
       new Song("Bulleya (Omkara)", "Papon", 00.00, 03.29, R.drawable.ic_thumbnail),
       new Song("Thodi Der (Half Girlfriend)", "Shreya Ghoshal", 00.00, 03.54, R.drawable.ic_thumbnail),
       new Song("Sajde (Singham returns)", "Arjit Singh", 00.00, 02.40, R.drawable.ic_thumbnail),
       new Song("Titli (Chennai Express)", "Gopi Sunder", 00.00, 11.29, R.drawable.ic_thumbnail)
       };
    }

    public void stopcurrentplayingsong() {
        LinearLayout ll=findViewById(R.id.nowplayingfooter);
        ll.setVisibility(View.INVISIBLE);
        nowplaying=false;
    }
}