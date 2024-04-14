package com.example.rmp101010.UI.Layer.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.rmp101010.Worker.MyWorker;

public class WorkerViewModel extends ViewModel {
    private WorkManager workManager;
    public WorkerViewModel(@NonNull Application application){
        super();
        workManager=WorkManager.getInstance(application);
    }
    public void apply(){
        workManager.enqueue(OneTimeWorkRequest.from(MyWorker.class));
    }
}
