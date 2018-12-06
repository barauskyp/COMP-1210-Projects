import java.text.DecimalFormat;
/**
 * This program contains all the methods
 * used to find the circumference, surface
 * area, and volume of a spherocylinder.
 *
 * Project 07.
 * @author : Natalie Eichorn - COMP 1210 - 006.
 * @version : 10/25/17.
*/
public class Spherocylinder {
   
   private String label = "";
   private double radius = 0;
   private double height = 0;
   
   /**
    * This is a blank constructor so the program can
    * still work even if the user enters stuff at 
    * different times.
   */
   public Spherocylinder() {
   }
   
  /**
   * Constructor method that takes in the label, radius,
   * and height of the spherocylinder.
   * @param labelIn takes the label of the spherocylinder
   * @param radiusIn takes double value for radius
   * @param heightIn takes double value for height
  */
   public Spherocylinder(String labelIn, double radiusIn, double heightIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setCylinderHeight(heightIn);
   }
   
  /**
   * Returns the String label. 
   * @return label returns a string
  */
   public String getLabel() {
      return label;
   }
   
   /**
    * Sets the name of the spherocylinder and
    * checks to make sure the entered name isn't null.
    * @param labelIn string name
    * @return boolean if the label is null or not
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      return false;
   }
   
   /**
    * Returns the radius.
    * @return radius as a double value
   */
   public double getRadius() {
      return radius;
   }
   
   /**
    * Sets the radius to the entered value, but it
    * makes sure that the entered value isnt negative.
    * @param radiusIn enters a positive double
    * @return boolean if radius is positive or not
   */
   public boolean setRadius(double radiusIn) {
      if (radiusIn >= 0) {
         radius = radiusIn;
         return true;
      }
      return false;
   }
   
   /**
    * Returns the height.
    * @return height as a double value.
   */
   public double getCylinderHeight() {
      return height;
   }
   
   /**
    * Sets the height and makes sure it isn't
    * negative.
    * @param heightIn uses entered double
    * @return boolean if height is positive or not
   */
   public boolean setCylinderHeight(double heightIn) {
      if (heightIn >= 0) {
         height = heightIn;
         return true;
      }
      return false;
   }
   
   /**
    * Calculates the circumference.
    * @return returns the circumference
   */
   public double circumference() {
      return 2 * Math.PI * getRadius();
   }
   
   /**
    * Calculates the surface area.
    * @return returns the surface area
   */
   public double surfaceArea() {
      return (2 * Math.PI * getRadius())
         * (2 * getRadius() + getCylinderHeight());
   }
   
   /**
    * Calculates the volume.
    * @return returns the volume.
   */
   public double volume() {
      return (Math.PI * Math.pow(getRadius(), 2))
         * ((4.0 / 3.0) * getRadius() + getCylinderHeight());
   }
   
   /**
    * Formats the output to show the label, radius value, and height value,
    * and returns the circumference, surface area, and volume.
    * @return output which contains all the information ^
   */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "";
      
      output = "Spherocylinder \"" + getLabel()
         + "\" with radius " + getRadius() + " and cylinder height "
         + getCylinderHeight() + " has:";
         
      output += "\n\tcircumference = " + df.format(circumference()) + " units";
      
      output += "\n\tsurface area = " + df.format(surfaceArea())
         + " square units";
      
      output += "\n\tvolume = " + df.format(volume()) + " cubic units";
      
      return output;
   }
}