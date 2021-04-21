package com.sm.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class VOOrderDetailsActivity extends AppCompatActivity {

    RecyclerView orderItemsRecyler;
    TextView orderName;
    Order order;

    TextView voItemsSubtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_o_order_details);

        voItemsSubtotal = findViewById(R.id.voItemSubtotal);

        orderItemsRecyler = findViewById(R.id.orderItemsRecyler);

        order = (Order) getIntent().getSerializableExtra("orderInfo");

        //Setup Recycler View
        orderItemsRecyler.setLayoutManager(new LinearLayoutManager(this));
        VOOrderRecyclerAdapter voAdapter = new VOOrderRecyclerAdapter(order.getOrderItems());
        orderItemsRecyler.setAdapter(voAdapter);


        orderName = findViewById(R.id.orderName);
        orderName.setText(order.toString());

        refreshSubtotal();
    }

    /**
     * Refreshes the subtotals for a given
     */
    private void refreshSubtotal(){
        double sub = 0;
        for(MenuItem i : order.getOrderItems()){
            sub += i.itemPrice();
        }
        voItemsSubtotal.setText(String.format("$%,.2f", sub));
    }


}