package com.example.sportsmatch.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportsmatch.databinding.PlayerBinding;
import com.example.sportsmatch.domain.ObjectElement;
import com.example.sportsmatch.domain.Player;
import com.example.sportsmatch.domain.Resposta;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private ObjectElement[] objectElement;
    private List<Player> players;
    private ArrayList<Resposta> resposta;

    public PlayerAdapter(ArrayList<Resposta> resposta) {
        this.resposta = resposta;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PlayerBinding binding = PlayerBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        Player player = this.players.get(position);

        Glide.with(context).load(player.getImg()).circleCrop().into(holder.binding.ivImage);

    }

    @Override
    public int getItemCount() {
        return this.players.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final PlayerBinding binding;

        public ViewHolder(PlayerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
