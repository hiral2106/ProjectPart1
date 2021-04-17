package com.example.foodpanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodpanda.Adapters.MainAdapter;
import com.example.foodpanda.Models.MainModel;
import com.example.foodpanda.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //******************Step-16******************//
    //Making use of bindings
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //**************STEP-17*******************//
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //************STEP-18******************//
        //Write binding.getroot to access data binding instead of finding it by R.ID
        //---------------Remove this-------------setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        //*********************STEP-18******************//
        //Create array list for recycler view
        ArrayList<MainModel> list = new ArrayList<>();
        //Add vales to arraylist

        list.add(new MainModel(R.drawable.momos, "Chicken Momos", "7", "Chicken mince flavoured with soy sauce, chilies, pepper are stuffed inside a thin flour dough filling and then steamed."));
        list.add(new MainModel(R.drawable.friedmomos, "Fried Momos", "10", "Momos made with a chicken filling, first steamed and then deep fried."));
        list.add(new MainModel(R.drawable.hakkanoodles, "Hakka Noodles", "11", "Thin, flat noodles made from unleavened dough made with rice or wheat flour,  tossed with your favorite veggies and sauces."));
        list.add(new MainModel(R.drawable.veg_manchurian, "Veg Manchurian", "15", "Indo-Chinese dish made with wisps of vegetables formed into dumplings and dunked into a sauce that explodes with hot, sweet, sour and salty flavors."));
        list.add(new MainModel(R.drawable.sesame_chicken, "Sesame Chicken", "13", "Battered chicken fried in a pan and coated with sesame sauce."));
        list.add(new MainModel(R.drawable.fried_rice, "Fried Rice", "10", "Cooked rice that has been stir-fried in a wok or a frying pan and mixed with other ingredients such as eggs, vegetables, seafood."));

        //****************STEP-19************************//
        //Set adapter using binding view
        MainAdapter adapter= new MainAdapter(list, this);
        binding.recycleview.setAdapter(adapter);

        //Show layoutmanager which layout we want
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleview.setLayoutManager(layoutManager);

        //Till Step 19 -- we have create one design(activity), created model class and added setters getters and constructor
        //Then created adapter and in adapter we created one class "viewholder". Then infalted layout and bind data.
        //Added list size and added data in arraylist, used adapter and set linear layout
        //After that we created Order Layout(order_sample.xml) and OrdersModele.java class   ----Next Step 20
    }
}