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

/**
 * This class creates a Color object that represents a pixel in an image. It contains various
 * methods to set and retrieve specific color values within a 32 bit FourBytes object.
 * 
 * @author Yash Hindka
 *
 */

public class Color extends FourBytes {

  /**
   * Constructor that creates new Color object with value passed in parameter and calls FourBytes
   * constructor to set value to 0.
   * 
   * @param argb - value to be represented by new Color object
   */
  public Color(int argb) {

    // explicit call to super
    super(0);
    // initialize int value of Color object
    setARGB(argb);
  }

  /**
   * Constructor that creates new Color object by assigning each parameter to 8 bits in a FourBytes
   * object
   * 
   * @param alpha - level of transparency or opacity in Color
   * @param red   - level of red in Color
   * @param green - level of green in Color
   * @param blue  - level of blue in Color
   */
  public Color(int alpha, int red, int green, int blue) {

    // explicit call to super
    super(0);
    // initialize each value to 8 bits of a FourBytes object
    setAlpha(alpha);
    setRed(red);
    setGreen(green);
    setBlue(blue);
  }

  /**
   * Constructor that creates a deep copy of a Color object that has already been created
   * 
   * @param other - Color object that has already been created
   */
  public Color(Color other) {

    // explicit call to Color constructor that takes int as parameter
    this(other.getARGB());
  }

  /**
   * Retrieves the int value represented by this Color object
   * 
   * @return int value represented by Color object
   */
  public int getARGB() {

    return getInt();
  }

  /**
   * Retrieves alpha value stored in first 8 bits of this Color object
   * 
   * @return int value of intensity of alpha
   */
  public int getAlpha() {

    return getBits(8, 24);
  }

  /**
   * Retrieves red value stored in second 8 bits of this Color object
   * 
   * @return int value of intensity of red
   */
  public int getRed() {

    return getBits(8, 16);
  }

  /**
   * Retrieves green value stored in third 8 bits of this Color object
   * 
   * @return int value of intensity of green
   */
  public int getGreen() {

    return getBits(8, 8);
  }

  /**
   * Retrieves blue value stored in fourth 8 bits of this Color object
   * 
   * @return int value of intensity of blue
   */
  public int getBlue() {

    return getBits(8, 0);
  }

  /**
   * Sets the int value represented by this Color object
   * 
   * @param argb - int value to be stored
   */
  public void setARGB(int argb) {

    setInt(argb);
  }

  /**
   * Sets alpha value represented by this Color object in first 8 bits
   * 
   * @param alpha - int value of alpha intensity to be stored
   */
  public void setAlpha(int alpha) {

    setBits(8, 24, alpha);
  }

  /**
   * Sets red value represented by this Color object in second 8 bits
   * 
   * @param red - int value of red intensity to be stored
   */
  public void setRed(int red) {

    setBits(8, 16, red);
  }

  /**
   * Sets green value represented by this Color object in third 8 bits
   * 
   * @param green - int value of red intensity to be stored
   */
  public void setGreen(int green) {

    setBits(8, 8, green);
  }

  /**
   * Sets blue value represented by this Color object in fourth 8 bits
   * 
   * @param blue - int value of blue intensity to be stored
   */
  public void setBlue(int blue) {

    setBits(8, 0, blue);
  }

}
