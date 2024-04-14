package com.example.rmp101010.UI.Layer.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.rmp101010.R;
import com.example.rmp101010.UI.Layer.viewmodel.ShowRViewModel;

public class TrirdThirdFragment extends Fragment {
    public TrirdThirdFragment(){super(R.layout.thirdthirdfragment);}
    private ShowRViewModel viewModel2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn1=view.findViewById(R.id.OK);
        viewModel2 = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewModel2.getRabbitListLiveData().getValue() != null && viewModel2.getRabbitListLiveData().getValue().getRabbits().size()>0) { // Проверка на null
                    viewModel2.deleteRabbitFromList();
                    Navigation.findNavController(view).navigate(R.id.action_trirdThirdFragment2_to_thirdFragment);
                }
            }
        });
    }
}
