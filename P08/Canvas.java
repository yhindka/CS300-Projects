//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 Ascii Art
// Files: StackADT.java, LinkedNode.java, DrawingChange.java, DrawingStack.java,
// DrawingStackIterator.java, AsciiArtTester.java, Canvas.java, AsciiArtDriver.java
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
 * This class represents an ASCII-Art image
 * 
 * @author Yash Hindka
 *
 */

public class Canvas {

  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char[][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo


  /**
   * Constructor creates a new canvas which is initially blank
   * 
   * @param width  - width of canvas
   * @param height - height of canvas
   */
  public Canvas(int width, int height) {

    // checks if width and height are greater than 0, throws exception accordingly
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be greater than 0");
    }

    // initialize variables
    this.width = width;
    this.height = height;
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
    drawingArray = new char[height][width];
    // loops through drawingArray and replaces null positions with ' ' char
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        drawingArray[r][c] = ' ';
      }
    }
  }


  /**
   * Draw a character at the given position drawingArray[row][col]. If position is already marked
   * with a different character, overwrites it. Then adds the DrawingChange to undoStack and clears
   * redoStack.
   * 
   * @param row - canvas row to draw in
   * @param col - canvas column to draw in
   * @param c   - char to draw
   * @throws IllegalArgumentException if row or col is outside of canvas
   */
  public void draw(int row, int col, char c) {

    if (row < 0 || col < 0 || row > height || col > width) {
      throw new IllegalArgumentException("Drawing position is outside the canvas");
    }

    // stores char already in specified position
    char prevChar = drawingArray[row][col];
    // draws new char into specified position
    drawingArray[row][col] = c;
    // adds DrawingChange to undoStack
    undoStack.push(new DrawingChange(row, col, prevChar, c));
    // clears redoStack
    while (!redoStack.isEmpty()) {
      redoStack.pop();
    }
  }

  /**
   * Undo the most recent drawing change. Undone DrawingChange is removed from undoStack and added
   * to redoStack.
   * 
   * @return true if undo successful, false otherwise
   */
  public boolean undo() {

    // removes operation from undoStack
    DrawingChange undo = undoStack.pop();
    // reverts drawingArray back to prior status by inserting previous char
    drawingArray[undo.row][undo.col] = undo.prevChar;
    // adds operation to redoStack
    redoStack.push(undo);
    // checks if undo operation was successful
    if (drawingArray[undo.row][undo.col] != undo.prevChar) {
      return false;
    }
    return true;
  }


  /**
   * Redo the most recent undone drawing change. Redone DrawingChange is removed from redoStack and
   * added to undoStack.
   * 
   * @return true if redo successful, false otherwise
   */
  public boolean redo() {

    // removes operation from redoStack
    DrawingChange redo = redoStack.pop();
    // reverts drawingArray back to prio status by inserting new char
    drawingArray[redo.row][redo.col] = redo.newChar;
    // adds operation to undoStack
    undoStack.push(redo);
    // checks if redo operation was successful
    if (drawingArray[redo.row][redo.col] != redo.newChar) {
      return false;
    }
    return true;
  }

  /**
   * Accessor method for char at certain position.
   * 
   * @param row - row number to access
   * @param col - column number to access
   * @return char value stored at specified position
   */
  public char getChar(int row, int col) {

    return drawingArray[row][col];
  }

  /**
   * Getter method for canvas height
   * 
   * @return canvas height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Getter method for canvas width
   * 
   * @return canvas width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Reveals top of redoStack through peek() method
   * 
   * @return newChar field at top of redoStack
   */
  public char peekRedo() {

    return redoStack.peek().newChar;
  }

  /**
   * Reveals top of undoStack through peek() method
   * 
   * @return prevChar field at top of undoStack
   */
  public char peekUndo() {

    return undoStack.peek().prevChar;
  }


  /**
   * Return a printable string version of the Canvas.
   * 
   * @return string representation of this Canvas object
   */
  public String toString() {

    // create empty string
    String ascii = "";

    // loops through drawingArray
    for (int r = 0; r < drawingArray.length; r++) {

      for (int c = 0; c < drawingArray[0].length; c++) {

        // if char at this location only stores a ' ' (space) char, concatenates "_" to String ascii
        if (drawingArray[r][c] == ' ') {
          ascii += "_";
        }
        // otherwise concatenates the char at this location to String ascii
        else {
          ascii += drawingArray[r][c];
        }
      }
      // adds line separator to String ascii at end of each row
      ascii += System.lineSeparator();
    }

    return ascii;
  }
}
