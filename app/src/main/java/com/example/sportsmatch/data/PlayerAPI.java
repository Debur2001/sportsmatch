package com.example.sportsmatch.data;

import com.example.sportsmatch.domain.Resposta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlayerAPI {
    @GET("teste.json")
    Call<ArrayList<Resposta>> getPlayers();
}
