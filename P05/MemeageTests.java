//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P05 Memeage 5000
// Files: Color.java, ColorPlusChar.java, FourBytes.java, Image.java, Memeage.java,
// MemeageTests.java
// Course: CS300, Fall 2019
//
// Author: Yash Hindka
// Email: yhindka@wisc.edu
// Lecturer's Name: Mouna KACEM
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////


import java.io.File;
import java.io.IOException;

/**
 * This class tests the various classes and methods for the P05 Memeage 5000 project.
 * 
 * @author Yash Hindka
 *
 */

public class MemeageTests {

  /**
   * Main method that calls and prints the results of tester methods
   * 
   * @param args - input arguments
   */
  public static void main(String[] args) {

    // call methods that call various other methods in the Color, ColorPlusChar, and Memeage classes
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }

  /**
   * Tests FourBytes#setBits() to see if bits are properly configured
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testFourBytesSetBits() {

    // create new FourBytes object initialized to 0
    FourBytes f = new FourBytes(0);
    // call setBits() to set 3 bits with an offset of 8 and a value of 13
    f.setBits(3, 8, 13);
    // checks if bits were properly set, returns false otherwise
    if (!(f.toString().equals("1280 = 10100000000")))
      return false;
    return true;
  }

  /**
   * Tests FourBytes#getBits() to see if the method correctly returns the decimal form of the
   * specified bits
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testFourBytesGetBits() {

    // create new FourBytes object initialized to 13312
    FourBytes f = new FourBytes(13312);
    // checks if constructor and get bits perform correctly, returns false otherwise
    if (!(f.getBits(4, 10) == 13))
      return false;
    // sets bits to different values
    f.setBits(8, 8, 250);
    // checks if getBits() correctly returns different values, return false otherwise
    if (f.getBits(8, 8) != 250)
      return false;
    return true;
  }

  /**
   * Tests Color class to see if constructor, setter, and getter methods function correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testColor() {

    // creates new Color object using constructor that takes 4 int variables as parameters
    Color c = new Color(255, 254, 253, 252);
    // checks if constructor properly initialized variables, returns false otherwise
    if (c.getAlpha() != 255)
      return false;
    // sets different intensity for blue
    c.setBlue(150);
    // checks if setter and getter methods correctly mutated and retrieved the values, returns false
    // otherwise
    if (c.getBlue() != 150)
      return false;
    return true;
  }

  /**
   * Tests Image class to see if image is loaded correctly, image width and height are correct, and
   * pixel Color values are correct
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testImage() {

    // surround code that could throw exceptions with try block
    try {
      // load image file
      Image image = new Image(new File("src/testImage.png"));
      // checks if image width and height are correct, returns false otherwise
      if (image.getWidth() != 3 || image.getHeight() != 3)
        return false;
      // checks if pixel Color values are correct, returns false otherwise
      if (image.getColor(1, 1).getRed() != 0 || image.getColor(1, 1).getBlue() != 255
          || image.getColor(1, 1).getGreen() != 255)
        return false;

      // catch block to catch IOException if file cannot be found in directory
    } catch (IOException e1) {

      System.out.println("File Not Found");
      return false;
    }

    return true;


  }

  /**
   * Tests ColorPlusChar class to see if constructor, setter, and getter methods perform correctly
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testColorPlusChar() {

    // creates new ColorPlusChar object using constructor that takes a Color object as a parameter
    ColorPlusChar c = new ColorPlusChar(new Color(250, 100, 50, 175));
    // stores specified char in ColorPlusChar object
    c.hideChar('H');
    // checks if setter method properly stored char and if getter method revealChar() properly
    // retrieved char, returns false otherwise
    if (c.revealChar() != 'H')
      return false;
    return true;
  }

  public static boolean testMemeage() {

    try {
      Memeage m = new Memeage(new File("src/testImage.png"));
      m.setMeme("Hello");
      if (!(m.getMeme().equals("Hello")))
        return false;
      return true;

    }

    catch (IOException e1) {
      System.out.println("Error: File not found");
    }

    catch (IllegalStateException e2) {
      System.out.println(e2.getMessage());
    }

    catch (IllegalArgumentException e3) {
      System.out.println(e3.getMessage());
    }

    return false;
  }
}
