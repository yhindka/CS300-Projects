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
 * This class is designed to take an image file and loop through each pixel to incorporate a
 * character of a message string into each pixel. It contains appropriate setter and getter methods
 * to set and retrieve the string message.
 * 
 * @author Yash Hindka
 *
 */

public class Memeage extends Image {

  /**
   * Constructor that takes in an image file and uses the Image class to fill an array with pixels
   * in the image
   * 
   * @param file - image file to be used to fill array
   * @throws IOException if file is not found in directory
   */
  public Memeage(File file) throws IOException {

    // explicit call to super
    super(file);
  }

  /**
   * Constructor that fills an array with pixels of the image file parameter then calls a method to
   * store a string in the image's pixels
   * 
   * @param file - image file to be used
   * @param meme - string to be stored in pixels
   * @throws IOException              if file is not found in directory
   * @throws IllegalArgumentException if length of string is larger than number of pixels in image
   */
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {

    // explicit call to super
    super(file);
    // method call that stores each character of String meme into a pixel of the image file
    setMeme(meme);
  }

  /**
   * This method fills the pixels of an image with characters of the string parameter
   * 
   * @param meme - String to be filled in pixels
   * @throws IllegalArgumentException if length of string is longer than number of pixels in image
   *                                  or if string contains invalid character (ASCII value > 127)
   */
  public void setMeme(String meme) throws IllegalArgumentException {

    // checks if string is too long and throws exception accordingly
    if (meme.length() >= (getHeight() * getWidth())) {

      throw new IllegalArgumentException("Error: Length of string is too large for image.");
    }

    // index to keep track of what character is next in the string
    int i = 0;

    // loops through pixels in image
    for (int y = 0; y < getHeight(); y++) {

      for (int x = 0; x < getWidth(); x++) {
        // creates new ColorPlusChar object with Color of current pixel
        ColorPlusChar c = new ColorPlusChar(getColor(x, y));
        // checks if index i has reached the end of the string
        if (i >= meme.length()) {
          // places the null character in the pixel following the one that stores the last character
          // in the string
          c.hideChar('\0');
          // replaces the current pixel Color value with the Color value that also stores the null
          // character
          setColor(x, y, new Color(c.getAlpha(), c.getRed(), c.getGreen(), c.getBlue()));
          // breaks the for loop because the end of the string has been reached
          break;
          // checks if the string contains an invalid character at index i and throws exception
          // accordingly
        } else if (meme.charAt(i) > 127) {
          throw new IllegalArgumentException("Error: invalid character at index " + i);
        }
        // if no errors are thrown and the end of the string has not been reached, the next
        // character in the string is incorporated into the current pixel's Color value
        c.hideChar(meme.charAt(i));
        setColor(x, y, new Color(c.getAlpha(), c.getRed(), c.getGreen(), c.getBlue()));
        // index i is incremented
        i++;
      }
    }
  }

  /**
   * This method retrieves the string stored in the pixels of an image
   * 
   * @return the String stored within the image's pixels
   * @throws IllegalStateException if an invalid character is read or if there is no null character
   *                               at the end of the String
   */
  public String getMeme() throws IllegalStateException {

    // initializes an empty string that will be used to store retrieved characters
    String meme = "";
    // loops through pixels in the image
    for (int y = 0; y < getHeight(); y++) {

      for (int x = 0; x < getWidth(); x++) {

        // creates new ColorPlusChar object with Color of current pixel
        ColorPlusChar c = new ColorPlusChar(getColor(x, y));
        // checks if the pixel stores an invalid character and throws an exception accordingly
        if (((int) c.revealChar()) > 127) {

          throw new IllegalStateException(
              "Error: invalid character " + c.revealChar() + " read at index " + y + ", " + x);
        }
        // adds character stored in pixel to String meme if the character is not null
        if (c.revealChar() != '\0') {
          meme += c.revealChar();
        }

        // if the last pixel has been reached and it is not null, throws an IllegalStateException
        else if (y == getHeight() - 1 && x == getWidth() - 1 && c.revealChar() != '\0') {

          throw new IllegalStateException("No null character found at end of string.");
          // breaks from loop once null character is reached
        } else if (c.revealChar() == '\0') {
          break;
        }
      }
    }

    // returns String meme after all characters have been added to it
    return meme;
  }

}
