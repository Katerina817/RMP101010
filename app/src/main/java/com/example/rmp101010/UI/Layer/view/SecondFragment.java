package com.example.rmp101010.UI.Layer.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.rmp101010.R;
import com.example.rmp101010.UI.Layer.viewmodel.ShowRViewModel;

public class SecondFragment extends Fragment {
    public SecondFragment(){
        super(R.layout.secondfragment);
    }
    private ShowRViewModel viewModel2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //viewModel = new ViewModelProvider(requireActivity()).get(CreateRViewModel.class);
        viewModel2 = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);

        EditText editTextName = view.findViewById(R.id.editname);
        EditText editTextAge = view.findViewById(R.id.editage);
        EditText editTextColor = view.findViewById(R.id.editcolor);
        EditText editTextLength = view.findViewById(R.id.editlength);
        Button createButton = view.findViewById(R.id.createbutton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String color = editTextColor.getText().toString();
                String earlength = editTextLength.getText().toString();
                //передачв данных в viewmodel
                //viewModel.createRabbit(name, color,earlength,age);
                viewModel2.addRabbitToList(name, color,earlength,age);
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment);
            }
        });
    }
}
