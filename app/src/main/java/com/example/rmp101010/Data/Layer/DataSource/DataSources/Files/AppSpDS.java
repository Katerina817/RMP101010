package com.example.rmp101010.Data.Layer.DataSource.DataSources.Files;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppSpDS {
    private File file;
    private Context context;
    private String filename;

    public AppSpDS(Context context, String filename){
        this.context=context;
        this.filename=filename;
        this.file=new File(context.getFilesDir(),filename);
        Log.i("AppSpDS","Создан экземпляр класса");
    }
    public void writeApp(String stroka){
        try {
            FileOutputStream fileIn = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fileIn.write(stroka.getBytes());
            fileIn.close();
            Log.i("AppSpDS","Данные записаны в файл");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readAPP(){
        try {
            FileInputStream fileOut = context.openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileOut);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line=null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            Log.i("AppSpDS",stringBuilder+"");
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
