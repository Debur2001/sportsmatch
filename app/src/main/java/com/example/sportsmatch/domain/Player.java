package com.example.sportsmatch.domain;

import com.google.gson.annotations.SerializedName;

public class Player {
    private String img;
    private String name;
    private double percentual;
    private String pos;
    private String country;
    @SerializedName("Barras")
    private Barras barras;

    public String getImg() { return img; }
    public void setImg(String value) { this.img = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public double getPercentual() { return percentual; }
    public void setPercentual(double value) { this.percentual = value; }

    public String getPos() { return pos; }
    public void setPos(String value) { this.pos = value; }

    public String getCountry() { return country; }
    public void setCountry(String value) { this.country = value; }

    public Barras getBarras() { return barras; }
    public void setBarras(Barras value) { this.barras = value; }
}