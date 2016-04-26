package com.rr.hartlibrarryslackbot.data;

/**
 * Created by Rewati Raman(rewati.raman@gmail.com).
 */
public abstract class InMemoDbObject  extends Object{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
