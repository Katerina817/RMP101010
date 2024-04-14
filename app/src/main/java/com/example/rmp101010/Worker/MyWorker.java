package com.example.rmp101010.Worker;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.rmp101010.UI.Layer.view.Name;
import com.example.rmp101010.UI.Layer.viewmodel.MyViewModel;
import com.example.rmp101010.UI.Layer.viewmodel.MyViewModel2;
import com.example.rmp101010.UI.Layer.viewmodel.ShowRViewModel;

import java.io.IOException;

public class MyWorker extends Worker {
    public MyWorker(
            @NonNull Context appContext,
            @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        try {
            MyViewModel2 viewModel2 = new MyViewModel2(getApplicationContext(), Name.APP);
            String example="Пример содержимого файла";
            viewModel2.writeApp(example);
            viewModel2.readAPP();

            Log.i("doWork", "Завершение работы");
            return Result.success();
        } catch (Throwable throwable) {
            Log.i("doWork", "Ошибка", throwable);
            return Result.failure();
        }
    }
}