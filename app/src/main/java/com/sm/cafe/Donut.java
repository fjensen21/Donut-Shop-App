/**
 * Represents a Donut with a type and flavor
 * @author finnjensen
 * @author ralphcherbaka
 */
package com.sm.cafe;

public class Donut extends MenuItem {
    final static double YEASTDONUTPRICE = 1.39;
    final static double DONUTHOLEPRICE = .33;
    final static double CAKEDONUTPRICE = 1.59;
    final static String[] DONUTTYPES = {"Yeast", "Hole", "Cake"};
    final static String[] YEASTFLAVORS = {"Glazed", "Boston Creme", "Matcha"};
    final static String[] HOLEFLAVORS = {"Blueberry", "Strawberry", "Durian"};
    final static String[] CAKEFLAVORS = {"Pumpkin", "Blackberry", "Banana"};

    private String type = null;    //"Yeast", "Hole", "Cake"
    private String flavor = null;

    /**
     * Calculates the donuts price
     * @return donut price
     */
    @Override
    public double itemPrice() {
        switch(type) {
            case "Yeast":
                return YEASTDONUTPRICE * super.getQuantity();
            case "Hole":
                return DONUTHOLEPRICE * super.getQuantity();
            default:
                return CAKEDONUTPRICE * super.getQuantity();
        }
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
        return flavor + " " + type + " " + "(" + super.getQuantity() + ")";
    }
}
