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
 * This class defines a Point, which is the most basic element that a user can create with this
 * program.
 * 
 * @author Yash Hindka
 *
 */


public class Point {

  private int xPos; // x position of point
  private int yPos; // y position of point

  private static final int POINT_DIAMETER = 8; // diameter of point

  /**
   * Point constructor which sets the position of the point
   * 
   * @param xPos - x position of point
   * @param yPos - y position of point
   */
  public Point(int xPos, int yPos) {

    // initializes fields
    this.xPos = xPos;
    this.yPos = yPos;
  }

  /**
   * Accessor method that allows access to x position of point
   * 
   * @return x position of point
   */
  public int getX() {

    return xPos;
  }

  /**
   * Accessor method that allows access to y position of point
   * 
   * @return y position of point
   */
  public int getY() {

    return yPos;
  }

  /**
   * Mutator method that sets/changes position of point
   * 
   * @param x - x position to be set
   * @param y - y position to be set
   */
  public void setPosition(int x, int y) {

    xPos = x;
    yPos = y;
  }

  /**
   * Draws white point
   * 
   * @param drawTo - processing library that houses drawing methods
   */
  public void draw(PApplet drawTo) {

    // draw's a white circle at point location
    drawTo.fill(-1);
    drawTo.circle(getX(), getY(), POINT_DIAMETER);
  }


  /**
   * Calculates if mouse is in/over a point.
   * 
   * @param x - x position of mouse
   * @param y - y position of mouse
   * @return true if mouse is over point, false otherwise
   */
  public boolean isOver(int x, int y) {

    // calculates distance of mouse pointer from center of circle
    double distanceFromCenter = Math.sqrt(Math.pow((x - getX()), 2) + Math.pow((y - getY()), 2));
    // returns true when the position x, y is within the circle drawn to visualize this point,
    // otherwise returns false
    return distanceFromCenter < (POINT_DIAMETER / 2.0);
  }


}
