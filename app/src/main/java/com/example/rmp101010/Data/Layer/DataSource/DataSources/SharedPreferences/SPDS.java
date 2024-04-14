package com.example.rmp101010.Data.Layer.DataSource.DataSources.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SPDS {
    private SharedPreferences file;
    private Context context;
    private String filename;
    public  SPDS(Context context, String filename){
        this.context=context;
        this.filename=filename;
        this.file=context.getSharedPreferences(filename,Context.MODE_PRIVATE);
    }
    public void writeString(String key, String value) {
        if (!file.contains(key)) {
            SharedPreferences.Editor editor = file.edit();
            editor.putString(key, value);
            editor.apply();
            Log.i("SPDS","Запись создана");

        } else {
            Log.w("SPDS","Ключ уже существует");
        }
    }
    public void writeInt(String key, int value) {
        if (!file.contains(key)) {
            SharedPreferences.Editor editor = file.edit();
            editor.putInt(key, value);
            editor.apply();
            Log.i("SPDS","Запись создана");
        } else {
            Log.w("SPDS","Ключ уже существует");
        }
    }
    public void writeBool(String key, boolean value) {
        if (!file.contains(key)) {
            SharedPreferences.Editor editor = file.edit();
            editor.putBoolean(key, value);
            editor.apply();
            Log.i("SPDS","Запись создана");
        } else {
            Log.w("SPDS","Ключ уже существует");
        }
    }
    public String readString(String key) {
        String defaultV="";
        return file.getString(key, defaultV);
    }
    public int readInt(String key) {
        int defaultV=0;
        return file.getInt(key, defaultV);
    }
    public boolean readBool(String key){
        boolean defaultV=false;
        return file.getBoolean(key,defaultV);
    }
}