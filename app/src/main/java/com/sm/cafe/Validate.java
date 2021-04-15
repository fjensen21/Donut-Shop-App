
package com.sm.cafe;

/**
 * Collection of static methods to validate certain inputs
 */
public class Validate {
    /**
     * Static method that checks string to see if it is numeric
     *
     * @param str String to convert to number
     * @return True if string is all numerical, false otherwise
     */
    public static boolean isValidNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Static method that checks string to see if it is integer
     *
     * @param str String to convert to integer
     * @return True if string is all integer, false otherwise
     */
    public static boolean isValidInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
