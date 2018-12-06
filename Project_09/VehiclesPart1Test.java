import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Test cases for Vehicles.
 *
 * Project 09.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/16/17.
*/
public class VehiclesPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests total num of vehicles. **/
   @Test public void vehicalCountTest() {
      VehiclesPart1 vp1 = new VehiclesPart1();
      Vehicle.resetVehicleCount();
      VehiclesPart1.main(null);
      
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   }
}
