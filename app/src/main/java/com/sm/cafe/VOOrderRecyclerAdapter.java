package com.sm.cafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VOOrderRecyclerAdapter extends RecyclerView.Adapter<VOOrderRecyclerAdapter.VOViewHolder> {

    ArrayList<MenuItem> menuItems;

    public VOOrderRecyclerAdapter(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public VOOrderRecyclerAdapter.VOViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vo_order_item, parent, false);

        return new VOOrderRecyclerAdapter.VOViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VOOrderRecyclerAdapter.VOViewHolder holder, int position) {
        holder.getItemText().setText(menuItems.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public static class VOViewHolder extends RecyclerView.ViewHolder{
        private TextView itemText;

        public VOViewHolder(@NonNull View itemView) {
            super(itemView);

            //Initialize views
            itemText = itemView.findViewById(R.id.voOrderItemText);
        }

        public TextView getItemText() {
            return itemText;
        }
    }
}
