package com.example.sportsmatch.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resposta {
    @SerializedName("Status")
    private long status;

    @SerializedName("Object")
    private List<ObjectElement> object;

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public List<ObjectElement> getObject() {
        return object;
    }

    public void setObject(List<ObjectElement> object) {
        this.object = object;
    }
}
