/**
 * This class organizes everything for a SemiTractorTruck.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class SemiTractorTrailer extends Truck {
   protected int axles;
   /** Static variable for axle tax rate. **/
   public static final double PER_AXLE_TAX_RATE = .005;
   
   /**
    * Constructor.
    * @param nameIn name
    * @param ymmIn year make model
    * @param valueIn value
    * @param fuelIn fuel type
    * @param tonsIn tons
    * @param axlesIn axles
   */
   public SemiTractorTrailer(String nameIn, String ymmIn, double valueIn,
               boolean fuelIn, double tonsIn, int axlesIn) {
      super(nameIn, ymmIn, valueIn, fuelIn, tonsIn);
      axles = axlesIn;
   }
   
   /**
    * Returns the total axles.
    * @return axles total axles
   */
   public int getAxles() {
      return axles;
   }
   
   /**
    * Sets axles.
    * @param axlesIn total axles
   */
   public void setAxles(int axlesIn) {
      axles = axlesIn;
   }
   
   /**
    * Returns the total tax.
    * @return rate for the tax
   */
   public double useTax() {
      double total = 0;
      total = super.useTax() + (value * (axles * PER_AXLE_TAX_RATE));
      return total;
   }
   
   /**
    * Returns toString.
    * @return output with new taxes
   */
   public String toString() {
      String output = "";
      
      output = super.toString() + " Axle Tax Rate: "
         + (axles * PER_AXLE_TAX_RATE);
      
      return output;
   }

}