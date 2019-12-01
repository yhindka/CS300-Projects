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
 * This class defines a triangle, which is created using three elements of the Point class.
 * 
 * @author Yash Hindka
 *
 */


public class Triangle {

  // instances of 3 points for triangle
  private Point point1;
  private Point point2;
  private Point point3;
  // index of color of triangles
  private int colorIndex;

  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
      // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
      -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  /**
   * Triangle constructor that takes in 3 elements of type Point and a color index.
   * 
   * @param p1    - Point 1
   * @param p2    - Point 2
   * @param p3    - Point 3
   * @param index - color index
   */
  public Triangle(Point p1, Point p2, Point p3, int index) {

    // initializes fields
    point1 = p1;
    point2 = p2;
    point3 = p3;
    colorIndex = index;

  }

  /**
   * Sets colorIndex to the index of the COLORS array specified by the parameter.
   * 
   * @param color - index to be set
   */
  public void setColor(int color) {

    colorIndex = COLORS[color];
  }

  /**
   * Draws triangles with color specified by colorIndex.
   * 
   * @param drawTo - processing library
   */
  public void draw(PApplet drawTo) {

    drawTo.fill(colorIndex);
    drawTo.triangle(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(),
        point3.getY());
  }

  /**
   * checks if point is inside triangle or not
   * 
   * @param x - x position of mouse
   * @param y - y position of mouse
   * @return true if mouse is inside triangle, false otherwise
   */
  public boolean isOver(int x, int y) {

    int px = x;
    int py = y;
    int t1x = point1.getX();
    int t2x = point2.getX();
    int t3x = point3.getX();
    int t1y = point1.getY();
    int t2y = point2.getY();
    int t3y = point3.getY();

    px -= t1x; // don't worry about this arithmetic
    py -= t1y;
    t2x -= t1x;
    t2y -= t1y;
    t3x -= t1x;
    t3y -= t1y;
    double dotp2 = px * t2x + py * t2y;
    double dotp3 = px * t3x + py * t3y;
    double dot22 = t2x * t2x + t2y * t2y;
    double dot23 = t2x * t3x + t2y * t3y;
    double dot33 = t3x * t3x + t3y * t3y;
    double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
    double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
    double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
    return (a >= 0) && (b >= 0) && (a + b < 1);
  }

}
