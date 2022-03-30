package com.example.sportsmatch.domain;

import com.google.gson.annotations.SerializedName;

public class Barras {
    @SerializedName("Copas_do_Mundo_Vencidas")
    private CopasDoMundoDas copasDoMundoVencidas;
    @SerializedName("Copas_do_Mundo_Disputadas")
    private CopasDoMundoDas copasDoMundoDisputadas;

    public CopasDoMundoDas getCopasDoMundoVencidas() { return copasDoMundoVencidas; }
    public void setCopasDoMundoVencidas(CopasDoMundoDas value) { this.copasDoMundoVencidas = value; }

    public CopasDoMundoDas getCopasDoMundoDisputadas() { return copasDoMundoDisputadas; }
    public void setCopasDoMundoDisputadas(CopasDoMundoDas value) { this.copasDoMundoDisputadas = value; }
}
