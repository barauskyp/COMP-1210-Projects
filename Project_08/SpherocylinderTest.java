import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;

/**
 * This program tests the method of Spherocylinder.
 *
 * Project 08A.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/2/17.
*/
public class SpherocylinderTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** A test that checks getting the label. **/
   @Test public void getLabelTest() {
      Spherocylinder s1 = new Spherocylinder("one", 2, 3);
      Assert.assertEquals("one", s1.getLabel());
   }
   
   /** A test that checks setting the label. **/
   @Test public void setLabelCheck() {
      Spherocylinder s2 = new Spherocylinder("two", 2, 3);
      s2.setLabel("hello");
      Assert.assertEquals("hello", s2.getLabel());
   }
   
   /** A test that checks setting the label to null. **/
   @Test public void setLabelCheckNull() {
      Spherocylinder ahh = new Spherocylinder("ahh", 2, 3);
      Assert.assertEquals(false, ahh.setLabel(null));
   }
   
   /** A test that checks getting the radius. **/
   @Test public void getRadiusTest() {
      Spherocylinder a = new Spherocylinder("a", 5, 2.5);
      Assert.assertEquals(5, a.getRadius(), .0001);
   }
   
   /** A test that checks setting the radius. **/
   @Test public void setRadiusTest() {
      Spherocylinder b = new Spherocylinder("b", 5, 3);
      b.setRadius(4.5);
      Assert.assertEquals(4.5, b.getRadius(), .0001);
      Assert.assertEquals(false, b.setRadius(-3));
   }
   
   /** A test that checks getting the cylinder height. **/
   @Test public void getHeightTest() {
      Spherocylinder c = new Spherocylinder("c", 4, 2.9);
      Assert.assertEquals(2.9, c.getCylinderHeight(), .0001);
   }
   
   /** A test that checks setting the cylinder height. **/
   @Test public void setHeightTest() {
      Spherocylinder d = new Spherocylinder("d", 5, 3);
      d.setCylinderHeight(10);
      Assert.assertEquals(10, d.getCylinderHeight(), .0001);
      Assert.assertEquals(false, d.setCylinderHeight(-3));
   }

   /** A test that checks finding the circumference. **/
   @Test public void circumferenceTest() {
      Spherocylinder e = new Spherocylinder("e", 8, 4);
      double answer = 8 * Math.PI * 2;
      Assert.assertEquals(answer, e.circumference(), .0001);
   }
   
   /** A test that checks finding the surface area. **/
   @Test public void surfaceAreaTest() {
      Spherocylinder f = new Spherocylinder("f", 3, 4);
      double answer = (2 * Math.PI * 3) * (2 * 3 + 4);
      Assert.assertEquals(answer, f.surfaceArea(), .0001);
   }
   
   /** A test that checks finding the volume. **/
   @Test public void volumeTest() {
      Spherocylinder g = new Spherocylinder("g", 5, 4);
      double answer = (Math.PI * Math.pow(5, 2))
          * ((4.0 / 3.0) * 5 + 4);
      Assert.assertEquals(answer, g.volume(), .0001);
   }
   
   /** A test that checks the toString. **/
   @Test public void toStringTest() {
      Spherocylinder h = new Spherocylinder("h", 5, 5);
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      
      output = "Spherocylinder \"" + "h"
         + "\" with radius " + (double) 5 + " and cylinder height "
         + (double) 5 + " has:";
         
      output += "\n\tcircumference = " + df.format(5 * Math.PI * 2) + " units";
      
      output += "\n\tsurface area = " + df.format((2 * Math.PI * 5)
         * (2 * 5 + 5)) + " square units";
      
      output += "\n\tvolume = " + df.format((Math.PI * Math.pow(5, 2))
          * ((4.0 / 3.0) * 5 + 5)) + " cubic units";
          
      Assert.assertEquals(output, h.toString());
   }
   
   /** A test to check the equals method. **/
   @Test public void equalsTest() {
      Spherocylinder i = new Spherocylinder("test", 1, 2);
      Spherocylinder j = new Spherocylinder("test", 1, 2);
      Spherocylinder k = new Spherocylinder("k", 1, 2);
      Spherocylinder k2 = new Spherocylinder("test", 2, 2);
      Spherocylinder k3 = new Spherocylinder("test", 1, 1);
      Spherocylinder k4 = new Spherocylinder("ahh", 5, 6);
      
      Object x = new Object();
      
      Assert.assertEquals(false, i.equals(x));
      
      Assert.assertEquals(true, i.equals(j));
      Assert.assertEquals(false, i.equals(k));
      Assert.assertEquals(false, i.equals(k2));
      Assert.assertEquals(false, i.equals(k3));
      Assert.assertEquals(false, i.equals(k4));

   }
   
   /** A test to check that the count is reset. **/
   @Test public void resetCountTest() {
      Spherocylinder l = new Spherocylinder("l", 4, 3);
      l.resetCount();
      Assert.assertEquals(0, l.getCount(), .0001);
   }
   
   /** A test to check getting the count. **/
   @Test public void getCountTest() {
      Spherocylinder m = new Spherocylinder("m", 5, 3);
      m.resetCount();
      Spherocylinder n = new Spherocylinder("n", 5, 3);
      Assert.assertEquals(1, n.getCount(), .0001);
   }
   
   /** A test to check hashCode. **/
   @Test public void hashCodeTest() {
      Spherocylinder o = new Spherocylinder("o", 4, 4);
      Assert.assertEquals(0, o.hashCode(), .00001);
   }

}