import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This program takes in user data and
 * uses other classes to manipulate the
 * data.
 *
 * Project 06.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 10/17/17.
*/

public class SpherocylinderListMenuApp {
/**
 * Gets user data and uses different commands to alter/display list.
 *
 * @param args - is not used.
 * @throws FileNotFoundException if the file cannot be opened.
 */
   public static void main(String[] args) throws FileNotFoundException {
   
      String scListName = "no list name";
      ArrayList<Spherocylinder> scList = new ArrayList<Spherocylinder>();
      SpherocylinderList scl = new SpherocylinderList(scListName, scList);
      String fileName = "no file name";
      
      String label = "";
      double radius = 0;
      double height = 0;
      
      String code = "";
      
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Spherocylinder List System Menu\n"
                        + "R - Read File and Create Spherocylinder List\n"
                        + "P - Print Spherocylinder List\n"
                        + "S - Print Summary\n"
                        + "A - Add Spherocylinder\n"
                        + "D - Delete Spherocylinder\n"
                        + "F - Find Spherocylinder\n"
                        + "E - Edit Spherocylinder\n"
                        + "Q - Quit");
                        
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         
         switch(codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
               
               scl = scl.readFile(fileName);
               
               System.out.println("\tFile read in and Spherocylinder"
                                 + " List created\n");
               
               break;
               
            case 'P':
               System.out.println("\n" + scl);
               break;
               
            case 'S':
               System.out.println("\n" + scl.summaryInfo() + "\n");
               break;
            
            case 'A':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tCylinder Height: ");
               height = Double.parseDouble(scan.nextLine());
               
               scl.addSpherocylinder(label, radius, height);
               
               System.out.println("\t*** Spherocylinder added ***\n");
               
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               
               if (scl.deleteSpherocylinder(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               
               Spherocylinder x = scl.findSpherocylinder(label);
               
               if (x != null) {
                  System.out.println(x + "\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               
               break;
               
            case 'E':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tCylinder Height: ");
               height = Double.parseDouble(scan.nextLine());
               
               if (scl.editSpherocylinder(label, radius, height)) {
                  System.out.println("\t\"" + label + "\" successfully"
                                    + " edited\n");
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               
               break;
               
            case 'Q':
               break;
               
            default:
               System.out.println("\t*** invalid code ***\n");
               break;
         }
         
      } while (!code.equalsIgnoreCase("Q"));
      
   }
   
}