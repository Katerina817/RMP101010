package com.example.rmp101010.UI.Layer.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmp101010.Data.Layer.Repository.RabbitRepository;
import com.example.rmp101010.Data.Layer.model.Item;
import com.example.rmp101010.Data.Layer.model.Rabbit;
import com.example.rmp101010.R;
import com.example.rmp101010.UI.Layer.viewmodel.ShowRViewModel;

import java.util.ArrayList;
import java.util.List;

public class FourthFragment extends Fragment {
    public FourthFragment(){
        super(R.layout.fourthfragment);
    }
    private ShowRViewModel showRViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourthfragment, container, false);
        // Получаем ViewModel
        showRViewModel = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);
        // Наблюдаем за LiveData с кроликами и обновляем список
        showRViewModel.getRabbitListLiveData().observe(getViewLifecycleOwner(), new Observer<RabbitRepository>() {
            @Override
            public void onChanged(RabbitRepository rabbits) {
                // Создаем список имен кроликов
                List<Item> items = new ArrayList<>();
                for (Rabbit rabbit : rabbits.getRabbits()) {
                    items.add(new Item(rabbit.getName(),R.drawable.rabbit));
                }
                // Создаем адаптер и передаем в него список имен кроликов
                RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
                CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(requireContext(), items);
                recyclerView.setAdapter(adapter);
                adapter.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", position);
                        Log.i("AAAAAAAAAAAAAAAAAAAAAA","pos"+position);
                        Navigation.findNavController(view).navigate(R.id.action_fourthFragment_to_fifthFragment, bundle);
                    }
                });
            }
        });

        return view;
    }
}
