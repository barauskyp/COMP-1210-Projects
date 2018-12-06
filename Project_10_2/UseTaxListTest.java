import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * UseTaxList test cases.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class UseTaxListTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests readFile. 
   @throws FileNotFoundException if the file cannot be opened.**/
   @Test public void readFileTest() throws FileNotFoundException {
      String fileName = "vehicles1.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      //Assert.assertEquals();
      
      
   }
   
   /** Tests getTaxDistrict. 
   @throws FileNotFoundException if the file cannot be opened.**/
   @Test public void getDistrictTest() throws FileNotFoundException {
      String fileName = "vehicles1.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      Assert.assertEquals("Tax District 52", test.getTaxDistrict());
   }
   
   /** Tests setTaxDistrict.
   @throws FileNotFoundException if the file cannot be opened. **/
   @Test public void setDistrictTest() throws FileNotFoundException {
      String fileName = "vehicles1.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      test.setTaxDistrict("hello");
      
      Assert.assertEquals("hello", test.getTaxDistrict());
   }
   
   /** Tests getting vehicle list **/
   /*@Test public void getVList() throws FileNotFoundException {
      String list = "Jones, Jo: Car 2017 Honda Accord (Alternative Fuel) "

      String fileName = "vehicles1.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
            
      Assert.assertEquals(list, vList);
      */
      
   /** Tests adding a vehicle. 
   @throws FileNotFoundException if the file cannot be opened. **/
   @Test public void addTest() throws FileNotFoundException {
      String fileName = "vehicles1.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      int length = test.getVehicleList().length;
      
      Car car = new Car("test", "test", 100, true);
      
      test.addVehicle(car);
      
      Assert.assertEquals(car, test.getVehicleList()[length]);
   }
}