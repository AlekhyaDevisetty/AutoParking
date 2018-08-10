package com.epam.autoparking.exception;
/**
 * User defined Exception Vehicle NotFoundException.
 * @author Alekhya_Devisetty
 *
 */
public class VehicleNotFoundException  extends RuntimeException {
      /**
       * This is the default serialVersionUID.
       */
       private static final long serialVersionUID = 1L;

      /**
       * Exception to be thrown when the entered vehicle number is not found.
       * Overrides the toString method from the class Exception.
       * @return A string to be mentioned when this exception occurs
       */
      public String toString() {
        return "No Vehicle with the entered vehicle Number";
      }
}


