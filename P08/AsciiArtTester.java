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


import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * This class tests the various classes in this project to ensure correct functionality.
 * 
 * @author Yash Hindka
 *
 */
public class AsciiArtTester {

  /**
   * Calls test methods
   * 
   * @param args - input argument
   */
  public static void main(String[] args) {

    // print boolean result of test methods
    System.out.println(testStackPushPeek());
    System.out.println(runAsciiArtTestSuite());
  }

  /**
   * Tests DrawingStack#push() and DrawingStack#peek() for correct functionality
   * 
   * @return true if tests are passed, false otherwise
   */
  public static boolean testStackPushPeek() {

    // create new DrawingStack object
    DrawingStack d = new DrawingStack();
    // enclose error-causing operation in try block
    try {
      // call peek() on empty stack
      d.peek();
      return false;
    }
    // catches exception so tests can continue
    catch (EmptyStackException e) {

    }
    // add element to stack
    d.push(new DrawingChange(0, 3, 'a', 'b'));
    // test peek method
    if (d.peek().col != 3 || d.peek().newChar != 'b')
      return false;
    // add element to stack
    d.push(new DrawingChange(4, 6, 'y', 'r'));
    // test peek method again
    if (d.peek().row != 4 || d.peek().prevChar != 'y')
      return false;
    return true;


  }

  /**
   * Tests DrawingChange class constructor
   * 
   * @return true if tests are passed, false otherwise
   */
  public static boolean testDrawingChange() {

    // create new DrawingChange object
    DrawingChange d = new DrawingChange(4, 5, '\0', 'Y');
    // check if row was initialized correctly
    if (d.row != 4)
      return false;
    // check if column was initialized correctly
    if (d.col != 5)
      return false;
    // check if prevChar was initialized correctly
    if (d.prevChar != '\0')
      return false;
    // check if newChar was initialized correctly
    if (d.newChar != 'Y')
      return false;
    return true;
  }

  /**
   * Tests DrawingStack pop, isEmpty, and size methods.
   * 
   * @return true if tests are passed, false otherwise
   */
  public static boolean testStackPopIsEmptySize() {

    // create new DrawingStack object
    DrawingStack d = new DrawingStack();
    // ensure isEmpty() return true
    if (!d.isEmpty())
      return false;
    // ensure size() returns 0
    if (d.size() != 0)
      return false;
    // enclose error-causing operation in try block
    try {
      // call pop() on empty stack
      d.pop();
      return false;
    }
    // catch exception so tests can continue
    catch (EmptyStackException e) {

    }
    // add element to stack
    d.push(new DrawingChange(0, 3, 'a', 'b'));
    // ensure size is 1
    if (d.size() != 1)
      return false;
    // test pop()
    if (d.pop().prevChar != 'a')
      return false;
    // ensure size is back to 0
    if (d.size() != 0)
      return false;
    return true;
  }

  /**
   * Tests Canvas draw(), undo(), and redo() methods
   * 
   * @return true if tests are passed, false otherwise
   */
  public static boolean testCanvas() {

    // enclose error-causing code in try block
    try {
      // create new Canvas object with invalid width and height
      Canvas c = new Canvas(-1, 0);
      // return false if exception is not thrown
      return false;
    }
    // catch exception
    catch (IllegalArgumentException e) {

    }
    // create valid Canvas object
    Canvas c = new Canvas(5, 7);
    // ensure Canvas height is 7
    if (c.getHeight() != 7)
      return false;
    // ensure Canvas width is 5
    if (c.getWidth() != 5)
      return false;
    // enclose error-causing code in try block
    try {
      // use draw() method with invalid location in Canvas
      c.draw(7, 6, 'Y');
      // return false if exception is not thrown
      return false;
    }
    // catch exception
    catch (IllegalArgumentException e) {

    }
    // use draw() method with valid location
    c.draw(6, 4, 'Y');
    // check if char was drawn correctly
    if (c.getChar(6, 4) != 'Y')
      return false;
    // add more elements to stack
    c.draw(5, 4, 'A');
    c.draw(2, 3, 'S');
    // use undo() method
    c.undo();
    // ensure redoStack was updated correctly
    if (c.peekRedo() != 'S')
      return false;
    // ensure undoStack was updated correctly
    if (c.peekUndo() != ' ')
      return false;
    return true;
  }

  /**
   * This method tests the DrawingStackIterator class
   * 
   * @return true if tests passed, false otherwise
   */
  public static boolean testDrawingStackIterator() {

    // create new DrawingStack object
    DrawingStack d = new DrawingStack();
    // add elements to stack
    d.push(new DrawingChange(0, 3, 'a', 'b'));
    d.push(new DrawingChange(4, 6, 'j', 'h'));
    d.push(new DrawingChange(1, 2, 'x', 'z'));
    // create new iterator object to iterate through stack
    Iterator<DrawingChange> itr = d.iterator();
    // ensure hasNext() method returns true (since iterator is positioned at start of stack and has
    // three elements in front of it)
    if (!itr.hasNext())
      return false;
    // check if next() method operates correctly
    if (itr.next().newChar != 'z')
      return false;
    if (itr.next().row != 4)
      return false;
    if (itr.next().col != 3)
      return false;
    return true;
  }

  /**
   * Runs various test methods in this class
   * 
   * @return true if all test methods are passed, false otherwise
   */
  public static boolean runAsciiArtTestSuite() {

    // call test methods
    if (!testDrawingChange())
      return false;
    if (!testStackPopIsEmptySize())
      return false;
    if (!testCanvas())
      return false;
    if (!testDrawingStackIterator())
      return false;
    return true;
  }

}
