package com.sm.cafe;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Coffee c;

    private Switch creamSwitch;
    private Switch syrupSwitch;
    private Switch milkSwitch;
    private Switch caramelSwitch;
    private Switch whippedCreamSwitch;

    private Spinner sizeSpinner;
    private Spinner quantitySpinner;

    private Button addOrderButton;

    private TextView subtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        creamSwitch = findViewById(R.id.creamSwitch);
        whippedCreamSwitch = findViewById(R.id.whippedCreamSwitch);
        syrupSwitch = findViewById(R.id.syrupSwitch);
        milkSwitch = findViewById(R.id.milkSwitch);
        caramelSwitch = findViewById(R.id.caramelSwitch);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        quantitySpinner = findViewById(R.id.quantitySpinner);
        addOrderButton = findViewById(R.id.addOrderButton);
        subtotal = findViewById(R.id.subtotalCoffeeTextView);

        c = new Coffee();
        sizeSpinner = (Spinner) findViewById(R.id.sizeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.coffee_sizes, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeSpinner.setAdapter(adapter);
        sizeSpinner.setOnItemSelectedListener(this);

        quantitySpinner = (Spinner) findViewById(R.id.quantitySpinner);
        ArrayAdapter<CharSequence> quantityAdapter = ArrayAdapter.createFromResource(this, R.array.quantities, android.R.layout.simple_spinner_dropdown_item);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(quantityAdapter);
        quantitySpinner.setOnItemSelectedListener(this);

        updateSubtotal();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        switch(parent.getId()){
            case R.id.sizeSpinner:
                c.setCoffeeSize(Coffee.coffeeSizes[pos]);
                break;
            default:
                c.setQuantity(pos+1);
        }
        updateSubtotal();
    }

    public void onNothingSelected(AdapterView<?> parent){
        MainActivity.displayMessage(this, R.string.select_a_size);
    }

    /**
     * Handles switch toggles
     * @param view view
     */
    public void syrupSwitchToggled(View view){
        if(syrupSwitch.isChecked()){
            c.add(AddIn.SYRUP);
        } else {
            c.remove(AddIn.SYRUP);
        }
        updateSubtotal();
    }

    /**
     * Handles switch toggles
     * @param view view
     */
    public void whippedCreamSwitchToggled(View view){
        if(whippedCreamSwitch.isChecked()){
            c.add(AddIn.WHIPPEDCREAM);
        } else {
            c.remove(AddIn.WHIPPEDCREAM);
        }
        updateSubtotal();
    }
    /**
     * Handles switch toggles
     * @param view view
     */
    public void caramelSwitchToggled(View view){
        if(caramelSwitch.isChecked()){
            c.add(AddIn.CARAMEL);
        } else {
            c.remove(AddIn.CARAMEL);
        }
        updateSubtotal();
    }
    /**
     * Handles switch toggles
     * @param view view
     */
    public void milkSwitchToggled(View view){
        if(milkSwitch.isChecked()){
            c.add(AddIn.MILK);
        } else {
            c.remove(AddIn.MILK);
        }
        updateSubtotal();
    }
    /**
     * Handles switch toggles
     * @param view view
     */
    public void creamSwitchToggled(View view){
        if(creamSwitch.isChecked()){
            c.add(AddIn.CREAM);
        } else {
            c.remove(AddIn.CREAM);
        }
        updateSubtotal();
    }

    /**
     * Updates the subtotal
     */
    private void updateSubtotal(){
        subtotal.setText(String.format("$%,.2f", c.itemPrice()));
    }

    /**
     * Add to order button clicked
     * @param view v
     */
    public void addOrderClicked(View view){

        Intent resultIntent = new Intent();
        resultIntent.putExtra("coffee", c);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}