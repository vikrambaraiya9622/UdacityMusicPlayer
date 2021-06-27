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

public class SongApapter extends ArrayAdapter<Song> {
    public SongApapter(@NonNull Context context, List<Song> songList) {
        super(context, 0, songList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Song currentSong = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.songlist, parent, false);
        }
        ImageView mThumbnail = convertView.findViewById(R.id.songThumbnail);
        TextView mSingerName = convertView.findViewById(R.id.singerName);
        TextView mSongName = convertView.findViewById(R.id.songName);
        mThumbnail.setImageResource(currentSong.getmThumbnail());
        mSongName.setText(currentSong.getmName());
        mSingerName.setText(currentSong.getmSinger());
        return convertView;
    }
}
