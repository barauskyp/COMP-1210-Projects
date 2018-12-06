import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * This program is the user interaction part. 
 * It gets the file name and uses it to print
 * out all the data about each Spherocylinder.
 *
 * Project 05.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 10/10/17.
*/
public class SpherocylinderListApp {

   /**
    * Main method that takes in data and organizes it
    * to send to the other classes in the project.
    * 
    * @param args Command line arguments (not used).
    * @throws FileNotFoundException just in case.
   */
   public static void main(String[] args) throws FileNotFoundException {
      
      String fileName = "";
      String listName = "";
      
      ArrayList<Spherocylinder> list = new ArrayList<Spherocylinder>();
      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      fileName = scan.nextLine();
      
      System.out.println();
      
      Scanner scanFile = new Scanner(new File(fileName));
      
      listName = scanFile.nextLine();

      while (scanFile.hasNext()) {
      
         String label = scanFile.nextLine();
         double radius = (double) (scanFile.nextDouble());
         double height = (double) (scanFile.nextDouble());
         
         //why does this have to be here?? it throws a mismatch error without?
         String randoHold = scanFile.nextLine();
         
         Spherocylinder s = new Spherocylinder(label, radius, height);
         list.add(s);
         
         //System.out.println("list:\n " + list);
         //label = "";
         //radius = 0;
         //height = 0;
      }
      scanFile.close();
       
      SpherocylinderList scList = new SpherocylinderList(listName, list);
      
      System.out.println(scList);
      System.out.println();
      System.out.println(scList.summaryInfo());

   }
}