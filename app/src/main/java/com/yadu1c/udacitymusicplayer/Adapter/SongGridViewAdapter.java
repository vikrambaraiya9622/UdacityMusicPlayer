package com.yadu1c.udacitymusicplayer.Adapter;

import android.content.Context;
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

public class SongGridViewAdapter extends ArrayAdapter<Song> {
    public SongGridViewAdapter(@NonNull Context context, List<Song> songlist) {
        super(context, 0, songlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.songgrid,parent,false);
        }
        Song currentSong=getItem(position);
        ImageView mthumbnail=convertView.findViewById(R.id.thumbnail);
        TextView msongname=convertView.findViewById(R.id.songName);
        TextView msingername=convertView.findViewById(R.id.singerName);

        mthumbnail.setImageResource(currentSong.getmThumbnail());
        msongname.setText(currentSong.getmName());
        msingername.setText(currentSong.getmSinger());
        return  convertView;
    }
}
