import java.util.Scanner;
/**
 * This program organizes the user data to return
 * the circumference, surface area, and volume of
 * a spherocylinder.  It takes in the users inputed
 * data for the label, radius, and height of the
 * spherocylinder.
 *
 * Project 04.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 9/25/17.
*/
public class SpherocylinderApp {
/**
 * Takes in all the user data and gives it to a
 * new Spherocylinder object to determine the 
 * circumference, surface area, and volume.
 *
 * @param args Command line arguments (not used).
*/
   public static void main(String[] args) {

      Spherocylinder ex = new Spherocylinder();

      Scanner scan = new Scanner(System.in);
      String scannedLabel = "";
      double scannedRadius = 0;
      double scannedHeight = 0;
      
      
      //LABEL
      System.out.print("Enter label, radius, and cylinder height "
         + "for a spherocylinder.");
      System.out.print("\n\tlabel: ");
      scannedLabel = scan.nextLine();
            
      if (ex.setLabel(scannedLabel)) {
      
         //RADIUS 
         System.out.print("\tradius: ");
         scannedRadius = scan.nextDouble();
         
         //checks to make sure radius is positive
         if (!ex.setRadius(scannedRadius)) {
            System.out.print("Error: radius must be non-negative.");
            System.out.print("\n");
         }
         else {
         
            //HEIGHT
            System.out.print("\tcylinder height: ");
            scannedHeight = scan.nextDouble();
            
            //checks to make sure height is positive
            if (!ex.setCylinderHeight(scannedHeight)) {
               System.out.print("Error: cylinder height must be "
                  + "non-negative.");
            }
            else {
               System.out.println("\n" + ex);
            }
         }
      }
   }
}