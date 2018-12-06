import java.io.FileNotFoundException;
/**
 * Runner for all the files in the project.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/05/17.
*/
public class VehiclesPart3 {
   /**
    * Main method.
    * @param args not used
   */
   public static void main(String[] args) {
            
      try {
         String fileName = args[0];
         UseTaxList test = new UseTaxList();
         
         test.readVehicleFile(fileName);
         
         System.out.println(test.summary() + "\n");     
         System.out.println(test.listByOwner() + "\n");
         System.out.println(test.listByUseTax() + "\n");
         System.out.println(test.excludedRecordsList());
      }
      catch (FileNotFoundException e) {
         if (args.length == 0) {
            System.out.println("*** File name not provided by "
               + "command line argument.");
            System.out.println("Program ending.");
         }
         else {
            System.out.println("*** File not found.\nProgram Ending");
         }
      }

   }
}