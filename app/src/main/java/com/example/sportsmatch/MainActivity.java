package com.example.sportsmatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.sportsmatch.data.PlayerAPI;
import com.example.sportsmatch.databinding.ActivityMainBinding;
import com.example.sportsmatch.domain.Resposta;
import com.example.sportsmatch.ui.adapter.PlayerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PlayerAPI playerAPI;
    private PlayerAdapter playersAdapter;
    //private MutableLiveData<List<Player>> players = new MutableLiveData<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHTTPClient();
        setupPlayersList();

    }

    private void setupHTTPClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sportsmatch.com.br/teste/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        playerAPI = retrofit.create(PlayerAPI.class);
    }

    private void setupPlayersList() {
        binding.rvPlayer.setHasFixedSize(true);
        binding.rvPlayer.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPlayer.setAdapter(playersAdapter);
        findPlayersFromAPI();
    }

    private void findPlayersFromAPI() {
        playerAPI.getPlayers().enqueue(new Callback<Resposta>() {
            @Override
            public void onResponse(@NonNull Call<Resposta> call, @NonNull Response<Resposta> response) {
                if (response.isSuccessful()) {
                    Resposta resposta = response.body();
                    playersAdapter = new PlayerAdapter(resposta);
                    binding.rvPlayer.setAdapter(playersAdapter);
                } else {
                    //TODO implementar tratamento de erros
                }
            }

            @Override
            public void onFailure(@NonNull Call<Resposta> call, @NonNull Throwable e) {
                e.printStackTrace();
                //TODO implementar tratamento de erros
            }
        });
    }
}