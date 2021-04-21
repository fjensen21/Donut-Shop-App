package com.sm.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class DonutsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<Donut> donutsList = new ArrayList<>();
    Donut currentDonut = new Donut();

    RecyclerView donutsRecyclerView;
    DonutRecylerAdapter donutAdapter;

    TextView donutSubtotal;


    Spinner donutQuantitySpinner;
    Spinner donutTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donuts);

        donutSubtotal = findViewById(R.id.donutSubtotalText);

        donutsRecyclerView = findViewById(R.id.donutsRecyclerView);
        donutsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        donutAdapter = new DonutRecylerAdapter(donutsList);
        donutsRecyclerView.setAdapter(donutAdapter);
        donutAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                refreshSubtotal();
            }
        });


        donutQuantitySpinner = findViewById(R.id.donutQuantitySpinner);
        donutTypeSpinner = findViewById(R.id.donutTypeSpinner);

        ArrayAdapter<CharSequence> donutQuantityAdapter = ArrayAdapter.createFromResource(this, R.array.quantities, android.R.layout.simple_spinner_dropdown_item);
        donutQuantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        donutQuantitySpinner.setAdapter(donutQuantityAdapter);
        donutQuantitySpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> donutTypeAdapter = ArrayAdapter.createFromResource(this, R.array.donut_options, android.R.layout.simple_spinner_dropdown_item);
        donutTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        donutTypeSpinner.setAdapter(donutTypeAdapter);
        donutTypeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        switch(parent.getId()){
            case R.id.donutQuantitySpinner:
                currentDonut.setQuantity(pos+1);
                break;
            default:
                currentDonut.setFlavor(Donut.DONUT_FLAVORS[pos]);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        return;
    }

    /**
     * Handles add to donuts btn clicks
     * @param view view
     */
    public void addToDonutsClicked(View view){
        donutsList.add(currentDonut);
        currentDonut = new Donut();
        donutQuantitySpinner.setSelection(0);
        donutTypeSpinner.setSelection(0);
        donutAdapter.notifyDataSetChanged();
    }

    public void addToOrderClicked(View view){
        if(donutsList.isEmpty()){
            MainActivity.displayMessage(this, R.string.empty);
        } else {
            Intent resultsIntent = new Intent();
            resultsIntent.putExtra("donuts", donutsList);
            setResult(Activity.RESULT_OK, resultsIntent);
            finish();
        }
    }

    /**
     * Refreshes the subtotals for a given
     */
    private void refreshSubtotal(){
        double sub = 0;
        for(Donut d : donutsList){
            sub += d.itemPrice();
        }
        donutSubtotal.setText(String.format("$%,.2f", sub));
    }
}