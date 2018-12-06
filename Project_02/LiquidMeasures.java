import java.util.Scanner;
/**
 * This program returns data for an oil company to show
 * an amount of liquid in barrels/gallons/quarts/ounces.
 *
 * Project 02.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 9/06/17.
*/

public class LiquidMeasures
{
/**
 * Uses the entered data (ounces) and prints how many
 * barrels/gallons/quarts/ounces the entered amount can
 * fit in.
 *
 * @param args Command line arguments (not used).
*/
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      
      int amount = 0;
      int barrel = 0;
      int gallon = 0;
      int quarts = 0;
      int ounces = 0;
      int saver = 0;
      
      System.out.print("Enter amount of liquid in ounces: ");
      amount = scan.nextInt();
      saver = amount;
      
      if (amount > 1000000000)
      {
         System.out.println("Amount must not exceed 1,000,000,000.");
      }
      else
      {
         barrel = amount / 5376;
         amount = amount - barrel * 5376;
         gallon = amount / 128;
         amount = amount - gallon * 128;
         quarts = amount / 32;
         amount = amount - quarts * 32;
         ounces = amount;
         
         System.out.println("Measures by volume:");
         System.out.println("\tBarrels: " + barrel);
         System.out.println("\tGallons: " + gallon);
         System.out.println("\tQuarts: " + quarts);
         System.out.println("\tOunces: " + ounces);
         
         System.out.println(saver + " oz = (" + barrel
               + " bl * 5376 oz) + (" + gallon + " gal * 128 oz) + ("
               + quarts + " qt * 32 oz) + (" + ounces + " oz)");
      }
   }
}