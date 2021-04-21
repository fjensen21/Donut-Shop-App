package com.sm.cafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonutRecylerAdapter extends RecyclerView.Adapter<DonutRecylerAdapter.ViewHolder> {

    private ArrayList<Donut> donuts;

    public DonutRecylerAdapter(ArrayList<Donut> donutsList){
        donuts = donutsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donut_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getDonutItemText().setText(donuts.get(position).toString());

        holder.donutRemoveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                donuts.remove(position);
                notifyDataSetChanged();
            }
        });
    }
    

    @Override
    public int getItemCount() {
        return donuts.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView donutItemText;
        private Button donutRemoveButton;


        public ViewHolder(View view){
            super(view);
            //define click listener for the ViewHolder's View

            donutItemText = view.findViewById(R.id.donutItemText);
            donutRemoveButton = view.findViewById(R.id.donutRemoveButton);
        }



        public TextView getDonutItemText() {
            return donutItemText;
        }

        public Button getDonutRemoveButton() {
            return donutRemoveButton;
        }
    }


}
