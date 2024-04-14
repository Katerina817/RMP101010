package com.example.rmp101010.Data.Layer.Repository;

import com.example.rmp101010.Data.Layer.DataSource.RabbitDataSource;
import com.example.rmp101010.Data.Layer.model.Rabbit;

import java.util.List;
public class RabbitRepository {
    private RabbitDataSource dataSource;
    //private MutableLiveData<List<Rabbit>> rabbitListLiveData = new MutableLiveData<>();
    public RabbitRepository(RabbitDataSource dataSource) {
        this.dataSource = dataSource;
        //rabbitListLiveData.setValue(dataSource.getRabbits());
    }
    public List<Rabbit> getRabbits() {
        return dataSource.getRabbits();
    }
    public void addRabbit(Rabbit rabbit) {
        dataSource.addRabbit(rabbit);
        //rabbitListLiveData.setValue(dataSource.getRabbits());
    }

    public void deleteRabbit() {
        dataSource.deleteRabbit();
        //rabbitListLiveData.setValue(dataSource.getRabbits());
    }
}
