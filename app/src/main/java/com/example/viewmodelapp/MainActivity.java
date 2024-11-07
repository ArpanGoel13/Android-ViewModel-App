package com.example.viewmodelapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodelapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        mainBinding.setMyViewModel(viewModel);

        viewModel.getCounter().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        mainBinding.textView2.setText(""+integer );
                    }
                });

    }
}