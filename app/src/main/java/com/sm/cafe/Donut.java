/**
 * Represents a Donut with a type and flavor
 * @author finnjensen
 */
package com.sm.cafe;

import java.io.Serializable;

public class Donut extends MenuItem implements Serializable {
    final static double DONUT_PRICE = 1.39;
    final static String[] DONUT_FLAVORS = {"Pumpkin", "Blackberry", "Banana"};

    private String type = null;    //"Yeast", "Hole", "Cake"
    private String flavor = null;

    public Donut() {
        super();
        setFlavor("Pumpkin");
        super.setQuantity(1);
    }

    public Donut(String s){
        super();
        flavor = "Glazed";
        super.setQuantity(2);
    }

    /**
     * Calculates the donuts price
     * @return donut price
     */
    @Override
    public double itemPrice() {
        return DONUT_PRICE;
    }

    /**
     * Sets the type for this donut
     * @param type a valid type key
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the flavor for this donut
     * @param flavor valid flavor
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Gets the type for this donut
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the flavor for this donut
     * @return flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Checks to see if all necesary fields are filled.
     * @return True if fields filled. False otherwise.
     */
    public boolean isCompleted(){
        if(flavor == null || type == null || super.getQuantity() == 0){
            return false;
        }
        return true;
    }

    /**
     * Represents the donut class as a string
     * @return donut string
     */
    @Override
    public String toString() {
        return flavor + " " + "(" + super.getQuantity() + ")";
    }
}
