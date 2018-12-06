/**
 * This class organizes everything for a Truck.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class Truck extends Vehicle {

   /** Static variable for tax rate. **/
   public static final double TAX_RATE = .02;
   /** Static variable for alternative fuel tax rate. **/
   public static final double ALTERNATIVE_FUEL_TAX_RATE = .01;
   /** Static variable for tons threshold. **/
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
   /** Static variable for large truck tax rate. **/
   public static final double LARGE_TRUCK_TAX_RATE = .03;
   
   protected double tons;
   
   /**
    * Constructor.
    * @param nameIn name
    * @param ymmIn year make model
    * @param valueIn value
    * @param fuelIn fuel type
    * @param tonsIn tons
   */
   public Truck(String nameIn, String ymmIn, double valueIn, boolean fuelIn,
                  double tonsIn) {
      super(nameIn, ymmIn, valueIn, fuelIn);
      tons = tonsIn;
   }
   
   /**
    * Returns tons.
    * @return tons tons
   */
   public double getTons() {
      return tons;
   }
   
   /**
    * Sets the tons.
    * @param tonsIn tons
   */
   public void setTons(double tonsIn) {
      tons = tonsIn;
   }
   
   /**
    * Returns the total tax.
    * @return rate for the tax
   */
   public double useTax() {
      double rate = 0.0;
      
      if (fuel) {
         rate = value * ALTERNATIVE_FUEL_TAX_RATE;
         
         if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
            rate += (value * LARGE_TRUCK_TAX_RATE);
         } 
         return rate;  
      }
      else if (!fuel) {
         rate = 0.0;
         rate = value * TAX_RATE;
         
         if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
            rate += (value * LARGE_TRUCK_TAX_RATE);
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
      String output = "";
      output += super.toString();
      
      if (fuel) {
         output += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
         
         if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
            output += " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE;
         }   
      }
      else if (!fuel) {
         output += "\nwith Tax Rate: " + TAX_RATE;
         
         if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
            output += " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE;
         }
      }
      return output;
   }
}