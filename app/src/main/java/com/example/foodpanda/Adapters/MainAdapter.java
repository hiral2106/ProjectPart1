package com.example.foodpanda.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
    ArrayList<MainModel> vhList;
    Context vhContext;

    //******************Step-11**********************//
    //Right click and generate constructor


    public MainAdapter(ArrayList<MainModel> vhList, Context vhContext) {
        this.vhList = vhList;
        this.vhContext = vhContext;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //************Step -9*****************// INFLATING SAMPLE_MAINFOOD
        //Create view and fatch data from array list -- check step 10 --- add context in from()
        View view= LayoutInflater.from(vhContext).inflate(R.layout.sample_mainfood, parent, false);

        //************Step-12***************//
        //Return View
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        //**********************Step-13*************************//
        //After inflating view, we will bind data
        final MainModel model = vhList.get(position); //we can get and set data through position
       // Log.d("Set", "onBindViewHolder: set");
        holder.foodimage.setImageResource(model.getImage());
        holder.vhMainName.setText(model.getName());
        holder.vhPrice.setText(model.getPrice());
        holder.vhDescription.setText(model.getDescription());


        // set onclick when clicking on item
        //*********************Step -30**************Connecting activities using intent
//        holder.foodimage.setOnClickListener(new View.OnClickListener() {
////            Log.d("orderImg", "viewHolder: Image");
//
//            @Override
//            public void onClick(View v) {
//                Log.d("orderImg", "viewHolder: Image");
//                Intent intent = new Intent(vhContext, DetailActivity.class); //From activity_main to activity_detail
//                //add extras
//                intent.putExtra("image", model.getImage());
//                intent.putExtra("price", model.getPrice());
//                intent.putExtra("desc", model.getDescription());
//                intent.putExtra("name", model.getName());
//                vhContext.startActivity(intent); //Starting intent
//                // -- NEXT STEP: 31 go to DetailActivity.java for receiving data
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vhContext, DetailActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("desc", model.getDescription());
                intent.putExtra("name", model.getName());
                intent.putExtra("type",1);

                vhContext.startActivity(intent); //Starting intent
            }
        });


    }

    @Override
    public int getItemCount() {

        //*********************Step-14*************// ---------------Goto build.gradle for next step
        //Give size of array list
        return vhList.size();
    }


    //------------Step3-----------//
    public class viewholder extends RecyclerView.ViewHolder {

        //----------------Step5----------//
        //Declare all needed resources
            ImageView foodimage;
        TextView vhMainName, vhPrice, vhDescription;


        //--------------Step4---------------//
        //Click on Create constructor matching super

        public viewholder(@NonNull View itemView) {
            super(itemView);


            //***************Step-6*****************//
            //Find all resources by ID FROM SAMPLE_MAINFOOD XML
            foodimage= itemView.findViewById(R.id.imageViewSM);
            vhMainName = itemView.findViewById(R.id.nameSM);
            vhPrice = itemView.findViewById(R.id.order_priceSM);
            vhDescription = itemView.findViewById(R.id.descriptionSM);
        }
    }
}
