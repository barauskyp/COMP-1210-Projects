import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Test cases for Car.
 *
 * Project 09.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/16/17.
*/
public class CarTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Test for useTax. **/
   @Test public void useTaxTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
         110000, true);
      
      Assert.assertEquals((22000 * .01), car1.useTax(), .00001);
      Assert.assertEquals((22000 * .005), car2.useTax(), .00001);
      Assert.assertEquals((110000 * .01) + (110000 * .02), car3.useTax(),
         .00001);
      Assert.assertEquals((110000 * .005) + (110000 * .02), car4.useTax(),
         .00001);
   }
   
   /** Test for toString. **/
   @Test public void toStringTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
         110000, true);
      
      String output1 = "Jones, Sam: Car 2017 Honda Accord\nValue: $22,000.00 "
         + "Use Tax: $220.00\nwith Tax Rate: 0.01";
      String output2 = "Jones, Jo: Car 2017 Honda Accord (Alternative Fuel)"
         + "\nValue: $22,000.00 Use Tax: $110.00\nwith Tax Rate: 0.005";
      String output3 = "Smith, Pat: Car 2015 Mercedes-Benz Coupe\nValue: "
         + "$110,000.00 Use Tax: $3,300.00"
         + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02";
      String output4 = "Smith, Jack: Car 2015 Mercedes-Benz Coupe "
         + "(Alternative Fuel)"
         + "\nValue: $110,000.00 Use Tax: $2,750.00"
         + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02";

      Assert.assertEquals(output1, car1.toString());
      Assert.assertEquals(output2, car2.toString());
      Assert.assertEquals(output3, car3.toString());
      Assert.assertEquals(output4, car4.toString());
   }
   
   /** Tests getting owner. **/
   @Test public void getOwnerTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      
      Assert.assertEquals("Jones, Sam", car1.getOwner());
   }
   
   /** Tests setting owner. **/
   @Test public void setOwnerTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car1.setOwner("Eichorn, Natalie");
      
      Assert.assertEquals("Eichorn, Natalie", car1.getOwner());
   }
   
   /** Tests getting year make model. **/
   @Test public void getYMM() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      
      Assert.assertEquals("2017 Honda Accord", car1.getYearMakeModel());
   }
   
   /** Tests setting year make model. **/
   @Test public void setYMM() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car1.setYearMakeModel("2015 Honda Fit");
      
      Assert.assertEquals("2015 Honda Fit", car1.getYearMakeModel());
   }
   
   /** Tests getting value. **/
   @Test public void getValueTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      
      Assert.assertEquals(22000, car1.getValue(), .0001);
   }
   
   /** Tests setting value. **/
   @Test public void setValueTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car1.setValue(10000);
      
      Assert.assertEquals(10000, car1.getValue(), .0001);
   }
   
   /** Tests getting fuel type. **/
   @Test public void getFuelTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      
      Assert.assertEquals(false, car1.getAlternativeFuel());
   }
   
   /** Tests setting fuel. **/
   @Test public void setFuelTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      car1.setAlternativeFuel(true);
      
      Assert.assertEquals(true, car1.getAlternativeFuel());
   }
   
}
