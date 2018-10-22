package com.Demo.SpringContract.Service.Util;
/**
 * Application Exception class used to handle Validation exceptions.
 *
 */

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     *  Application Exception used for validation check.
     * @param message Exception.
     */
    public ApplicationException(String message) {
        super(message);
    }
}
