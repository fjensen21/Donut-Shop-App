package com.sm.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StoreOrdersActivity extends AppCompatActivity {

    StoreOrders store;
    RecyclerView ordersRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);

        ordersRecycler = findViewById(R.id.ordersRecyclerView);

        store = (StoreOrders) getIntent().getSerializableExtra("store");

        ordersRecycler.setLayoutManager(new LinearLayoutManager(this));
        OrderRecyclerAdapter adapter = new OrderRecyclerAdapter(store, this);
        ordersRecycler.setAdapter(adapter);
    }


    /**
     * Handles update button pressed
     * @param view
     */
    public void updateButtonClicked(View view){
        Intent results = new Intent();
        results.putExtra("updatedStore", store);
        setResult(Activity.RESULT_OK, results);
        finish();
    }
}