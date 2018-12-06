/**
 * This class gives examples of all the other classes.
 *
 * Project 09.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 11/16/17.
*/
public class VehiclesPart1 {
   /**
    * Main method.
    *
    * @param args Command line arguments (not used).
   */
   public static void main(String[] args) {
   
   //cars
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
         110000, true);
         
      System.out.println(car1);
      System.out.println(car2);
      System.out.println(car3);
      System.out.println(car4);
      
      System.out.println("");
      
      
   //trucks
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack",
         40000, true, 2.5);
         
      System.out.println(truck1);
      System.out.println(truck2);
      
      System.out.println("");
   
   //semis
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy",
         45000, false, 5.0, 4);
      
      System.out.println(semi1);
      System.out.println("");
   
   //motorcycles
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster",
         14000, false, 750);
         
      System.out.println(bike1);
      System.out.println("");
   }
}