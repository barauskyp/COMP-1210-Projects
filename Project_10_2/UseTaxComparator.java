import java.util.Comparator;
/**
 * UseTaxComparator.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class UseTaxComparator implements Comparator<Vehicle> {
   /**
    * Compares two Vehicles.
    * @param v1 first Vehicle
    * @param v2 second Vehicle
    * @return int for order
   */
   public int compare(Vehicle v1, Vehicle v2) {
      if (v1.useTax() > v2.useTax()) {
         return 1;
      }
      else if (v1.useTax() < v2.useTax()) {
         return -1;
      }
      else {
         return 0;
      }
   }
}