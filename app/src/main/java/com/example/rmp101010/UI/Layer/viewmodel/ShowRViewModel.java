package com.example.rmp101010.UI.Layer.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rmp101010.Data.Layer.DataSource.RabbitDataSource;
import com.example.rmp101010.Data.Layer.Repository.RabbitRepository;
import com.example.rmp101010.Data.Layer.model.Rabbit;

public class ShowRViewModel extends ViewModel {
    private MutableLiveData<RabbitRepository> rabbitListLiveData = new MutableLiveData<>();
    public LiveData<RabbitRepository> getRabbitListLiveData() {
        return rabbitListLiveData;
    }
    public ShowRViewModel() {
        initializeRepository();
        //rabbitListLiveData.setValue(new RabbitRepository(new RabbitDataSource()));
    }
    public void initializeRepository(){
        new Thread(() -> {
            RabbitRepository repository = new RabbitRepository(new RabbitDataSource());
            rabbitListLiveData.postValue(repository);
        }).start();
    }
    public void addRabbitToList(String name,String color,String earlength,String age) {
        Log.i("1111","Добавлен addRabbitToList ");

        RabbitRepository rabbitRepository = rabbitListLiveData.getValue();
        if (rabbitRepository != null) {
            Log.i("1111","Добавлен addRabbitToList2222 ");
            rabbitRepository.addRabbit(new Rabbit(name, color, earlength, age));
            rabbitListLiveData.setValue(rabbitRepository);
        }
    }
    public void deleteRabbitFromList() {
        RabbitRepository rabbitRepository = rabbitListLiveData.getValue();
        if (rabbitRepository != null) {
            rabbitRepository.deleteRabbit();
            rabbitListLiveData.setValue(rabbitRepository);
        }
    }
}