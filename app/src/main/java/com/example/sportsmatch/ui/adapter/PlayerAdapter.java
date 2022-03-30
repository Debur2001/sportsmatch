package com.example.sportsmatch.ui.adapter;

import android.annotation.SuppressLint;
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

    private Resposta resposta;
    private Player player;

    public PlayerAdapter(Resposta resposta) {
        this.resposta = resposta;
        player = resposta.getObject().get(0).getPlayer();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PlayerBinding binding = PlayerBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView

        Glide.with(context).load(player.getImg()).circleCrop().into(holder.binding.ivImage);
        holder.binding.tvUser.setText(player.getName());
        holder.binding.tvTime.setText(player.getCountry());
        holder.binding.tvPosition.setText(player.getPos());
        holder.binding.tvRating.setText(String.format("%.3f", player.getPercentual()));
        // Copas Vencidas
        holder.binding.tvRankingTitulos.setText(player.getBarras().getCopasDoMundoVencidas().getPos() + "º");
        holder.binding.pbCopasVencidas.setMax((int) player.getBarras().getCopasDoMundoVencidas().getMax());
        holder.binding.pbCopasVencidas.setProgress((int) player.getBarras().getCopasDoMundoVencidas().getPla());
        holder.binding.flTvTitulos.setText(String.format("%.1f", player.getBarras().getCopasDoMundoVencidas().getPla()));
        // Copas Disputadas
        holder.binding.tvRankingParticipacoes.setText(player.getBarras().getCopasDoMundoDisputadas().getPos() + "º");
        holder.binding.pbCopasDisputadas.setMax((int) player.getBarras().getCopasDoMundoDisputadas().getMax());
        holder.binding.pbCopasDisputadas.setProgress((int) player.getBarras().getCopasDoMundoDisputadas().getPla());
        holder.binding.flTvParticipacoes.setText(String.format("%.1f", player.getBarras().getCopasDoMundoDisputadas().getPla()));

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final PlayerBinding binding;

        public ViewHolder(PlayerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
