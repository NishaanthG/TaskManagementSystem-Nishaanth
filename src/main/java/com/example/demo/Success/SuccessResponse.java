package com.example.demo.Success;

/**
 * A class representing a success response that contains a code and a message.
 * This is typically used for sending successful responses from an API.
 */
public class SuccessResponse {
    
    /** The code representing the success status. */
    String code;
    
    /** The message providing additional information about the success. */
    String message;
    
    /**
     * Constructs a new SuccessResponse with the specified code and message.
     * 
     * @param code The success code.
     * @param message The success message.
     */
    public SuccessResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * Default constructor for creating an empty SuccessResponse.
     */
    public SuccessResponse() {
        super();
    }

    /**
     * Gets the code representing the success status.
     * 
     * @return The success code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code representing the success status.
     * 
     * @param code The success code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the message providing additional information about the success.
     * 
     * @return The success message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message providing additional information about the success.
     * 
     * @param message The success message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
