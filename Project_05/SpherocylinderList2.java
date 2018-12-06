import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program contains all the methods
 * used to  manipulate a list of
 * Spherocylinders.
 *
 * Project 07.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 10/25/17.
*/
public class SpherocylinderList2 {

   private String name;
   private Spherocylinder[] listSC;
   private int numElements;
   
  /**
   * Constructor method that takes in the name of the list
   * and the list of Spherocylinders.
   * @param nameIn takes the naem of the spherocylinder list
   * @param listIn takes in the list of Spherocylinders
   * @param numIn takes number of elements in list
  */
   public SpherocylinderList2(String nameIn, Spherocylinder[] listIn,
                                 int numIn) {
      name = nameIn;
      listSC = listIn;
      numElements = numIn;
   }
   
  /**
   * Returns the String name. 
   * @return name returns a string
  */
   public String getName() {
      return name;
   }
   
   /**
   * Returns the number of spherocylinders in the list. 
   * @return size of list
  */
   public int numberOfSpherocylinders() {
      return numElements;
   }
   
   /**
   * Returns the total surface area of all the objects in the list. 
   * @return sum
  */
   public double totalSurfaceArea() {
      double sum = 0.0;
      int i = 0;
      double hold = 0.0;
            
      //checks to make sure list has objects
      if (numElements > 0) {
      
         //loops through list and gets the surface area of
         //each object
         while (i < numElements) {
            hold = listSC[i].surfaceArea();
            sum += hold;
            i++;
         } 
      }
      
      //backup if list is empty
      else {
         sum = 0.0;
      }
      
      //return statement
      return sum;
   }
   
   /**
   * Returns the total volume of all the objects in the list. 
   * @return sum
  */
   public double totalVolume() {
      
      double sum = 0.0;
      int i = 0;
      double hold = 0.0;
            
      //checks to make sure list has objects
      if (numElements > 0) {
      
         //loops through list and gets the surface area of
         //each object
         while (i < numElements) {
            hold = listSC[i].volume();
            sum += hold;
            i++;
         } 
      }
      
      //backup if list is empty
      else {
         sum = 0.0;
      }
      
      //return statement
      return sum;
   
   }
   
   /**
   * Returns the average surface area. 
   * @return avSA
  */
   public double averageSurfaceArea() {
      double avSA = 0.0;
      
      if (numElements > 0) {
         avSA = totalSurfaceArea() / numElements;
      }
      else {
         return avSA;
      }
      return avSA;
   }
   
   /**
   * Returns the average volume. 
   * @return avV
  */
   public double averageVolume() {
      double avV = 0.0;
      
      if (numElements > 0) {
         avV = totalVolume() / numElements;
      }
      else {
         return avV;
      }
      
      return avV;   
   }
   
   /**
   * Formats all the information to display it for each object. 
   * @return output
  */
   public String toString() {

      String output = "";
      int i = 0;

      if (numElements > 0) {

         output += name + "\n";

         while (i < numElements) {
            output += "\n" + listSC[i].toString() + "\n";

            i++;
         }

         return output;
      }
      else {
         output += name + "\n";
      }

      return output;   
   }
   
   /**
   * Returns summary of the total list. 
   * @return output
  */
   public String summaryInfo() {
      String output = "";
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      
      output += "----- Summary for " + name + " -----";
      
      output += "\nNumber of Spherocylinders: " + numberOfSpherocylinders();
      
      output += "\nTotal Surface Area: " + df.format(totalSurfaceArea());
   
      output += "\nTotal Volume: " + df.format(totalVolume());
   
      output += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
   
      output += "\nAverage Volume: " + df.format(averageVolume());
   
   
      return output;
   }
   
////////////////////////////////////////////////////////////

   /**
   * Returns list. 
   * @return lsitSC
  */
   public Spherocylinder[] getList() {
      return listSC;
   }

   /**
   * Reads the file and returns a spherocylinder list. 
   * @return scListReturn
   * @param nameIn name of list
   * @throws FileNotFoundException if the file isnt found
  */   
   public SpherocylinderList2 readFile(String nameIn) 
               throws FileNotFoundException {
      
      Spherocylinder[] list = new Spherocylinder[100];
      String fileName = "";
      
      int numEl = 0;
      
      Scanner f = new Scanner(new File(nameIn));
      
      fileName = f.nextLine();
      
      while (f.hasNext()) {
      
         String label = f.nextLine();
         double radius = Double.parseDouble(f.nextLine());
         double height = Double.parseDouble(f.nextLine());
         
         String randoHold = f.nextLine();
         
         Spherocylinder s = new Spherocylinder(label, radius, height);
         
         list[numEl] = s;
         numEl++;
      }
      
      SpherocylinderList2 scListReturn = new SpherocylinderList2(fileName, list,
                                                                  numEl); 
      return scListReturn;
   }

   /**
   * Adds a spherocylinder to the list using user data. 
   * @param labelIn label
   * @param radiusIn radius
   * @param heightIn height
  */   
   public void addSpherocylinder(String labelIn, double radiusIn,
                                 double heightIn) {
      Spherocylinder scNew = new Spherocylinder(labelIn, radiusIn, heightIn);
      listSC[numElements] = scNew;
      numElements++;
   }

   /**
   * Returns the specific spherocylinder that the user wanted. 
   * @return s or null
   * @param labelIn label
  */   
   public Spherocylinder findSpherocylinder(String labelIn) {
      //Spherocylinder x = new Spherocylinder();
      
      for (int i = 0; i < numElements; i++) {
         if (listSC[i].getLabel().equalsIgnoreCase(labelIn)) {
            return listSC[i];
         }
         else {
            return null;
         }
      }
      return null;
   }

   /**
   * Deletes a spherocylinder from the list. 
   * @return boolean result
   * @param labelIn label
  */   
   public Spherocylinder deleteSpherocylinder(String labelIn) {
      
      int spot = -1;
      Spherocylinder returnIt = null;
      
      for (int i = 0; i < numElements; i++) {
         if (listSC[i].getLabel().equalsIgnoreCase(labelIn)) {
            returnIt = listSC[i];
            for (int j = i; j < numElements - 1; j++) {
               listSC[j] = listSC[j + 1];
            }
            listSC[numElements - 1] = null;
            numElements--;
         }
      }
      
      return returnIt;
   }

   /**
   * Edits a spherocylinder to fit new radius and height. 
   * @return boolean result
   * @param labelIn label
   * @param radiusIn radius
   * @param heightIn height
  */   
   public boolean editSpherocylinder(String labelIn, double radiusIn,
                                     double heightIn) {
      
      boolean result = false;
      int spot = 0;
      
      for (int i = 0; i < numElements; i++) {
         if (listSC[i].getLabel().equalsIgnoreCase(labelIn)) {
            listSC[i].setRadius(radiusIn);
            listSC[i].setCylinderHeight(heightIn);
            
            result = true;
            break;
         }
         else {
            return false;
         }
      }
      return false;
   }
}