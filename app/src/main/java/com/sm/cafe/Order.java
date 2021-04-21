/**
 * Represents an order
 */
package com.sm.cafe;


import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Customizable, Serializable {
    private static int nextOrderNumber = 1;
    private int orderNumber;
    public static final double TAX_RATE = .06625;
    private ArrayList<MenuItem> orderItems = new ArrayList<>();
    /**
     * Instatiates an order class with an order number
     */
    public Order(){
        //Set orderNumber
        orderNumber = nextOrderNumber;
        nextOrderNumber++;
    }

    /**
     * Removes a MenuItem from the order
     * @param obj a menu item
     * @return true if removed false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(!(obj instanceof MenuItem)){ return false; }
        else {
            MenuItem item =  (MenuItem) obj;
            return orderItems.add(item);
        }
    }

    /**
     * Gets the order number for this order
     * @return order number
     */
    public int getOrderNumber(){
        return orderNumber;
    }

    /**
     * Adds a MenuItem to the order
     * @param obj a menuitem
     * @return True if item removed. False otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        return orderItems.remove(obj);
    }

    /**
     * Method for determining equality of two ordersf
     * @param obj an order to compare
     * @return true if equal false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Order)) return false;
        Order o = (Order) obj;
        if(this == o) return true;
        if(this.orderNumber == o.getOrderNumber()) return true;
        return false;
    }

    public ArrayList<MenuItem> getOrderItems(){
        return orderItems;
    }

    /**
     * Returns true if there are no orders
     * @return True/False
     */
    public boolean isEmpty(){
        if(orderItems.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Gets the order total including tax
     * @return order total
     */
    public double getOrderTotal(){
        double sub = 0;
        double t = 0;
        double tot = 0;

        //calculate subtotal
        for(int i = 0; i < orderItems.size(); i++){
            sub += orderItems.get(i).itemPrice();
        }

        t = sub * Order.TAX_RATE;

        tot = sub + t;
        return tot;
    }

    @Override
    public String toString() {
        return "Order{"+ orderNumber +
                '}';
    }
}
