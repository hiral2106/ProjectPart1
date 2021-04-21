package com.example.foodpanda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodpanda.Models.OrdersModel;

import java.util.ArrayList;

//***********************STEP-33*********************CREATING DATABASE----
public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 2; //TO UPDATE VERSION OF DB

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //******************STEP-34*********************CREATING TABLE

        sqLiteDatabase.execSQL("create table orders" +
                "(id integer primary key autoincrement," +
                "name text, " +
                "phone text, " +
                "price int,"+
                "image int,"+
                "quantity int,"+
                "description text,"+
                "foodname text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //*******************STEP-35*******************This will create new table and drop old table every time when there are any changes in db table.
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity){

        //********************STEP-36*************Inserting data ---Next setp 37 -- DetailActivity.java
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name); // Key value pair. --value should be same as db
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodName);
        values.put("quantity", quantity);
        long id = database.insert("orders", null, values);

        if (id<=0){
            return false;
        }else {
            return true;
        }

    }

    //***************************STEP - 39 *****************FOR STEP 40-- Orders.java

    public ArrayList<OrdersModel> getOrdersCart(){
        ArrayList<OrdersModel> ordersFromCart = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        //cursor is to go through all rows one by one in database to show all values using select query.
        Cursor cursor = database.rawQuery("Select id, foodname, image, price from orders", null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumberOS(cursor.getInt(0)+"");
                model.setSoldItemNameOS(cursor.getString(1));
                model.setOrderImageOS(cursor.getInt(2));
                model.setPriceOS(cursor.getInt(3)+"");
                ordersFromCart.add(model);
            }
        }
        cursor.close();
        database.close();
        return ordersFromCart;

    }
}
