package com.sm.cafe;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class StoreOrders implements Customizable, Serializable {


    private ArrayList<Order> ordersList = new ArrayList<>();


    /**
     * Gets the order at a given index
     * @param i an order index
     * @return the order
     */
    public Order getOrder(int i){
        return ordersList.get(i);
    }

    /**
     * Gets the store orders
     * @return the store orders
     */
    public ArrayList<Order> getOrdersList() {return ordersList; }

    /**
     * Gets the orderslist size
     * @return the amount of orders
     */
    public int getOrdersSize(){
        return ordersList.size();
    }

    /**
     * Adds an order to the store orders
     * @param obj an order
     * @return True if added false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(!(obj instanceof Order)){ return false; }
        else {
            Order o = (Order) obj;
            return ordersList.add(o);
        }
    }

    /**
     * Removes an order to the store orders
     * @param obj an order
     * @return True if removed false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if(!(obj instanceof Order)){ return false; }
        else {
            Order o = (Order) obj;
            return ordersList.remove(o);
        }
    }

    /**
     * Returns true if there are no store orders
     * @return True/False
     */
    public boolean isEmpty(){
        if(getOrdersSize() == 0){
            return true;
        }
        return false;
    }

    /**
     * Exports the current store order database to a txt file
     */
    public void exportDatabase(File file) throws IOException {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(file);
            for(int i = 0; i < ordersList.size(); i++){
                Order e = ordersList.get(i);
                pw.println(e.toString());
                for(int v = 0; v < e.getOrderItems().size(); v++ ){
                    pw.println(e.getOrderItems().get(v));
                }
                pw.println();
            }
        } finally{
            if(pw != null) {
                pw.close();
            }
        }
    }

}