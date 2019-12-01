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
 * This class defines a stack that is able to store elements of type DrawingChange. Standard stack
 * operations, such as push(), pop(), and peek(), are implemented. The iterator() method can be used
 * to iterate through the stack.
 * 
 * @author Yash Hindka
 *
 */

public class DrawingStack implements StackADT<DrawingChange>, Iterable<DrawingChange> {

  private LinkedNode<DrawingChange> top; // top of linked stack
  private int size; // total number of DrawingChange objects stored in stack

  /**
   * This method returns a new iterator that can iterate through a list of type DrawingChange
   * 
   * @return instance of DrawingStackIterator
   */
  @Override
  public Iterator<DrawingChange> iterator() {

    return new DrawingStackIterator(top);
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws java.util.IllegalArgumentException with a descriptive error message if the input
   *                                            element is null
   */
  @Override
  public void push(DrawingChange element) {

    // checks if DrawingChange is null, throws exception accordingly
    if (element == null) {
      throw new IllegalArgumentException("Error: element is null");
    }
    // sets element to stack head if list is empty
    if (isEmpty()) {
      this.top = new LinkedNode<DrawingChange>(element);
    }
    // otherwise adds element to new node with head as its next node, then sets head to new node
    else {
      LinkedNode<DrawingChange> newNode = new LinkedNode<DrawingChange>(element, this.top);
      this.top = newNode;
    }
    // increment size
    size++;
  }

  /**
   * Remove the element on the top of this stack and return it
   * 
   * @return the element removed from the top of the stack
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public DrawingChange pop() {

    // checks if stack is empty, throws exception accordingly
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    // stores stack head's DrawingChange
    DrawingChange popped = this.top.getData();
    // if only 1 element in stack, sets head to null
    if (this.top.getNext() == null) {
      this.top = null;
    }
    // otherwise sets head to current head's next node
    else {
      this.top = this.top.getNext();
    }
    // decrement size
    size--;
    return popped;
  }

  /**
   * Get the element on the top of this stack
   * 
   * @return the element on the stack top
   * @throws java.util.EmptyStackException without error message if the stack is empty
   */
  @Override
  public DrawingChange peek() {

    // checks if stack is empty, throws exception accordingly
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    return this.top.getData();
  }

  /**
   * Check whether this stack is empty or not
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {

    return size == 0;
  }

  /**
   * Get the number of elements in this stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {

    return size;
  }

}
