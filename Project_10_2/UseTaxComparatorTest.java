import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
/**
 * UseTaxComparator test cases.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class UseTaxComparatorTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   

   /** Tests compare. **/
   @Test public void compareTest() {
      Vehicle one = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Vehicle two = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      
      Vehicle[] list = {two, one};
      
      Arrays.sort(list, new UseTaxComparator()); 
      
      Assert.assertEquals(one, list[0]);
   }
}