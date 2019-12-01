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
 * This class creates a new ColorPlusChar object that is designed to store a character in a pixel of
 * an image. The class splits an 8 bit char into 2 bit pieces and stores each of the 2 bits at the
 * ends of the 8 bit sequences in a Color object. It uses methods to store and retrieve the char
 * value.
 * 
 * @author Yash Hindka
 *
 */

public class ColorPlusChar extends Color {

  /**
   * Constructor that creates a new Color object and stores the specified character within the
   * bitstring of the Color
   * 
   * @param color     - Color object to create a deep copy of
   * @param character - char value to be stored in Color object
   */
  public ColorPlusChar(Color color, char character) {

    // explicit call to super, creates new Color object by copying old
    super(color);
    // calls the method that stores the char value in the bitstring
    hideChar(character);
  }

  /**
   * Constructor that creates a new Color object from old.
   * 
   * @param color - Color object to create a deep copy of
   */
  public ColorPlusChar(Color color) {

    // explicit call to super, creates new Color object by copying old
    super(color);
  }

  /**
   * This method splits an 8 bit char into 2 bit chunks and stores those chunks into the least
   * significant portions of each of the 8 bit groups in the Color object
   * 
   * @param character - char value to be split up and stored
   */
  public void hideChar(char character) {
    FourBytes charBytes = new FourBytes(character);

    // stores all 8 bits of char in first 8 bits of charBytes
    charBytes.setBits(8, 0, character);
    // retrieves 2 bit chunks of char
    int bit1 = charBytes.getBits(2, 6);
    int bit2 = charBytes.getBits(2, 4);
    int bit3 = charBytes.getBits(2, 2);
    int bit4 = charBytes.getBits(2, 0);

    // stores 2 bit chunks in least significant portions of each of the 8 bit groups of Color object
    setBits(2, 24, bit1);
    setBits(2, 16, bit2);
    setBits(2, 8, bit3);
    setBits(2, 0, bit4);
  }


  /**
   * This method retrieves 8-bit character from the least significant bits of color components
   * 
   * @return 8 bit char value
   */
  public char revealChar() {

    // individually retrieves each of 8 bit values and converts them back to decimal form by
    // multiplying by appropriate power of 2
    double alpha1 = getBits(1, 25) * Math.pow(2, 7);
    double alpha2 = getBits(1, 24) * Math.pow(2, 6);
    double red1 = getBits(1, 17) * Math.pow(2, 5);
    double red2 = getBits(1, 16) * Math.pow(2, 4);
    double green1 = getBits(1, 9) * Math.pow(2, 3);
    double green2 = getBits(1, 8) * Math.pow(2, 2);
    double blue1 = getBits(1, 1) * Math.pow(2, 1);
    double blue2 = getBits(1, 0) * Math.pow(2, 0);
    // returns sum of 8 int bit values casted to char
    return (char) (alpha1 + alpha2 + red1 + red2 + green1 + green2 + blue1 + blue2);
  }

}
