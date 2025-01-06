package com.example.demo.Exception;

/**
 * A class representing an error response that contains a code and a message.
 * This is typically used for sending error details from an API response.
 */
public class ErrorResponse {

    /** The code representing the error status. */
    String code;

    /** The message providing additional information about the error. */
    String message;

    /**
     * Constructs a new ErrorResponse with the specified code and message.
     * 
     * @param code The error code.
     * @param message The error message.
     */
    public ErrorResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * Default constructor for creating an empty ErrorResponse.
     */
    public ErrorResponse() {
        super();
    }

    /**
     * Gets the code representing the error status.
     * 
     * @return The error code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code representing the error status.
     * 
     * @param code The error code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the message providing additional information about the error.
     * 
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message providing additional information about the error.
     * 
     * @param message The error message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
