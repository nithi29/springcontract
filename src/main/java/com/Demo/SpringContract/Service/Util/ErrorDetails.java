package com.Demo.SpringContract.Service.Util;

import java.util.Date;

/**
 * Error details are set with message and timestamp.
 *
 */
public class ErrorDetails {

    private String error;
    private Date timestamp;

    /**
     * 
     * @param error error and date.
     */
    public ErrorDetails(String error) {
        this.error = error;
        this.timestamp = new Date();
    }

    /**
     * 
     * @return error message.
     */
    public String getError() {
        return error;
    }

    /**
     * 
     * @param error message.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 
     * @return timestamp.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp timestamp for the error.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
