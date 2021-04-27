package com.example.foodpanda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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

        final DBHelper helper = new DBHelper(this);


        //*********************STEP-42****************ADD IF CONDITION TO USE DETAILACTIVITY from cart--NEXT STEP DBHELPER

        if (getIntent().getIntExtra("type",0)==1) {
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
           // DBHelper helper = new DBHelper(this); --outside if loop

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );

                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Thank you. Your order has been placed.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error. Please try again", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else {
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor =helper.getOrderById(id);
           // Toast.makeText(this,cursor.getString(1), Toast.LENGTH_SHORT).show();
            int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.textView.setText(cursor.getString(7));
            binding.detailDescription.setText(cursor.getString(6));
            binding.quantity.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Now");

            ImageView addItem=(ImageView) findViewById(R.id.add);
            ImageView removeItem=(ImageView) findViewById(R.id.subtract);
            TextView quantity=(TextView) findViewById(R.id.quantity);
            int price=Integer.parseInt(binding.priceLbl.getText().toString())/Integer.parseInt(quantity.getText().toString());
            addItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Item_quantity=Integer.parseInt(quantity.getText().toString());
                    int new_value=Item_quantity+1;
                    quantity.setText(String.valueOf(new_value));
                    binding.priceLbl.setText(String.format("%d",price*new_value));
                    Log.d("TAG", "onClick: "+binding.priceLbl.getText().toString());
                    Log.d("TAG", "onClick: "+quantity.getText().toString());
                }
            });
            removeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int Item_quantity=Integer.parseInt(quantity.getText().toString());
                    int new_value;
                    Log.d("TAG", "onClick: "+price);
                    if(Item_quantity>1){
                    new_value=Item_quantity-1;
                    quantity.setText(String.valueOf(new_value));
                    binding.priceLbl.setText(String.format("%d",price*new_value));
                    }
                    else
                    {
                        Log.d("delete Not done", "onClick: quantity can not remove as it's minimum");
                    }
                }
            });



            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", "name: " + (binding.nameBox.getText().toString()));
                    Log.d("TAG", "phn: " + (binding.phoneBox.getText().toString()));
                    Log.d("TAG", "price: " + (binding.priceLbl.getText().toString()));
                    Log.d("TAG", "foodname: " + (binding.textView.getText().toString()));
                    Log.d("TAG", "FoodDesc: " + (binding.detailDescription.getText().toString()));
                    Log.d("quanitity", "quantity: "+Integer.parseInt(binding.quantity.getText().toString()));

                    boolean isUpdated = helper.updateOrder(binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.textView.getText().toString(),
                            binding.detailDescription.getText().toString(), Integer.parseInt(binding.quantity.getText().toString()),
                            id);
                    if (isUpdated)
                        Toast.makeText(DetailActivity.this, "updated", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

}