import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Truck test cases.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/09/17.
*/
public class TruckTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests getTons.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void getTonsTest() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Assert.assertEquals(1.5, truck1.getTons(), .0001);
   }
   
   /** Tests setTons.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void setTonsTest() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      truck1.setTons(5);
      Assert.assertEquals(5, truck1.getTons(), .0001);
   }
   
   /** Tests useTax.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void useTaxTest() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack",
         40000, true, 2.5);
      
      Assert.assertEquals((30000 * .02), truck1.useTax(), .0001);
      Assert.assertEquals(((40000 * .01) + (40000 * .03)),
         truck2.useTax(), .0001);
   }
   
   /** Tests toString.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void toStringTest() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack",
         40000, true, 2.5);
      
      String output1 = "Williams, Jo: Truck 2012 Chevy Silverado\nValue: "
         + "$30,000.00 Use Tax: $600.00\nwith Tax Rate: 0.02";
      String output2 = "Williams, Sam: Truck 2010 Chevy Mack (Alternative Fuel)"
         + "\nValue: $40,000.00 Use Tax: $1,600.00\nwith Tax Rate: 0.01 "
         + "Large Truck Tax Rate: 0.03";

      Assert.assertEquals(output1, truck1.toString());
      Assert.assertEquals(output2, truck2.toString());
   }
}