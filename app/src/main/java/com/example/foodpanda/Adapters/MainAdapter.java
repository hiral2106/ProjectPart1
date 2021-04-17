package com.example.foodpanda.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodpanda.DetailActivity;
import com.example.foodpanda.Models.MainModel;
import com.example.foodpanda.R;

import java.util.ArrayList;


//***************************Step-7*************************//
//Extend RecyclerView.Adapter<>

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    //*******************Step-8****************************//
    // Click on Implement methods

    //********************Step-10************************//
    ArrayList<MainModel> list;
    Context context;

    //******************Step-11**********************//
    //Right click and generate constructor


    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //************Step -9*****************//
        //Create view and fatch data from array list -- check step 10 --- add context in from()
        View view= LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent, false);

        //************Step-12***************//
        //Return View
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        //**********************Step-13*************************//
        //After inflating view, we will bind data
        final MainModel model = list.get(position); //we can get and set data through position
        holder.foodimage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());


        //*********************Step -30**************Connecting activities using intent
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class); //From activity_main to activity_detail
                //add extras
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("desc", model.getDescription());
                intent.putExtra("name", model.getName());
                context.startActivity(intent); //Starting intent
                // -- NEXT STEP: go to DetailActivity.java for receiving data
            }
        });


    }

    @Override
    public int getItemCount() {

        //*********************Step-14*************// ---------------Goto build.gradle for next step
        //Give size of array list
        return list.size();
    }


    //------------Step3-----------//
    public class viewholder extends RecyclerView.ViewHolder {

        //----------------Step5----------//
        //Declare all needed resources
        ImageView foodimage;
        TextView mainName, price, description;


        //--------------Step4---------------//
        //Click on Create constructor matching super

        public viewholder(@NonNull View itemView) {
            super(itemView);


            //***************Step-6*****************//
            //Find all resources by ID
            foodimage= itemView.findViewById(R.id.imageView);
            mainName= itemView.findViewById(R.id.name);
//            price= itemView.findViewById(R.id.orderS_price);
            description= itemView.findViewById(R.id.description);
        }
    }
}
