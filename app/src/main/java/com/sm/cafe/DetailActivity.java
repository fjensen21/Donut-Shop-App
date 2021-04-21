package com.sm.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Order order;

    RecyclerView orderItemsRecyler;
    TextView totalTextView;
    TextView taxTextView;
    TextView subtotalTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        order = (Order) getIntent().getSerializableExtra("order");


        orderItemsRecyler = findViewById(R.id.orderItemRecyclerView);
        totalTextView = findViewById(R.id.totalTextView);
        subtotalTextView = findViewById(R.id.subtotalTextView);
        taxTextView = findViewById(R.id.taxTextView);

        orderItemsRecyler.setLayoutManager(new LinearLayoutManager(this));
        DetailRecyclerAdapter detailAdapter = new DetailRecyclerAdapter(order.getOrderItems());
        detailAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                refreshTotals();
            }
        });
        orderItemsRecyler.setAdapter(detailAdapter);

        refreshTotals();
    }



    /**
     * Handles place order button clicked.
     * @param view view
     */
    public void placeOrderClicked(View view){
        Intent result = new Intent();
        result.putExtra("updatedOrder", order);
        setResult(RESULT_OK, result);
        finish();
    }

    /**
     * Refreshes the subtotal, tax and total
     */
    public void refreshTotals(){
        double subtotal = 0;
        double total = 0;
        double tax = 0;

        for(MenuItem item: order.getOrderItems()){
            subtotal += item.itemPrice();
        }

        tax = Order.TAX_RATE * subtotal;

        total = subtotal + tax;

        subtotalTextView.setText(String.format("$%,.2f", subtotal));
        totalTextView.setText(String.format("$%,.2f", total));
        taxTextView.setText(String.format("$%,.2f", tax));
    }
}