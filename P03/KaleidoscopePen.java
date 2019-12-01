//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Kaleidoscope Pen
// Files: DriverApplication.java, TrianglePen.java, Point.java, Triangle.java, KaleidoscopePen.java
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


import processing.core.PApplet;

/**
 * This class defines an object that handles multiple TrianglePens. When utilized, it creates a
 * specified number of TrianglePens, all of which draw the same points and triangles, just at
 * different angles. This creates a kaleidoscopic effect.
 * 
 * @author Yash Hindka
 *
 */

public class KaleidoscopePen {

  private TrianglePen[] penArray; // array holding TrianglePens
  private PApplet processing; // processing library

  /**
   * KaleidoscopePen constructor that creates array of TrianglePens
   * 
   * @param drawTo               - processing library
   * @param numberOfTrianglePens - specifies number of TrianglePens to be initialized in array
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {

    // initializes fields and penArray
    processing = drawTo;
    penArray = new TrianglePen[numberOfTrianglePens];
    for (int i = 0; i < numberOfTrianglePens; i++) {

      if (i == 0) {
        penArray[i] = new TrianglePen(processing, true);
      } else {
        penArray[i] = new TrianglePen(processing, false);
      }
    }
  }


  /**
   * Rotates pens in penArray in order to create kaleidoscopic effect.
   * 
   * @param mouseX       - x position of mouse
   * @param mouseY       - y position of mouse
   * @param mousePressed - true if mouse is pressed
   * @param keyPressed   - char value of keyboard key pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {

    // loops through penArray and rotates each pen at an increasing angle
    for (int i = 0; i < penArray.length; i++) {
      penArray[i].update(rotate(mouseX, mouseY, i * 2 * Math.PI / penArray.length)[0],
          rotate(mouseX, mouseY, i * 2 * Math.PI / penArray.length)[1], mousePressed, keyPressed);
    }
  }

  /**
   * Rotates a position around the center of an 800x600 screen by the specified amount, and then
   * returns an array containing the resulting position.
   * 
   * @param x     position of the point to be rotated (0 to 800 pixels)
   * @param y     position of the point to be rotated (0 to 600 pixels)
   * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI)
   * @return the rotated position array: x @ index 0, y @ index 1
   */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
        (int) (x * Math.cos(angle) - y * Math.sin(angle)),
        (int) (x * Math.sin(angle) + y * Math.cos(angle))};
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }

}
