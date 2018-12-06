import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * UseTaxList test cases.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/09/17.
*/
public class UseTaxListTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests readFile. 
   @throws FileNotFoundException if the file cannot be opened.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void readFileTest() 
      throws FileNotFoundException, NegativeValueException {
      String fileName = "vehicles2.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      Assert.assertEquals("Tax District 52", test.getTaxDistrict());
   }
   
   /** Tests getTaxDistrict. 
   @throws FileNotFoundException if the file cannot be opened.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void getDistrictTest() 
      throws FileNotFoundException, NegativeValueException {
      String fileName = "vehicles2.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      Assert.assertEquals("Tax District 52", test.getTaxDistrict());
      Assert.assertEquals(9, test.getVehicleList().length);
      Assert.assertEquals(8, test.getExcludedRecords().length);
   }
   
   /** Tests setTaxDistrict.
   @throws FileNotFoundException if the file cannot be opened. 
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void setDistrictTest()
      throws FileNotFoundException, NegativeValueException {
      String fileName = "vehicles2.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      test.setTaxDistrict("hello");
      
      Assert.assertEquals("hello", test.getTaxDistrict());
   }
      
   /** Tests adding a vehicle. 
   @throws FileNotFoundException if the file cannot be opened.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void addTest()
      throws FileNotFoundException, NegativeValueException {
      String fileName = "vehicles2.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      int length = test.getVehicleList().length;
      
      Car car = new Car("test", "test", 100, true);
      
      test.addVehicle(car);
      
      Assert.assertEquals(10, test.getVehicleList().length);
   }
   
   /** Tests adding an excluded record. 
   @throws FileNotFoundException if the file cannot be opened.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void addExcludedTest() 
      throws FileNotFoundException, NegativeValueException {
      String fileName = "vehicles2.txt";
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile(fileName);
      
      int length = test.getExcludedRecords().length;
      
      String addThis = "excluded record";
      
      test.addExcludedRecord(addThis);
      
      Assert.assertEquals(9, test.getExcludedRecords().length);
   }
   
   /** Tests adding an excluded record. 
   @throws FileNotFoundException if the file cannot be opened.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void toStringTest() throws FileNotFoundException {
      UseTaxList test = new UseTaxList();
      test.readVehicleFile("vehicles2.txt");
      
      Assert.assertTrue(test.toString().contains(
         "Smith, Pat: Car 2015 Mercedes-Benz Coupe\n"
            + "Value: $110,000.00 Use Tax: $3,300.00\n"
            + "with Tax Rate: 0.01 Luxury Tax Rate: 0.02"));
      
   }
}