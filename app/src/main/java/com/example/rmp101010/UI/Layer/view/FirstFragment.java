package com.example.rmp101010.UI.Layer.view;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rmp101010.R;
import com.example.rmp101010.UI.Layer.viewmodel.WorkerViewModel;

public class FirstFragment extends Fragment {
    public FirstFragment(){
        super(R.layout.firstfragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn1=view.findViewById(R.id.startbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkerViewModel vm=new WorkerViewModel(new Application());
                vm.apply();
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });
    }
}
