package com.example.rmp101010.UI.Layer.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.rmp101010.Data.Layer.Repository.RabbitRepository;
import com.example.rmp101010.Data.Layer.model.Rabbit;
import com.example.rmp101010.R;
import com.example.rmp101010.UI.Layer.viewmodel.ShowRViewModel;

public class FifthFragment extends Fragment {
    public FifthFragment(){
        super(R.layout.fifthfragment);
    }
    private ShowRViewModel showRViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int pos=getArguments().getInt("position");
        Log.i("AAAAAA","pos: " + pos);
        showRViewModel = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);
        // Наблюдаем за LiveData с кроликами и обновляем список
        showRViewModel.getRabbitListLiveData().observe(getViewLifecycleOwner(), new Observer<RabbitRepository>() {
            @Override
            public void onChanged(RabbitRepository rabbits) {
                TextView infa=view.findViewById(R.id.infa);
                Rabbit rabbit = rabbits.getRabbits().get(pos);
                // Отображаем информацию о кролике в TextView
                infa.setText("Name: " + rabbit.getName() + "\nColor: " + rabbit.getColor() + "\nEar Length: " + rabbit.getEarlength() + "\nAge: " + rabbit.getAge());
            }
        });
    }
}
