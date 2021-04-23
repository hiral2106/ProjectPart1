package com.example.foodpanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.LinearLayout;

import com.example.foodpanda.Adapters.OrdersAdapter;
import com.example.foodpanda.Models.OrdersModel;
import com.example.foodpanda.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class Order extends AppCompatActivity {
    //******************STEP-27*****************//

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_order); --- USE BINDING
        setContentView(binding.getRoot());

//       ArrayList<OrdersModel> list = new ArrayList<>();
//      list.add(new OrdersModel(R.drawable.momos,"Chicken Momos", "10", "11222106"));
//        list.add(new OrdersModel(R.drawable.veg_manchurian,"Veg Manchurian", "15", "11222107"));
//        list.add(new OrdersModel(R.drawable.friedmomos,"Fried Momos", "10", "11222108"));
//        list.add(new OrdersModel(R.drawable.fried_rice,"Fried Rice", "10", "11222109"));
//        list.add(new OrdersModel(R.drawable.hakkanoodles,"Hakka Noodles", "12", "11222104"));
//        list.add(new OrdersModel(R.drawable.sesame_chicken,"Sesame Chicken", "10", "11222105"));


        //**********************Step - 40 ***************************
        DBHelper helper = new DBHelper(this);
       ArrayList<OrdersModel> list = helper.getOrdersCart();  //get orders from dbhelper ---Array List issue


        //*********************STEP-28*******************// -- After this step go to manifest file and change default location of <intent-filter> from main activity to Order
        //-----next step --- DetailActivity.java
        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRecyclerView.setAdapter(adapter);
        //To display data in list
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}