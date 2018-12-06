import java.text.DecimalFormat;
/**
 * This class organizes everything for a Motorcycle.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/05/17.
*/
public class Motorcycle extends Vehicle {
   protected double engineSize;
   
   /** Static variable for tax rate. **/
   public static final double TAX_RATE = .005;
   /** Static variable for alternative fuel tax rate. **/
   public static final double ALTERNATIVE_FUEL_TAX_RATE = .0025;
   /** Static variable for bike threshold. **/
   public static final double LARGE_BIKE_CC_THRESHOLD = 499;
   /** Static variable for large bike tax rate. **/
   public static final double LARGE_BIKE_TAX_RATE = .015;
   
   /**
    * Constructor.
    * @param nameIn name
    * @param ymmIn year make model
    * @param valueIn value
    * @param fuelIn fuel type
    * @param engineSizeIn engine size
    * @throws NegativeValueException checks to make sure numbers are positive
   */
   public Motorcycle(String nameIn, String ymmIn, double valueIn,
         boolean fuelIn, double engineSizeIn) throws NegativeValueException {
      super(nameIn, ymmIn, valueIn, fuelIn);
      if (engineSizeIn < 0) {
         vehicleCount--;
         throw new NegativeValueException();
      }
      else {
         engineSize = engineSizeIn;
      }
   }
   
   /**
    * Returns engine size.
    * @return engineSize engine size
   */
   public double getEngineSize() {
      return engineSize;
   }
   
   /**
    * Sets engine size.
    * @param engineSizeIn engine size
   */
   public void setEngineSize(double engineSizeIn) {
      engineSize = engineSizeIn;
   }
   
   /**
    * Returns taxes.
    * @return rate of all the tax rates
   */
   public double useTax() {
      double rate = 0.0;
      
      if (fuel) {
         rate = value * ALTERNATIVE_FUEL_TAX_RATE;
         
         if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
            rate += (value * LARGE_BIKE_TAX_RATE);
         } 
         return rate;  
      }
      else if (!fuel) {
         rate = 0.0;
         rate = value * TAX_RATE;
         
         if (value > LARGE_BIKE_CC_THRESHOLD) {
            rate += (value * LARGE_BIKE_TAX_RATE);
         }
         return rate;
      }
      return rate;
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
         
         if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
            output += " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE;
         }   
      }
      else if (!fuel) {
         output += "\nwith Tax Rate: " + TAX_RATE;
         
         if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
            output += " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE;
         }
      }
      return output;
   }
}