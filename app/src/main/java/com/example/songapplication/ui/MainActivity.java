package com.example.songapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.songapplication.R;
import com.example.songapplication.databinding.SongsBinding;
import com.example.songapplication.network.RetrofitClientInstance;
import com.example.songapplication.network.SongDataService;
import com.example.songapplication.network.Songs;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private SongsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        SongDataService service = RetrofitClientInstance.getRetrofitInstance().create(SongDataService.class);
        Call<List<Songs>> call = service.getAllSongs();
        call.enqueue(new Callback<List<Songs>>() {
            @Override
            public void onResponse(Call<List<Songs>> call, Response<List<Songs>> response) {
                setUpRecyclerView(response.body());
                Log.i("MainActivity", "onResponse: onSuccess");
            }

            @Override
            public void onFailure(Call<List<Songs>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Response Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setUpRecyclerView(List<Songs> list){
        binding.songsRecyclerView.setAdapter(new SongAdapter(list));
    }

}