package com.sm.cafe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.StoreOrdersViewHolder> {

    StoreOrders orders;
    Context c;

    public OrderRecyclerAdapter(StoreOrders orders, Context c){
        this.orders = orders;
        this.c = c;
    }

    @NonNull
    @Override
    public OrderRecyclerAdapter.StoreOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);

        return new StoreOrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderRecyclerAdapter.StoreOrdersViewHolder holder, int position) {
        holder.getOrderTextInfo().setText(orders.getOrdersList().get(position).toString());

        holder.getRemoveButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                orders.remove(orders.getOrder(position));
                notifyDataSetChanged();
            }
        });

        holder.getViewButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent i = new Intent(c , VOOrderDetailsActivity.class);
                i.putExtra("orderInfo", orders.getOrdersList().get(position));
                c.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.getOrdersSize();
    }

    public static class StoreOrdersViewHolder extends RecyclerView.ViewHolder{
        private Button removeButton;
        private Button viewButton;

        TextView orderTextInfo;

        public StoreOrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            viewButton = itemView.findViewById(R.id.viewOrderButton);
            removeButton = itemView.findViewById(R.id.removeOrderButton);
            orderTextInfo = itemView.findViewById(R.id.orderItemTextView);
        }

        public Button getRemoveButton() {
            return removeButton;
        }

        public TextView getOrderTextInfo() {
            return orderTextInfo;
        }

        public Button getViewButton() {
            return viewButton;
        }
    }

}
