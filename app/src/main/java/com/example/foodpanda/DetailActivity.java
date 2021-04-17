package com.example.foodpanda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.foodpanda.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    //****************STEP- 29***********using data binding
    //---go to MainAdapter.java for next step

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //**************STEP-31*************Getting extras from MainAdapter
        int image = getIntent().getIntExtra("image", 0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d", price));
        binding.nameBox.setText(name);
        binding.detailDescription.setText(description);
    }
}