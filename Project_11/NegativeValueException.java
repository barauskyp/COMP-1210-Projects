/**
 * NegativeValueException.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/05/17.
*/
public class NegativeValueException extends Exception {
   
   /** Sets up message when exception is thrown. */
   public NegativeValueException() {
      super("Numeric values must be nonnegative");
   }
   
   
}