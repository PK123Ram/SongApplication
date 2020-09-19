package com.example.songapplication.network;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SongDataService {

    @GET("/studio")
    Call<List<Songs>> getAllSongs();
}
