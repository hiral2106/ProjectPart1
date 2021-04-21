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
import com.example.foodpanda.Models.OrdersModel;
import com.example.foodpanda.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{ //************Step-22***************//extend class and implement methods


    //*****************STEP 23******************//
    ArrayList<OrdersModel> list;
    Context context;
    //generate constructor

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //***********************STEP 24****************Inflate layout//
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        //******************Step 26***************// --- for next step go to Order.java
        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderImageOS());
        holder.soldItemName.setText(model.getSoldItemNameOS());
        holder.orderNumber.setText(model.getOrderNumberOS());
        holder.price.setText(model.getPriceOS());
    }

    @Override
    public int getItemCount() {
        //********************Step25*********************return size of list//
        return list.size();
    }

    //**********************Step-21*********************//
    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderImage;
        TextView soldItemName, orderNumber, price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage=itemView.findViewById(R.id.orderImageOS);
            Log.d("orderImg", "viewHolder: Image");
            soldItemName=itemView.findViewById(R.id.orderItemNameOS);
            Log.d("soldItemName",""+soldItemName);
            orderNumber=itemView.findViewById(R.id.orderNumberOS);
            Log.d("orderNumber",""+orderNumber);
            price=itemView.findViewById(R.id.order_priceOS);
            Log.d("price",""+price.getText().toString());


            //Code without using holder -- for activity detail link
            itemView.setOnClickListener(new View.OnClickListener() {
             @Override
                public void onClick(View v) {
                    Log.d("orderImg", "viewHolder: Image");
                    Intent intent = new Intent(context, DetailActivity.class); //From activity_main to activity_detail

                    //add extras
                    intent.putExtra("image", ""+orderImage.getDrawable());
                    intent.putExtra("price", ""+price.getText().toString());
                    intent.putExtra("desc","desc");
                    intent.putExtra("name", ""+soldItemName.getText().toString());
                    context.startActivity(intent); //Starting intent
                    // -- NEXT STEP: 31 go to DetailActivity.java for receiving data
                }
            });
        }
    }
}
