import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;
/**
 * UseTaxList.
 *
 * Project 11.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 12/05/17.
*/
public class UseTaxList {

   private String taxDistrict = "not yet assigned";
   private Vehicle[] vehicleList;
   private String[] excludedRecords;

   private String name = "";
   private String ymm = "";
   private double value = 0;
   private boolean fuel = false;
   private double tons = 0;
   private int axles = 0;
   private double engine = 0;
   
   private String reject = "";
   private String x = "";
   
   /**
    * Constructor.
   */
   public UseTaxList() {
      vehicleList = new Vehicle[0];
      excludedRecords = new String[0];
   }
   
   /**
    * Reads the file and splits up the parts.
    * @param dataFileName name of file
    * @throws FileNotFoundException if the file cannot be opened.
   */
   public void readVehicleFile(String dataFileName)
      throws FileNotFoundException {
      
      Scanner scan = new Scanner(new File(dataFileName));
      
      taxDistrict = scan.nextLine().trim();
      
      while (scan.hasNext()) {
         x = scan.nextLine().trim();
         Scanner scan2 = new Scanner(x);
         scan2.useDelimiter(";");
         
         String type = scan2.next();
         char code =  type.toUpperCase().charAt(0);
         
         switch(code) {
            case 'C':
               try {
                  name = scan2.next().trim();
                  ymm = scan2.next().trim();
                  value = Double.parseDouble(scan2.next().trim());
                  fuel = Boolean.parseBoolean(scan2.next().trim());
                  
                  addVehicle(new Car(name, ymm, value, fuel));
               }
               catch (NegativeValueException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NoSuchElementException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NumberFormatException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               break;
               
            case 'T':
               try {
                  name = scan2.next().trim();
                  ymm = scan2.next().trim();
                  value = Double.parseDouble(scan2.next().trim());
                  fuel = Boolean.parseBoolean(scan2.next().trim());
                  tons = Double.parseDouble(scan2.next().trim());
                  
                  addVehicle(new Truck(name, ymm, value, fuel, tons));
               }
               catch (NoSuchElementException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NegativeValueException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NumberFormatException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               break;
               
            case 'S':
               try {
                  name = scan2.next().trim();
                  ymm = scan2.next().trim();
                  value = Double.parseDouble(scan2.next().trim());
                  fuel = Boolean.parseBoolean(scan2.next().trim());
                  tons = Double.parseDouble(scan2.next().trim());
                  axles = Integer.parseInt(scan2.next().trim());
                  
                  addVehicle(new SemiTractorTrailer(name, ymm, value,
                     fuel, tons, axles));
               }
               catch (NoSuchElementException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NegativeValueException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NumberFormatException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               break;
               
            case 'M':
               try {
                  name = scan2.next().trim();
                  ymm = scan2.next().trim();
                  value = Double.parseDouble(scan2.next().trim());
                  fuel = Boolean.parseBoolean(scan2.next().trim());
                  engine = Integer.parseInt(scan2.next().trim());
               
                  addVehicle(new Motorcycle(name, ymm, value, fuel, engine));
               }
               catch (NoSuchElementException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NegativeValueException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               catch (NumberFormatException e) {
                  String output = e + " in:\n";
                  output += x;
                  addExcludedRecord(output);
               }
               break;
               
            default:
               reject += "Invalid Vehicle Category in:\n";
               reject += x;
               addExcludedRecord(reject);
               break;
         }
      }
   }
   
   /**
    * Returns tax district name.
    * @return taxDistrict name
   */
   public String getTaxDistrict() {
      return taxDistrict;
   }
   
   /**
    * Sets tax district name.
    * @param taxDIn new name
   */
   public void setTaxDistrict(String taxDIn) {
      taxDistrict = taxDIn;
   }
   
   /**
    * Returns vehicle list.
    * @return vehicleList list
   */
   public Vehicle[] getVehicleList() {
      return vehicleList;
   }
   
   /**
    * Returns excluded records list.
    * @return excludedRecords list
   */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   /**
    * Adds a vehicle to the list.
    * @param obj Vehicle
   */
   public void addVehicle(Vehicle obj) {
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = obj;
   }
   
   /**
    * Adds a record to the reject list.
    * @param record String
   */
   public void addExcludedRecord(String record) {
      excludedRecords = Arrays.copyOf(excludedRecords,
         excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = record;
   }
   
   /**
    * toString.
    * @return output String
   */
   public String toString() {
      String output = "";
      
      for (Vehicle vehicle : vehicleList) {
         output += "" + vehicle.toString() + "\n\n";
      }
      
      return output;
   }
   
   /**
    * Calculates total use tax.
    * @return total total tax
   */
   public double calculateTotalUseTax() {
      double total = 0;
      
      for (Vehicle v : vehicleList) {
         total += v.useTax();
      }
      return total;
   }
   
   /**
    * Calculates total value.
    * @return total total value
   */
   public double calculateTotalValue() {
      double total = 0;
      
      for (Vehicle v : vehicleList) {
         total += v.value;
      }
      return total;  
   }
   
   /**
    * Returns summary.
    * @return output all the info
   */
   public String summary() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");
   
      String output = "";
      output += "------------------------------" + "\n";
      output += "Summary for " + getTaxDistrict() + "\n";
      output += "------------------------------" + "\n";
      
      output += "Number of Vehicles: " + getVehicleList().length + "\n";
      output += "Total Value: " + df.format(calculateTotalValue()) + "\n";
      output += "Total Use Tax: " + df.format(calculateTotalUseTax()) + "\n";
      
      return output;
   }
   
   /**
    * Returns list by owner.
    * @return output sorted by owner
   */
   public String listByOwner() {
      String output = "";
      Arrays.sort(vehicleList);
      
      output += "------------------------------" + "\n";
      output += "Vehicles by Owner \n";
      output += "------------------------------" + "\n";
      
      for (int i = 0; i < vehicleList.length; i++) {
         output += "\n" + vehicleList[i] + "\n";
      }
      
      return output;
   }
   
   /**
    * Returns list by use tax.
    * @return output sorted by use tax
   */
   public String listByUseTax() {
      String output = "";
      Arrays.sort(vehicleList, new UseTaxComparator());
      
      output += "------------------------------" + "\n";
      output += "Vehicles by Use Tax \n";
      output += "------------------------------" + "\n";
      
      for (int i = 0; i < vehicleList.length; i++) {
         output += "\n" + vehicleList[i] + "\n";
      }
      
      return output;
   }
   
   /**
    * Returns excluded records.
    * @return output excluded records
   */
   public String excludedRecordsList() {
      String output = "";
      
      output += "------------------------------" + "\n";
      output += "Excluded Records \n";
      output += "------------------------------" + "\n";
      
      for (int i = 0; i < excludedRecords.length; i++) {
         output += "\n" + excludedRecords[i] + "\n";
      }
      
      return output;
   }
}