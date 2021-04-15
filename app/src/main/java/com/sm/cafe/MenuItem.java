/**
 * Represents any menu item that can be ordered
 * @author finnjensen
 * @author ralphcherbaka
 */
package com.sm.cafe;

public abstract class MenuItem {
    int quantity = 0;

    /**
     * Gets the quantity for the menuitem
     * @return menu item quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity for a menu item
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the item price for an item
     * @return items price
     */
    public abstract double itemPrice();
}
