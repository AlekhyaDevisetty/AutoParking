package com.epam.autoparking.exception;
/**
 * User defined exception SlotEmptyException.
 * @author Alekhya_Devisetty
 *
 */
public class SlotEmptyException extends RuntimeException {

    /**
     * Overrides the toString method from the class Exception.
     * @return A string to be mentioned when this exception occurs
     */

public String toString() {
       return "PARKING SLOT IS EMPTY";
}
}
