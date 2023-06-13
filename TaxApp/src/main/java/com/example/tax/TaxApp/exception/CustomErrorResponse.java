/*
 * Creation : Jun 9, 2023
 */
package com.example.tax.TaxApp.exception;

public class CustomErrorResponse {

    private int statusCode;
    private String description;

    public CustomErrorResponse(int statusCode, String desciption) {
        this.statusCode = statusCode;
        this.description = desciption;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
