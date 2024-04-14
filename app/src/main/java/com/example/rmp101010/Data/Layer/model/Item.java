package com.example.rmp101010.Data.Layer.model;

public class Item {
    private String text;
    private int picture;
    public Item(String text, int picture){
        this.text=text;
        this.picture=picture;
    }
    public String getText() {
        return text;
    }
    public int getPicture() {
        return picture;
    }
}
