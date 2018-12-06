import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Negative Value Exception test case.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/09/17.
*/
public class NegativeValueExceptionTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   

   /** Tests NegativeValueException. **/
   @Test public void negativeValueExceptionTest() {
      boolean thrown = false;
      try {
         Car car = new Car("Jackson, Bo", "2012 Toyota Camry", -25000, false);
      }
      catch (NegativeValueException e) {
         thrown = true;
      }
      
      Assert.assertTrue("Expected NegativeValueException to be thrown.",
         thrown);
      /* or alternatively: */
      Assert.assertEquals("Expected NegativeValueException to be thrown.",
         true, thrown);
   }
}
