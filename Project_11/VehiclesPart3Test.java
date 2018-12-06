import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
/**
 * Tests VehiclesPart3.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/09/17.
*/
public class VehiclesPart3Test {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests main method. 
    * @throws FileNotFoundException if the file cannot be opened.
   **/
   @Test public void mainMethod() throws FileNotFoundException {
   
      VehiclesPart3 vPart3Obj = new VehiclesPart3();
      Vehicle.resetVehicleCount();
      
      //test that works
      String[] args = {"vehicles2.txt"};
      VehiclesPart3.main(args);
      
      Assert.assertEquals(8, Vehicle.getVehicleCount());
      
      Vehicle.resetVehicleCount();
      
      //bad file name
      args[0] = "ahh.txt";
      VehiclesPart3.main(args);
      
      Assert.assertEquals(0, Vehicle.getVehicleCount());
      
      Vehicle.resetVehicleCount();
      
      //no file
      args[0] = "";
      VehiclesPart3.main(args);
      
      Assert.assertEquals(0, Vehicle.getVehicleCount());
   }
}
