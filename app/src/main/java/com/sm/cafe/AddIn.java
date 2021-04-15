package com.sm.cafe;

public enum AddIn {
    CREAM("Cream"),
    SYRUP("Syrup"),
    MILK("Milk"),
    CARAMEL("Caramel"),
    WHIPPEDCREAM("Whipped Cream");

    String addInName;

    AddIn(String s){
        this.addInName = s;
    }

    @Override
    public String toString() {
        return this.addInName;
    }
}
