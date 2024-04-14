package com.example.rmp101010.UI.Layer.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.rmp101010.Data.Layer.Repository.Repository;
import com.example.rmp101010.UI.Layer.view.Name;

import java.util.List;

public class MyViewModel2 extends ViewModel {
    private Repository repository;

    public MyViewModel2(Context context, Name stroka) {
        repository = new Repository(context,stroka);
    }
    public void writeApp(String stroka){
        repository.writeApp(stroka);
    }
    public void readAPP(){
        repository.readAPP();
    }
    public void writeCommon(String stroka){
        repository.writeCommon(stroka);
    }
    public void readCommon(){
        repository.readCommon();
    }
    public void writeString(String key, String value) {
        repository.writeString(key,value);
    }
    public void writeInt(String key, int value) {
        repository.writeInt(key,value);
    }
    public void writeBool(String key, boolean value) {
        repository.writeBool(key,value);
    }
    public String readString(String key) {
        return repository.readString(key);
    }
    public int readInt(String key) {
        return repository.readInt(key);
    }
    public boolean readBool(String key) {
        return repository.readBool(key);
    }

}