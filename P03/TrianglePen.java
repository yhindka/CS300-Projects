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

import java.util.ArrayList;
import processing.core.PApplet;


/**
 * This class defines a TrianglePen, which takes in three points and forms a triangle.
 * 
 * @author Yash Hindka
 *
 */

public class TrianglePen {

  private PApplet processing;
  private boolean showPoints;
  private boolean mouseWasPressed; // mousePressed from previous update() call
  boolean drag; // true if point should be dragged, false if new point should be created
  private char keyWasPressed; // keyPressed from previous update() call
  private ArrayList<Point> pointArray; // stores points created upon mouse click
  private ArrayList<Triangle> triangleArray; // stores triangles created
  private Point userPoint; // stores point that user wants to drag


  /**
   * TrianglePen Constructor that initializes fields, including the processing library
   * 
   * @param processing - PApplet processing library
   * @param showPoints - program draws individual points if true, otherwise false
   */
  public TrianglePen(PApplet processing, boolean showPoints) {

    // initialize fields in constructor
    this.processing = processing;
    this.showPoints = showPoints;
    mouseWasPressed = false;
    keyWasPressed = '\0';
    pointArray = new ArrayList<Point>();
    triangleArray = new ArrayList<Triangle>();
    userPoint = null;
    drag = false;

  }


  /**
   * Delegates actions taken by user to be handled by the correct methods. Additionally, calls
   * draw() method to keep updating images on screen.
   * 
   * @param mouseX       - x position of mouse
   * @param mouseY       - y position of mouse
   * @param mousePressed - true if mouse is pressed
   * @param keyPressed   - char value of keyboard key that is pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {

    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }
    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    // process keyboard-based user input
    if (keyPressed != keyWasPressed)
      handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    // draw everything in its current state
    draw();

  }

  /**
   * This method is called upon user mouse click and creates a point at the click location unless a
   * point already exists at the click location. In such case, the point is simply dragged to a new
   * location by the user.
   * 
   * @param mouseX - x position of mouse
   * @param mouseY - y position of mouse
   */
  private void handleMousePress(int mouseX, int mouseY) {

    // loops through pointArray to check if there is already a point at click location
    for (int i = 0; i < pointArray.size(); i++) {

      // allows point to be dragged
      if (pointArray.get(i).isOver(mouseX, mouseY)) {
        userPoint = pointArray.get(i);
        drag = true;
        break;
      }
    }


    // if there is no point at click location, adds a new point to pointArray
    if (!(drag)) {
      pointArray.add(new Point(mouseX, mouseY));
      // creates a triangle in triangleArray every 3 points
      if (pointArray.size() % 3 == 0) {
        triangleArray.add(new Triangle(pointArray.get(pointArray.size() - 3),
            pointArray.get(pointArray.size() - 2), pointArray.get(pointArray.size() - 1), -1));
      }
    }
  }

  /**
   * Handles release of mouse click, especially when user is done dragging a point.
   * 
   * @param mouseX - x position of mouse
   * @param mouseY - y position of mouse
   */
  private void handleMouseRelease(int mouseX, int mouseY) {

    // if the user has released the mouse after dragging userPoint, sets boolean drag to false to
    // end dragging operation
    if (userPoint != null) {
      drag = false;
      userPoint = null;
    }


  }

  /**
   * Sets userPoint position to location where mouse is dragged
   * 
   * @param mouseX - x position of mouse
   * @param mouseY - y position of mouse
   */
  private void handleMouseDrag(int mouseX, int mouseY) {

    // checks if userPoint is in use
    if (userPoint != null) {

      // sets userPoint to new position
      userPoint.setPosition(mouseX, mouseY);
    }

  }

  /**
   * Called when user presses keyboard key, using keyPressed to set color of triangle that mouse is
   * over
   * 
   * @param mouseX     - x position of mouse
   * @param mouseY     - y position of mouse
   * @param keyPressed - char value of keyboard key pressed
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {

    // converts keyPressed to int
    int key = Character.getNumericValue(keyPressed);
    // creates oversize array of Triangle
    Triangle[] triangles = new Triangle[triangleArray.size()];
    // stores number of significant elements in array
    int trianglesSize = 0;
    // checks if key has value between 0 and 7 (inclusive)
    if (key <= 7 && key >= 0) {

      // fills triangles[] with elements of triangleArray
      for (int i = 0; i < triangleArray.size(); i++) {

        if (triangleArray.get(i).isOver(mouseX, mouseY)) {
          triangles[trianglesSize] = triangleArray.get(i);
          trianglesSize++;
        }
      }

      // loops through triangles to set color of each triangle
      for (int x = 0; x < trianglesSize; x++) {
        triangles[x].setColor(key);
      }
    }
  }

  /**
   * Updates the display as long as the program is running by drawing points and shading in
   * triangles.
   */
  private void draw() {

    // if showPoints is true, draws all points in pointArray
    if (showPoints) {
      for (Point p : pointArray) {

        p.draw(processing);
      }
    }

    // draws all triangles in triangleArray
    for (Triangle t : triangleArray) {

      t.draw(processing);
    }
  }

}
