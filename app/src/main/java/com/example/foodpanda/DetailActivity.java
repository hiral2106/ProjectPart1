package com.example.foodpanda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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


        //**************STEP-31*************Getting extras from MainAdapter ---for next step MainAdapter.java
        final int image = getIntent().getIntExtra("image", 0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("desc");

        //Setting data on binding
        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d", price));
        binding.textView.setText(name);
        binding.detailDescription.setText(description);

        //***************STEP-37*************Next step 38 MainActivity.java to add menu.
        DBHelper helper = new DBHelper(this);

        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =  helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())
                );

                if (isInserted)
                    Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }

}