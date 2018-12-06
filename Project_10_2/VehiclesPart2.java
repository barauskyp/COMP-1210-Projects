import java.io.FileNotFoundException;
import java.util.Arrays;
/**
 * VehiclesPart2.
 *
 * Project 10.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/29/17.
*/
public class VehiclesPart2 {
   /**
    * Main method.
    * @param args not used
    * @throws FileNotFoundException if the file cannot be opened.
   */
   public static void main(String[] args) throws FileNotFoundException {
      
      UseTaxList test = new UseTaxList();
      test.readVehicleFile("vehicles1.txt");
      
      System.out.println(test.summary() + "\n");
            
      System.out.println(test.listByOwner() + "\n");
      
      System.out.println(test.listByUseTax() + "\n");
      
      System.out.println(test.excludedRecordsList());
      
      System.out.println("" + Arrays.toString(test.getVehicleList()));
   }

}