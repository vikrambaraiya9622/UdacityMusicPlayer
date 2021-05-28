package com.yadu1c.udacitymusicplayer.Model.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yadu1c.udacitymusicplayer.Model.Song;
import com.yadu1c.udacitymusicplayer.R;

import java.util.List;

public class SongApapter extends ArrayAdapter<Song> {


    public SongApapter(@NonNull Context context, List<Song> songList) {
        super(context,0, songList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Song currentSong=getItem(position);
        if (convertView==null)
        {
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.songlist,parent,false);

        }


        ImageView mthumbnail=convertView.findViewById(R.id.songthumbnail);
        TextView msingername=convertView.findViewById(R.id.singername);

        TextView msongname=convertView.findViewById(R.id.songname);
        mthumbnail.setImageResource(currentSong.getmThumbnail());
        msongname.setText(currentSong.getmName());
        msingername.setText(currentSong.getmSinger());
        return convertView;

    }

}
