import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * This program uses a number given by the user
 * to solve an equation.
 *
 * Project 03.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 9/18/17.
*/

public class ExpressionEvaluator {
/**
 * Uses the entered data (value) to evaluate the expression.
 * Also returns the number of digits to the left and right
 * of the decimal. Finally, the program formats the answer.
 *
 * @param args Command line arguments (not used).
*/

   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      double value = 0.0;
      double result = 0.0;
      int decimalL = 0;
      int decimalR = 0;
      String holder = "";
      int index = 0;
      String left = "";
      String right = "";
      
      //asks user for number
      System.out.print("Enter a value for x: ");
      value = userInput.nextDouble();
      //System.out.println(value);
      
      //evaluates equation with the user's number
      result = (Math.sqrt(Math.abs(23.7 * Math.pow(value, 9)) - value));
      result = result / ((7.3 * Math.pow(value, 2)) + (5.2 * value) + 3.1);
      
      //finds decimal point
      holder = Double.toString(result);
      index = holder.indexOf(".");
      //System.out.println(index);
      
      //finds how many places are to the L/R of .
      left = holder.substring(0, index);
      right = holder.substring(index + 1);
      decimalL = left.length();
      decimalR = right.length();
      
      //formatting
      DecimalFormat df = new DecimalFormat("#,##0.0####");

      //prints everything
      System.out.println("Result: " + result);
      System.out.println("# digits to left of decimal point: " + decimalL);
      System.out.println("# digits to right of decimal point: " + decimalR);
      System.out.println("Formatted Result: " + df.format(result));
   }

}