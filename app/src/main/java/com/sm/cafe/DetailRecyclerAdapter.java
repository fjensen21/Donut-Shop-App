package com.sm.cafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.OrderViewHolder>{

    private ArrayList<MenuItem> orderItems;


    public DetailRecyclerAdapter(ArrayList<MenuItem> orders){ orderItems = orders; }

    @NonNull
    @Override
    public DetailRecyclerAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailRecyclerAdapter.OrderViewHolder holder, int position) {

        holder.getOrderItemText().setText(orderItems.get(position).toString());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                orderItems.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderItemText;
        Button removeButton;


        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            orderItemText = itemView.findViewById(R.id.orderItemInfo);
            removeButton = itemView.findViewById(R.id.orderItemRemoveButton);
        }

        public TextView getOrderItemText() {
            return orderItemText;
        }

        public Button getRemoveButton() {
            return removeButton;
        }
    }
}
