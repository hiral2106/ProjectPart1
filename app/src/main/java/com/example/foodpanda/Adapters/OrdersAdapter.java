package com.example.foodpanda.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.price.setText(model.getPrice());
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
            orderImage=itemView.findViewById(R.id.orderImage);
            Log.d("orderImg", "viewHolder: Image");
            soldItemName=itemView.findViewById(R.id.orderItemName);
            Log.d("soldItemName",""+soldItemName);
            orderNumber=itemView.findViewById(R.id.orderNumber);
            Log.d("orderNumber",""+orderNumber);
            price=itemView.findViewById(R.id.orderS_price);
            Log.d("price",""+price);
        }
    }
}
