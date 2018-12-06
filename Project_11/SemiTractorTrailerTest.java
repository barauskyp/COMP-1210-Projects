import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Semi Tractor Trailer test cases.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/09/17.
*/
public class SemiTractorTrailerTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests getAxles.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void getAxlesTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy",
         45000, false, 5.0, 4);
         
      Assert.assertEquals(4, semi1.getAxles());
   }
   
   /** Tests setAxles.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void setAxlesTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy",
         45000, false, 5.0, 4);
      semi1.setAxles(6);
         
      Assert.assertEquals(6, semi1.getAxles());
   }
   
   /** Tests useTax.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void useTaxTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy",
         45000, false, 5.0, 4);
      
      double first = 0.0;
      first = (45000 * .02) + (45000 * .03);
      
      Assert.assertEquals((first + (45000 * 4 * .005)), semi1.useTax(), .0001);
   }
   
   /** Tests toString.
   @throws NegativeValueException checks to make sure numbers are positive **/
   @Test public void toStringTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy",
         45000, false, 5.0, 4);
         
      String output1 = "Williams, Pat: SemiTractorTrailer 2012 International "
         + "Big Boy\nValue: $45,000.00 Use Tax: $3,150.00\nwith Tax Rate: 0.02 "
         + "Large Truck Tax Rate: 0.03 Axle Tax Rate: 0.02";

      Assert.assertEquals(output1, semi1.toString());
   }
}