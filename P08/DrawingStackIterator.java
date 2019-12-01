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


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an iterator capable of traversing a list of type DrawingChange
 * 
 * @author Yash Hindka
 *
 */

public class DrawingStackIterator implements Iterator<DrawingChange> {

  LinkedNode<DrawingChange> current; // node to keep track of next element in iteration

  /**
   * Constructor that initializes current to parameter
   * 
   * @param head - LinkedNode<DrawingChange> to be set to current
   */
  public DrawingStackIterator(LinkedNode<DrawingChange> head) {

    // initialize variables
    current = head;
  }

  /**
   * Checks if next iteration is null
   * 
   * @return true if next iteration is not null, false otherwise
   */
  @Override
  public boolean hasNext() {

    return current != null;
  }

  /**
   * Retrieves next iteration in list
   * 
   * @return DrawingChange object stored in next iteration
   * @throws NoSuchElementException if there is no next element
   */
  @Override
  public DrawingChange next() {

    // checks if current is null, throws exception accordingly
    if (current == null) {
      throw new NoSuchElementException("The stack has been exhausted and there is no next element");
    }

    // stores current node's DrawingChange
    DrawingChange temp = current.getData();
    // advance current
    current = current.getNext();
    return temp;
  }

}
