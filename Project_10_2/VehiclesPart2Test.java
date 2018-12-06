import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
/**
 * Tests VehiclesPart2.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class VehiclesPart2Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests main method. 
    * @throws FileNotFoundException if the file cannot be opened.
   **/
   @Test public void mainMethod() throws FileNotFoundException {
      VehiclesPart2 vPart2Obj = new VehiclesPart2(); // test constructor
      Vehicle.resetVehicleCount();
      
      String[] args = {"vehicles1.txt"};
      VehiclesPart2.main(args);
      
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   }
}
