package com.Demo.SpringContract.Service.Util;
/**
 * Exception arise when there is no expected data in the database.
 */

public class NoSuchElementException extends Exception {

    private static final long serialVersionUID = 1L;
    /**
     * 
     * @param message No Data Found.
     */
    public NoSuchElementException(String message) {
        super(message);
    }

}
