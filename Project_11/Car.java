import java.text.DecimalFormat;
/**
 * This class organizes everything for a Car.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/05/17.
*/
public class Car extends Vehicle {
   
   /** Static varaible for tax rate. **/
   public static final double TAX_RATE = .01;
   /** Static varaible for alternative tax rate. **/
   public static final double ALTERNATIVE_FUEL_TAX_RATE = .005;
   /** Static varaible for luxury threshold. **/
   public static final double LUXURY_THRESHOLD = 50000;
   /** Static varaible for luxury tax rate. **/
   public static final double LUXURY_TAX_RATE = .02;
   
   /**
    * Constructor.
    * @param nameIn name
    * @param ymmIn year make model
    * @param valueIn value
    * @param fuelIn fuel type
    * @throws NegativeValueException checks to make sure numbers are positive
   */
   public Car(String nameIn, String ymmIn, double valueIn, boolean fuelIn)
               throws NegativeValueException {
      super(nameIn, ymmIn, valueIn, fuelIn);
   }
   
   /**
    * Returns the total tax.
    * @return rate for the tax
   */
   public double useTax() {
      double rate = 0.0;
      
      if (fuel) {
         rate = value * ALTERNATIVE_FUEL_TAX_RATE;
         
         if (value > LUXURY_THRESHOLD) {
            rate += (value * LUXURY_TAX_RATE);
         } 
         return rate;  
      }
      else if (!fuel) {
         rate = 0.0;
         rate = value * TAX_RATE;
         
         if (value > LUXURY_THRESHOLD) {
            rate += (value * LUXURY_TAX_RATE);
         }
         return rate;
      }
      return 0;
   }
   
   /**
    * Returns toString.
    * @return output of everything formatted
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");

      String output = "";
      output += super.toString();
      
      if (fuel) {
         output += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
         
         if (value > LUXURY_THRESHOLD) {
            output += " Luxury Tax Rate: " + LUXURY_TAX_RATE;
         }   
      }
      else if (!fuel) {
         output += "\nwith Tax Rate: " + TAX_RATE;
         
         if (value > LUXURY_THRESHOLD) {
            output += " Luxury Tax Rate: " + LUXURY_TAX_RATE;
         }
      }
      return output;
   }
}