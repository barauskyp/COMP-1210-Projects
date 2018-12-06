import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.text.DecimalFormat;
import java.io.IOException;

/**
 * This program tests the methods of SpherocylinderList2.
 *
 * Project 08B.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/6/17.
*/
public class SpherocylinderList2Test {

   private Spherocylinder one = new Spherocylinder("one", 1, 1);
   private Spherocylinder two = new Spherocylinder("two", 2, 3);
   private Spherocylinder three = new Spherocylinder("three", 5.4, 20);

   private Spherocylinder four = new Spherocylinder("four", 2, 3);
   private Spherocylinder four2 = new Spherocylinder("four2", 2, 3);
   

   private Spherocylinder[] list = {one, two, three};
   private Spherocylinder[] blank = new Spherocylinder[0];
   private Spherocylinder[] list2 = {four, four2};
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   
   /** Tests getName. **/
   @Test public void getNameTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      
      Assert.assertEquals("name", tester.getName());
   }
   
   /** Tests number of spherocylinders. **/
   @Test public void numSpherosTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 bTester = new SpherocylinderList2("name", list, -1);

      Assert.assertEquals(3, tester.numberOfSpherocylinders(), .0001);
      Assert.assertEquals(0, bTester.numberOfSpherocylinders(), .0001);
   }
   
   /** Tests the total surface area. **/
   @Test public void surfaceAreaTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 bTester = new SpherocylinderList2("blank", blank, 0);
      
      double total = 0.0;
      
      total += (2 * Math.PI * 1) * (2 * 1 + 1);
      total += (2 * Math.PI * 2) * (2 * 2 + 3);
      total += (2 * Math.PI * 5.4) * (2 * 5.4 + 20);
      
      Assert.assertEquals(total, tester.totalSurfaceArea(), .0001);
      Assert.assertEquals(0.0, bTester.totalSurfaceArea(), .0001);
   }
   
   /** Tests the total volume. **/
   @Test public void volumeTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 bTester = new SpherocylinderList2("blank", blank, 0);

      double total = 0.0;
      
      total += (Math.PI * Math.pow(1, 2)) * ((4.0 / 3.0) * 1 + 1);
      total += (Math.PI * Math.pow(2, 2)) * ((4.0 / 3.0) * 2 + 3);
      total += (Math.PI * Math.pow(5.4, 2)) * ((4.0 / 3.0) * 5.4 + 20);
      
      Assert.assertEquals(total, tester.totalVolume(), .0001);
      Assert.assertEquals(0.0, bTester.totalVolume(), .0001);
   }
   
   /** Tests average SA. **/
   @Test public void avSATest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 bTester = new SpherocylinderList2("blank", blank, 0);

      double av = tester.totalSurfaceArea() / 3;
      
      Assert.assertEquals(av, tester.averageSurfaceArea(), .0001);
      Assert.assertEquals(0.0, bTester.averageSurfaceArea(), .0001);
   }
   
   /** Tests average volume. **/
   @Test public void avVolumeTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 bTester = new SpherocylinderList2("blank", blank, 0);

      double av = tester.totalVolume() / 3;
      
      Assert.assertEquals(av, tester.averageVolume(), .0001);
      Assert.assertEquals(0.0, bTester.averageVolume(), .0001);
   }
   
   /** Tests toString. **/
   @Test public void toStringTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 bTester = new SpherocylinderList2("blank", list, 0);

      String output = "";
      int i = 0;
      double numElements = 3;
      
      if (numElements > 0) {
      
         output += "name" + "\n";
      
         while (i < numElements) {
            output += "\n" + list[i].toString() + "\n";
         
            i++;
         }
      }
      else {
         output = bTester.getName() + "\n";
      }
      
      Assert.assertEquals(output, tester.toString());
      Assert.assertEquals("blank\n", bTester.toString());
   }
   
   /** Tests summary. **/
   @Test public void summaryTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      
      String output = "";
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      
      output += "----- Summary for " + "name" + " -----";
      output += "\nNumber of Spherocylinders: " + 3;
      output += "\nTotal Surface Area: "
             + df.format(tester.totalSurfaceArea());  
      output += "\nTotal Volume: " + df.format(tester.totalVolume());   
      output += "\nAverage Surface Area: "
             + df.format(tester.averageSurfaceArea());
      output += "\nAverage Volume: " + df.format(tester.averageVolume());
   
      Assert.assertEquals(output, tester.summaryInfo());      
   }
   
   /** Tests returning the list. **/
   @Test public void getListTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);

      Assert.assertArrayEquals(list, tester.getList());
   }
   
   /** Tests reading the file. 
    * @throws IOException to read the file
    */
   @Test public void readFileTest() throws IOException {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);

      SpherocylinderList2 newList = new SpherocylinderList2("blank", null, 0);
      
      newList = newList.readFile("spherocylinder_data_1.txt");
      
      Assert.assertEquals("Spherocylinder Test List", newList.getName());
   }
   
   /** Tests finding a spherocylinder. **/
   @Test public void findSpheroTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      
      Assert.assertEquals(list[0], tester.findSpherocylinder("one"));
   }

   /** Tests adding spherocylinder. **/
   @Test public void addSTest() {
      Spherocylinder[] sArray = new Spherocylinder[20];
      sArray[0] = new Spherocylinder("one", 1, 1);
      sArray[1] = new Spherocylinder("two", 2, 3);
      sArray[2] = new Spherocylinder("three", 5, 4);
      
      SpherocylinderList2 scList = new SpherocylinderList2("test", sArray, 3);
      
      Spherocylinder s = new Spherocylinder("new", 10, 10);
      scList.addSpherocylinder("new", 10, 10);
      Spherocylinder[] scA2 = scList.getList();
         
      Assert.assertEquals(s, scA2[3]);
   }
   
   /** Tests deleting spherocylinder. **/
   @Test public void deleteTest() {
      Spherocylinder[] sArray = new Spherocylinder[20];
      sArray[0] = new Spherocylinder("one", 1, 1);
      sArray[1] = new Spherocylinder("two", 2, 3);
      sArray[2] = new Spherocylinder("three", 5, 4);
      
      SpherocylinderList2 scList = new SpherocylinderList2("test", sArray, 3);
      
      Spherocylinder s = new Spherocylinder("new", 10, 10);
      Spherocylinder[] scA = scList.getList();
         
      Assert.assertEquals(sArray[1], scList.deleteSpherocylinder("two"));
   }
   
   /** Tests edit spherocylinder. **/
   @Test public void editTest() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      
      Assert.assertEquals(true, tester.editSpherocylinder("one", 100, 100));
      Assert.assertEquals(false, tester.editSpherocylinder("fails", 1, 1));
   }
   
   /** Tests finding shortest radius. **/
   @Test public void findSmallRadius() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 blankTest = new SpherocylinderList2("blank", list, 0);
      

      Assert.assertEquals(list[0],
         tester.findSpherocylinderWithShortestRadius());
      Assert.assertEquals(null,
         blankTest.findSpherocylinderWithShortestRadius());
   }
   
   /** Tests finding biggest radius. **/
   @Test public void findBigRadius() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 blankTest = new SpherocylinderList2("blank", list, 0);
      SpherocylinderList2 equalTest = new SpherocylinderList2("=", list2, 2);

      Assert.assertEquals(list[2],
         tester.findSpherocylinderWithLongestRadius());
      Assert.assertEquals(null,
         blankTest.findSpherocylinderWithLongestRadius());
      Assert.assertEquals(list2[1],
         equalTest.findSpherocylinderWithLongestRadius());
   }
   
   /** Tests finding smallest volume. **/
   @Test public void findSmallVolume() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 blankTest = new SpherocylinderList2("blank", list, 0);

      Assert.assertEquals(list[0],
         tester.findSpherocylinderWithSmallestVolume());
      Assert.assertEquals(null,
         blankTest.findSpherocylinderWithSmallestVolume());
   }
   
   /** Tests finding biggest volume. **/
   @Test public void findBigVolume() {
      SpherocylinderList2 tester = new SpherocylinderList2("name", list, 3);
      SpherocylinderList2 blankTest = new SpherocylinderList2("blank", list, 0);
      SpherocylinderList2 equalTest = new SpherocylinderList2("=", list2, 2);

      Assert.assertEquals(list[2],
         tester.findSpherocylinderWithLargestVolume());
      Assert.assertEquals(null,
         blankTest.findSpherocylinderWithLargestVolume());
      Assert.assertEquals(list2[1],
         equalTest.findSpherocylinderWithLargestVolume());   
   }

}