import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Motorcylce test cases.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/09/17.
*/
public class MotorcycleTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests getting engine size.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void getEngineSizeTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster",
         14000, false, 750);
         
      Assert.assertEquals(750, bike1.getEngineSize(), .0001);
   }
   
   /** Tests setting engine size.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void setEngineSizeTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster",
         14000, false, 750);
      bike1.setEngineSize(100);
      
      Assert.assertEquals(100, bike1.getEngineSize(), .0001);
   }
   
   /** Tests useTax.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void useTaxTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster",
         14000, false, 750);
      Motorcycle bike2 = new Motorcycle("Brando, Tom",
         "1990 Harley-Davidson Sportster",
         14000, true, 750);
      Motorcycle bike3 = new Motorcycle("Brando, Jim",
         "1970 Harley-Davidson Sportster",
         14000, true, 450);
      
      Assert.assertEquals((14000 * .005) + (14000 * .015), 
         bike1.useTax(), .0001);
      Assert.assertEquals((14000 * .0025) + (14000 * .015), 
         bike2.useTax(), .0001);
      Assert.assertEquals((14000 * .0025), bike3.useTax(), .0001);
   }
   
   /** Tests toString.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void toStringTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster",
         14000, false, 750);
      Motorcycle bike2 = new Motorcycle("Brando, Tom",
         "1990 Harley-Davidson Sportster",
         14000, true, 750);
         
      String output = "Brando, Marlon: Motorcycle 1964 Harley-Davidson "
         + "Sportster\nValue: $14,000.00 Use Tax: $280.00\nwith Tax Rate: "
         + "0.005 Large Bike Tax Rate: 0.015";
      String output2 = "Brando, Tom: Motorcycle 1990 Harley-Davidson "
         + "Sportster (Alternative Fuel)\nValue: $14,000.00 Use Tax: "
         + "$245.00\nwith Tax Rate: "
         + "0.0025 Large Bike Tax Rate: 0.015";
      
      Assert.assertEquals(output, bike1.toString());
      Assert.assertEquals(output2, bike2.toString());

   }
}