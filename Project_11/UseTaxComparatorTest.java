import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * UseTaxComparator test cases.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class UseTaxComparatorTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Tests compare. 
   @throws NegativeValueException checks to make sure numbers are positive**/
   @Test public void compareTest() throws NegativeValueException {
   
      UseTaxComparator u = new UseTaxComparator();
   
      Vehicle one = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Vehicle two = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);

      Assert.assertEquals(-1, u.compare(one, two));
      Assert.assertEquals(1, u.compare(two, one));
      Assert.assertEquals(0, u.compare(one, one));
   }
}