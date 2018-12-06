import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program contains all the methods
 * used to  manipulate a list of
 * Spherocylinders.
 *
 * Project 06.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 10/17/17.
*/
public class SpherocylinderList {

   private String name;
   private ArrayList<Spherocylinder> listSC;
   
  /**
   * Constructor method that takes in the name of the list
   * and the list of Spherocylinders.
   * @param nameIn takes the naem of the spherocylinder list
   * @param listIn takes in the list of Spherocylinders
  */
   public SpherocylinderList(String nameIn, ArrayList<Spherocylinder> listIn) {
      name = nameIn;
      listSC = listIn;
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
      return listSC.size();
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
      if (listSC.size() > 0) {
      
         //loops through list and gets the surface area of
         //each object
         while (i < listSC.size()) {
            hold = listSC.get(i).surfaceArea();
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
      if (listSC.size() > 0) {
      
         //loops through list and gets the surface area of
         //each object
         while (i < listSC.size()) {
            hold = listSC.get(i).volume();
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
      
      if (listSC.size() > 0) {
         avSA = totalSurfaceArea() / listSC.size();
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
      
      if (listSC.size() > 0) {
         avV = totalVolume() / listSC.size();
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

      if (listSC.size() > 0) {

         output += name + "\n";

         while (i < listSC.size()) {
            output += "\n" + listSC.get(i).toString() + "\n";

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
   public ArrayList<Spherocylinder> getList() {
      return listSC;
   }

   /**
   * Reads the file and returns a spherocylinder list. 
   * @return scListReturn
   * @param nameIn name of list
   * @throws FileNotFoundException if the file isnt found
  */   
   public SpherocylinderList readFile(String nameIn) 
               throws FileNotFoundException {
      
      ArrayList<Spherocylinder> list = new ArrayList<Spherocylinder>();
      String fileName = "";
      
      Scanner f = new Scanner(new File(nameIn));
      
      fileName = f.nextLine();
      
      while (f.hasNext()) {
      
         String label = f.nextLine();
         double radius = (double) (f.nextDouble());
         double height = (double) (f.nextDouble());
         
         String randoHold = f.nextLine();
         
         Spherocylinder s = new Spherocylinder(label, radius, height);
         list.add(s);
      }
      
      SpherocylinderList scListReturn = new SpherocylinderList(fileName, list);
      
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
      listSC.add(scNew);
   }

   /**
   * Returns the specific spherocylinder that the user wanted. 
   * @return s or null
   * @param labelIn label
  */   
   public Spherocylinder findSpherocylinder(String labelIn) {
      
      for (Spherocylinder s : listSC) {
         if (s.getLabel().equalsIgnoreCase(labelIn)) {
            return s;
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
      
      int spot = 0;
      
      for (Spherocylinder s : listSC) {
         if (s.getLabel().equalsIgnoreCase(labelIn)) {
            spot = listSC.indexOf(s);
            listSC.remove(spot);
            return s;
         }
      }
      return null;
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
      
      for (Spherocylinder s : listSC) {
         if (s.getLabel().equalsIgnoreCase(labelIn)) {
            s.setRadius(radiusIn);
            s.setCylinderHeight(heightIn);
            
            result = true;
            break;
         }
      }
      return result;
   }
}