import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/**
 * This program uses user entered info to determine the
 * contents of a ticket to the moon.
 *
 * Project 03.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 9/20/17.
*/
public class MoonTrip {

   static final double STUDENT_DISCOUNT = .40;
   static final double EMPLOYEE_DISCOUNT = .20;
/**
 * Uses the entered data (ticket) to return the date of
 * takeoff, the time, the seat number, what the ticket
 * is for, the price (incuding the discount if available),
 * and a random prize number.
 *
 * @param args Command line arguments (not used).
*/
   public static void main(String[] args) {
   
      Scanner scan = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("$#,###.00");
      DecimalFormat dfp = new DecimalFormat("0000");
      Random generator = new Random();
      String input = "";
      
      String month = "";
      String day = "";
      String year = "";
      
      String hr = "";
      String min = "";
      
      String seat = "";
      
      char category;

      double price = 0.0;
      double cost = 0.0;
        
      int prize = 0;
      
      String description = "";
      
///////////////////////////////////////////////////////////////////////////////
      
      System.out.print("Enter ticket code: ");
      input = scan.nextLine().trim();
      System.out.println("");
      
      if (input.length() < 26) {
         System.out.println("*** Invalid ticket code ***"
            + "\nTicket code must have at least 26 characters.");
      }
      else {
         //date
         month = input.substring(0, 2);
         day = input.substring(2, 4);
         year = input.substring(4, 8);
         System.out.print("Date: " + month + "/" + day + "/" + year);
         
         //time
         hr = input.substring(8, 10);
         min = input.substring(10, 12);
         System.out.print("   Time: " + hr + ":" + min);
         
         //seat
         seat = input.substring(22, 25);
         System.out.print("   Seat: " + seat);
         
         //itinerary
         description = input.substring(25);
         System.out.print("\nItinerary: " + description);
         
         //price
         price = Integer.parseInt(input.substring(13, 22)) / 100;
         System.out.print("\nPrice: " + df.format(price));
         
         //category
         category = input.charAt(12);
         System.out.print("   Category: " + category);
         
         //cost
         if (category == 's') {
            cost = price - (price * STUDENT_DISCOUNT);
         }
         else if (category == 'e') {
            cost = price - (price * EMPLOYEE_DISCOUNT);
         }
         else {
            cost = price;
         }
         System.out.print("   Cost: " + df.format(cost));
         
         //prize
         prize = (int) generator.nextInt(10000);
         System.out.println("\nPrize Number: " + dfp.format(prize));
      }
   }
}