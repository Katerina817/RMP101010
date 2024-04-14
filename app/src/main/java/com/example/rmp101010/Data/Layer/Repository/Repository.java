package com.example.rmp101010.Data.Layer.Repository;

import android.content.Context;
import android.util.Log;


import com.example.rmp101010.Data.Layer.DataSource.DataSources.Files.AppSpDS;
import com.example.rmp101010.Data.Layer.DataSource.DataSources.Files.CommonFDS;
import com.example.rmp101010.Data.Layer.DataSource.DataSources.SharedPreferences.SPDS;
import com.example.rmp101010.UI.Layer.view.Name;

import java.io.File;
import java.util.List;

public class Repository {
    private AppSpDS app;
    private CommonFDS common;
    private SPDS shared;
    public Repository(Context context, Name stroka) {
        if(stroka==Name.APP){
            String fileName = "App.txt";
            this.app=new AppSpDS(context,fileName);
        }
        if(stroka==Name.COMMON){
            String fileName = "Common.txt";
            this.common=new CommonFDS(context,fileName);
        }
        if(stroka==Name.SHARED){
            String fileName = "SharedPref";
            this.shared=new SPDS(context,fileName);
        }
    }
    public void writeApp(String stroka){
        app.writeApp(stroka);
    }
    public void readAPP(){
        app.readAPP();
    }
    public void writeCommon(String stroka){
        common.writeCommon(stroka);
    }
    public void readCommon(){
        common.readCommon();
    }
    public void writeString(String key, String value) {
        shared.writeString(key,value);
    }
    public void writeInt(String key, int value) {
        shared.writeInt(key,value);
    }
    public void writeBool(String key, boolean value) {
        shared.writeBool(key,value);
    }
    public String readString(String key) {
        return shared.readString(key);
    }
    public int readInt(String key) {
        return shared.readInt(key);
    }
    public boolean readBool(String key) {
        return shared.readBool(key);
    }

}