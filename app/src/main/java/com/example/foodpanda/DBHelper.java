package com.example.foodpanda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.foodpanda.Models.OrdersModel;

import java.util.ArrayList;

//***********************STEP-33*********************CREATING DATABASE----
public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydb.db";
    final static int DBVERSION = 1; //TO UPDATE VERSION OF DB

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

    public boolean insertOrder(String name, String phone, int price, int image, String foodName, String desc, int quantity){

        //********************STEP-36*************Inserting data ---Next setp 37 -- DetailActivity.java
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /* id=0
        name =1
        phone=2
        price=3
        image=4
        desc=5
        foodname=6
        quantity =7
         */

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
        Log.d("TAG", "inside array: ");
        //cursor is to go through all rows one by one in database to show all values using select query.
        Cursor cursor = database.rawQuery("Select id, foodname, image, price from orders", null);
        if (cursor.moveToFirst()){
            Log.d("TAG", "inside array: if ");

            Log.d("TAG", "getOrdersCart: "+cursor.getColumnCount());
            while (cursor.moveToNext()){
//                Log.d("TAG", "inside array: if : while ");
                OrdersModel model = new OrdersModel();
                model.setOrderNumberOS(cursor.getInt(0)+"");
//                Log.d("no.", "getOrdersCart: "+model.getOrderNumberOS());
                model.setSoldItemNameOS(cursor.getString(1));
//                Log.d("name.", "getOrdersCart: "+model.getSoldItemNameOS());
                model.setOrderImageOS(cursor.getInt(2));
//                Log.d("name.", "getOrdersCart: "+model.getSoldItemNameOS());
                model.setPriceOS(cursor.getInt(3)+"");
                ordersFromCart.add(model);
            }
        }
        cursor.close();
        database.close();
        return ordersFromCart;
    }

    // ********************STEP-43********************NEXT STEP- DETAILACTIVITY
    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Log.d("TAG", "inside array: ");
        //cursor is to go through all rows one by one in database to show all values using select query.
        Cursor cursor = database.rawQuery("Select * from orders where id = "+ id, null);

        if (cursor!= null)
            cursor.moveToFirst();

        return cursor;
    }

    public boolean updateOrder(String name, String phone, int price, int image, String foodName, String desc, int quantity, int id){

        //********************STEP-36*************Inserting data ---Next setp 37 -- DetailActivity.java
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /* id=0
        name =1
        phone=2
        price=3
        image=4
        desc =5
        foodname=6
        quantity =7
         */

        values.put("name", name); // Key value pair. --value should be same as db
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodName);
        values.put("quantity", quantity);
        long row = database.update("orders", values, "id="+id, null);

        if (row<=0){
            return false;
        }else {
            return true;
        }

    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id="+id, null);
    }

}
