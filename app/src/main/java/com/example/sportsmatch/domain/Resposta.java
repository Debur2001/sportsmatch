package com.example.sportsmatch.domain;

public class Resposta {
    private long status;
    private ObjectElement[] object;

    public long getStatus() { return status; }
    public void setStatus(long value) { this.status = value; }

    public ObjectElement[] getObject() { return object; }
    public void setObject(ObjectElement[] value) { this.object = value; }
}
