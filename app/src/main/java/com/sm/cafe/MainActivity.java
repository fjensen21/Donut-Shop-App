package com.sm.cafe;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private StoreOrders store = new StoreOrders();
    private Order currentOrder = new Order();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public StoreOrders getStore() {
        return store;
    }

    public void setStore(StoreOrders store) {
        this.store = store;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    /**
     * Handles order donut button clicked
     * @param view
     */
    public void orderDonutClicked(View view){
        Intent intent = new Intent(this, DonutsActivity.class);
        startActivity(intent);

    }

    /**
     * Handles order detail button clicked
     * @param view
     */
    public void viewOrderClicked(View view){
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    /**
     * Handles order coffee button clicked
     * @param view
     */
    public void storeOrderClicked(View view){
//        Intent intent = new Intent(this, .class);
//        startActivity(intent);
    }

    /**
     * Handles order coffee button clicked
     * @param view
     */
    public void orderCoffeeClicked(View view){
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivity(intent);
    }

    public static void displayMessage(Context context, @StringRes int id){
        Toast toast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
        toast.show();
    }
}