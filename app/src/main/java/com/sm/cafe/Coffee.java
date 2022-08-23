/**
 * Represents a Coffee. By default this is a Short Coffee with no addins
 * @author finnjensen
 */
package com.sm.cafe;


import java.io.Serializable;
import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable, Serializable {
    private ArrayList<AddIn> addins = new ArrayList<>();
    private int size;
    final static double ADDINCOST = .20;
    final static String[] coffeeSizes = {"Short", "Tall", "Grande", "Venti"};
    final static double COFFEEBASEPRICE =  1.99;
    final static double COFFEESIZEINCREASE = .50;


    /**
     * Instantiates a coffee w/ a quantity of 1 and a default size of Short
     */
    public Coffee() {
        //Set default size
        size = 0;

        //Set default quantity
        super.setQuantity(1);

    }

    /**
     * Adds an add in to this coffee
     * @param obj an addin enum
     * @return true if removed. false if doesn't exist
     */
    @Override
    public boolean add(Object obj) {
        if(!(obj instanceof AddIn)){ return false; }
        else {
            AddIn a = (AddIn) obj;
            if(addins.contains(a)){
                return false;
            } else {
                addins.add(a);
                return true;
            }
        }
    }

    /**
     * Removes an addin from the coffee
     * @param obj an addin enum
     * @return true if removed false if doesnt exist
     */
    @Override
    public boolean remove(Object obj) {
        if(!(obj instanceof AddIn)){ return false; }
        else {
            AddIn a = (AddIn) obj;
            return addins.remove(a);
        }
    }

    /**
     * Counts the number of addins selected.
     * @return the number of addins chosen
     */
    public int getNumAddins(){
        return addins.size();
    }

    /**
     * Returns the price of this Coffee
     * @return price of this coffee
     */
    @Override
    public double itemPrice() {
        //Calculate Add-ins
        double addinsPrice = getNumAddins() * ADDINCOST;

        //Calculate size cost
        double sizePrice = COFFEEBASEPRICE + (size * COFFEESIZEINCREASE);

        return (addinsPrice + sizePrice) * super.getQuantity();
    }

    /**
     * Sets the coffee size for this coffee using a valid coffee size code
     * @param sizeString a valid size String
     */
    public void setCoffeeSize(String sizeString){
        switch(sizeString){
            case "Short":
                size = 0;
                return;
            case "Tall":
                size = 1;
                return;
            case "Grande":
                size = 2;
                return;
            case "Venti":
                size = 3;
                return;
            default:
                return;
        }
    }


    /**
     * Represents the coffee class as a string
     * @return coffee string
     */
    @Override
    public String toString() {
        return coffeeSizes[size] + " Coffee " + "(" + super.getQuantity() + ") " + addins;
    }

}
