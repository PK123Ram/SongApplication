package com.example.songapplication.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.songapplication.R;
import com.example.songapplication.databinding.SongItemBinding;
import com.example.songapplication.network.Songs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.songsAdapterClass> {

    private List<Songs> listOfSongs;

    public SongAdapter(List<Songs> listOfSongs) {
        this.listOfSongs = listOfSongs;
    }

    @NonNull
    @Override
    public songsAdapterClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SongItemBinding songItemBinding = DataBindingUtil.inflate(inflater, R.layout.songs_item, parent, false);
        return new songsAdapterClass(songItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull songsAdapterClass holder, int position) {
        Songs songs = listOfSongs.get(holder.getAdapterPosition());
        Picasso.get().load(listOfSongs.get(position).getSongCoverImage()).into(holder.itemBinding.imgCover);
        holder.bind(songs);
    }

    @Override
    public int getItemCount() {
        return listOfSongs.size();
    }

    public static class songsAdapterClass extends RecyclerView.ViewHolder {

        SongItemBinding itemBinding;

        public songsAdapterClass(@NonNull SongItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Songs songs) {
            itemBinding.setSong(songs);
        }
    }

}
