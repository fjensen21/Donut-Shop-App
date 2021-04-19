package com.sm.cafe;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private StoreOrders store = new StoreOrders();
    private Order currentOrder = new Order();

    public static int LAUNCH_COFFEE_CODE = 1;
    public static int LAUNCH_DONUTS_CODE = 2;

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
        startActivityForResult(intent, LAUNCH_DONUTS_CODE);

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
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        startActivity(intent);
    }

    /**
     * Handles order coffee button clicked
     * @param view
     */
    public void orderCoffeeClicked(View view){
        Intent intent = new Intent(this, CoffeeActivity.class);
        startActivityForResult(intent, LAUNCH_COFFEE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_COFFEE_CODE) {
            if(resultCode == Activity.RESULT_OK){
                Coffee cof = (Coffee) data.getSerializableExtra("coffee");
                MainActivity.displayMessage(this, String.valueOf(cof.getQuantity()));
                currentOrder.add(cof);
                MainActivity.displayMessage(this, R.string.app_name);

            }
        } else if (requestCode == LAUNCH_DONUTS_CODE) {
            ArrayList<Donut> donuts = (ArrayList<Donut>) data.getSerializableExtra("donuts");
            for(Donut d: donuts){
                currentOrder.add(d);
            }
            MainActivity.displayMessage(this, R.string.donuts_added);
        }
    }

    public static void displayMessage(Context context, @StringRes int id){
        Toast toast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void displayMessage(Context context, CharSequence st){
        Toast toast = Toast.makeText(context, st, Toast.LENGTH_SHORT);
        toast.show();
    }
}