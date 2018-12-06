import java.text.DecimalFormat;
/**
 * This abstract class has all the basics to build
 * a vehicle.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/05/17.
*/
public abstract class Vehicle implements Comparable<Vehicle> {
   protected String name;
   protected String yearMakeModel;
   protected double value;
   protected boolean fuel;
   
   protected static int vehicleCount;
    
   /**
    * Constructor.
    * @param nameIn name
    * @param ymmIn year make model
    * @param valueIn value
    * @param fuelIn fuel type
    * @throws NegativeValueException checks to make sure numbers are positive
   */  
   public Vehicle(String nameIn, String ymmIn, double valueIn, boolean fuelIn)
                  throws NegativeValueException {
      new NegativeValueException();
      name = nameIn;
      yearMakeModel = ymmIn;
      if (valueIn < 0.0) {
         vehicleCount--;
         throw new NegativeValueException();
      }
      else {
         value = valueIn;
      }
      fuel = fuelIn;
      
      vehicleCount++;
   } 
   
   /**
    * Returns the name.
    * @return name owner
   */
   public String getOwner() {
      return name;
   }
   
   /**
    * Sets owner.
    * @param nameIn owner
   */
   public void setOwner(String nameIn) {
      name = nameIn;
   }
   
   /**
    * Returns year make model.
    * @return yearMakeModel ymm
   */
   public String getYearMakeModel() {
      return yearMakeModel;
   }
   
   /**
    * Sets year make model.
    * @param ymm year make model
   */
   public void setYearMakeModel(String ymm) {
      yearMakeModel = ymm;
   }
   
   /**
    * Returns value of car.
    * @return value value of car
   */
   public double getValue() {
      return value;
   }
   
   /**
    * Sets value.
    * @param valueIn value of car
   */
   public void setValue(double valueIn) {
      value = valueIn;
   }
   
   /**
    * Returns fuel type.
    * @return fuel fuel type
   */
   public boolean getAlternativeFuel() {
      return fuel;
   }
   
   /**
    * Sets fuel type.
    * @param fuelIn fuel type
   */
   public void setAlternativeFuel(boolean fuelIn) {
      fuel = fuelIn;
   }
   
   /**
    * Returns number of vehicles.
    * @return vehicleCount count
   */
   public static int getVehicleCount() {
      return vehicleCount;
   }
   
   /**
    * Resets vehicle count.
   */
   public static void resetVehicleCount() {
      vehicleCount = 0;
   }
   
   /**
    * Static method useTax.
    * @return double
   */
   public abstract double useTax();
   
   /**
    * Returns toString.
    * @return output of everything formatted
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");

      String output = "";
      
      if (fuel) {
         output += name + ": " + this.getClass().getName() + " "
            + yearMakeModel + " (Alternative Fuel)";
         output += "\nValue: " + df.format(value);
         output += " Use Tax: " + df.format(useTax());
      }
      else {
         output += name + ": " + this.getClass().getName() + " "
            + yearMakeModel;
         output += "\nValue: " + df.format(value);
         output += " Use Tax: " + df.format(useTax());
      }
      return output;
   }
   
   /**
    * Compares two vehicles.
    * @param v new Vehicle object
    * @return int representing order of list
   */
   public int compareTo(Vehicle v) {
      return name.toLowerCase().compareTo(v.getOwner().toLowerCase());
   }
   
   /**
   * Determines if two Vehicle objects are the same.
   * @param obj the other object
   * @return boolean
   */
   public boolean equals(Object obj) {
      if (!(obj instanceof Vehicle)) {
         return false;
      }
      else {
         Vehicle other = (Vehicle) obj;
         return (name + yearMakeModel + value).
         equals(other.name + other.yearMakeModel + other.value);
      }
   }
   
   /** @return 0 */
   public int hashCode() {
      return 0;
   }
}