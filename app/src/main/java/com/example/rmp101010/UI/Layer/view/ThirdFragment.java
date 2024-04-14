package com.example.rmp101010.UI.Layer.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.rmp101010.Data.Layer.Repository.RabbitRepository;
import com.example.rmp101010.R;
import com.example.rmp101010.UI.Layer.viewmodel.MyViewModel;
import com.example.rmp101010.UI.Layer.viewmodel.ShowRViewModel;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThirdFragment extends Fragment {
    public ThirdFragment() {
        super(R.layout.thirdfragment);
    }
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private ShowRViewModel viewModel2;
    private MyViewModel myviewModel;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressBar progressBar=view.findViewById(R.id.progressbar);


        Button back = view.findViewById(R.id.goback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_secondFragment);
            }
        });
        Button go = view.findViewById(R.id.gotolist);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_fourthFragment);
            }
        });
        viewModel2 = new ViewModelProvider(requireActivity()).get(ShowRViewModel.class);
        //Наблюдаем за LiveData с кроликами и обновляем список
        AbsoluteLayout Layout = requireView().findViewById(R.id.thirdfrag);
        viewModel2.getRabbitListLiveData().observe(getViewLifecycleOwner(), new Observer<RabbitRepository>() {
            @Override
            public void onChanged(RabbitRepository rabbits) {
                for (int i = 0; i < Layout.getChildCount(); i++) {
                    View childView = Layout.getChildAt(i);
                    if (childView instanceof ImageView) {
                        Layout.removeView(childView);
                    }
                }
                for (int i=0;i<rabbits.getRabbits().size();i++) {
                    ImageView im = new ImageView(requireContext());
                    im.setImageResource(R.drawable.rabbit);
                    Random random = new Random();
                    int x = random.nextInt(1200);
                    int y = random.nextInt(2200);
                    AbsoluteLayout.LayoutParams params = new AbsoluteLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            x,
                            y
                    );
                    im.setLayoutParams(params);
                    Layout.addView(im);
                    im.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Random random = new Random();
                            int newX = random.nextInt(1200);
                            int newY = random.nextInt(2200);
                            AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) im.getLayoutParams();
                            params.x = newX;
                            params.y = newY;
                            im.setLayoutParams(params);
                        }
                    });
                }
            }
        });
        myviewModel=new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        Button del = view.findViewById(R.id.deleteR);
        TextView textview=view.findViewById(R.id.deleting);
        //int currentValue=0;
        myviewModel.getValue().observe(requireActivity(),value->{
            progressBar.setProgress(value);
            if(value!=0)textview.setText("Статус: "+value);
            if (value == 100 && getView() != null) {
                Navigation.findNavController(getView()).navigate(R.id.action_thirdFragment_to_trirdThirdFragment2);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Layout.getChildCount()!=5){
                    textview.setText("Статус: "+0);
                    progressBar.setVisibility(view.VISIBLE);
                    executorService.execute(() -> myviewModel.execute());
                }
                //Navigation.findNavController(requireView()).navigate(R.id.action_thirdFragment_to_trirdThirdFragment2);

                //if(int(myviewModel.getValue()==100)
                /*progressBar.setVisibility(view.VISIBLE);
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        for(;currentValue<=100;currentValue++){
                            try {
                                textview.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setProgress(currentValue);
                                        textview.setText("Статус: "+currentValue);
                                    }
                                });
                                Thread.sleep(50);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        view.post(new Runnable() {
                            @Override
                            public void run() {
                                Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_trirdThirdFragment2);
                            }
                        });
                    }
                };
                Thread thread=new Thread(runnable);
                thread.start();*/
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        executorService.shutdown();
    }
}
