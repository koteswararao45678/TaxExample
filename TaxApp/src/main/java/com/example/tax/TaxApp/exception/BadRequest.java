/*
 * Creation : Jun 9, 2023
 */
package com.example.tax.TaxApp.exception;

public class BadRequest extends Exception {
    private static final long serialVersionUID = 1L;

    public BadRequest(int i, String msg) {
        super(msg);
    }
}