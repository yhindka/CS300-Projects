//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Mega Blocks Builder
// Files: Color.java, MegaBlock.java, LinkedMegaBlock.java, LinkedListMegaBlock.java,
// MegaBlockBuilderTester.java
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


import java.util.NoSuchElementException;

/**
 * This class creates a Linked List of LinkedMegaBlock objects and contains various methods to add
 * and remove blocks from the list.
 * 
 * @author Yash Hindka
 *
 */

public class LinkedListMegaBlock {

  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list

  /**
   * Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {

    // initialize head and tail to null
    head = null;
    tail = null;

  }

  /**
   * Adds a blue MegaBlock to the end of the list
   * 
   * @param blueBlock - blue MegaBlock to be added to list
   */
  public void addBlue(MegaBlock blueBlock) {

    // checks if blueBlock is null or color is not blue and throws exception accordingly
    if (blueBlock == null || blueBlock.getColor() != Color.BLUE) {
      throw new IllegalArgumentException("Error: Block is null or Color is not blue.");
    }

    // creates new LinkedMegaBlock from blueBlock
    LinkedMegaBlock blue = new LinkedMegaBlock(blueBlock);
    // temporarily stores tail
    LinkedMegaBlock temp = this.tail;
    // if list is empty, sets tail and head, otherwise just sets tail
    if (isEmpty()) {
      this.tail = blue;
      this.head = blue;
    } else {
      this.tail.setNext(blue);
      this.tail = blue;
    }
    // increment list size and blueCount
    size++;
    blueCount++;
  }

  /**
   * Adds a red MegaBlock to the front of the list
   * 
   * @param redBlock - red MegaBlock to be added to list
   */
  public void addRed(MegaBlock redBlock) {

    // checks if redBlock is null or color is not red and throws exception accordingly
    if (redBlock == null || redBlock.getColor() != Color.RED) {
      throw new IllegalArgumentException("Error: Block is null or Color is not red.");
    }

    // creates new LinkedMegaBlock from redBlock
    LinkedMegaBlock red = new LinkedMegaBlock(redBlock);
    // temporarily stores head
    LinkedMegaBlock temp = this.head;
    // if list is empty, sets tail and head, otherwise just sets head
    if (isEmpty()) {
      this.head = red;
      this.tail = red;
    } else {
      red.setNext(this.head);
      this.head = red;
    }
    // increment list size and redCount
    size++;
    redCount++;
  }

  /**
   * Adds a yellow MegaBlock in the middle of the list
   * 
   * @param index       - location to add YellowBlock
   * @param yellowBlock - yellow MegaBlock to be added to list
   */
  public void addYellow(int index, MegaBlock yellowBlock) {

    // checks if yellowBlock is null or color is not yellow and throws exception accordingly
    if (yellowBlock == null || yellowBlock.getColor() != Color.YELLOW) {
      throw new IllegalArgumentException("Error: Block is null or Color is not yellow.");
    }

    // checks if index is within range for yellow blocks and throws exception accordingly
    if (index < redCount || index > size - blueCount) {
      throw new IndexOutOfBoundsException("Error: Index is out of range for yellow blocks.");
    }

    // creates new LinkedMegaBlock from yellowBlock
    LinkedMegaBlock yellow = new LinkedMegaBlock(yellowBlock);
    // temporarily stores head
    LinkedMegaBlock current = this.head;
    // if list is empty, sets head and tail
    if (isEmpty()) {
      this.head = yellow;
      this.tail = yellow;
    } else {

      // otherwise if index is between 1 and size, adds yellow block in middle of list
      if (index >= 1 && index < size) {
        for (int i = 0; i < size; i++) {
          if (i == index - 1) {
            yellow.setNext(current.getNext());
            current.setNext(yellow);
            break;
          }
          current = current.getNext();
        }
      }

      // otherwise if index is equal to size, adds yellow block to end of list
      else if (index == size) {
        this.tail.setNext(yellow);
        this.tail = yellow;
      }

      // otherwise if index is 0, adds yellow block to front of list
      else if (index == 0) {
        this.head = yellow;
        this.head.setNext(current);
        this.head.getNext().setNext(current.getNext());
      }

    }
    // increment list size and yellowCount
    size++;
    yellowCount++;

  }

  /**
   * Gets size of linked list
   * 
   * @return list size
   */
  public int size() {

    return size;
  }

  /**
   * Clears/empties list of all contents
   */
  public void clear() {

    // set head and tail to null
    head = null;
    tail = null;
    // reset size and color counts
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }

  /**
   * Checks if list is empty
   * 
   * @return true if list has no elements, false otherwise
   */
  public boolean isEmpty() {

    return size == 0;
  }

  /**
   * This method gets the MegaBlock object stored at the specified index of the list
   * 
   * @param index of MegaBlock to retrieve
   * @return MegaBlock stored at index
   */
  public MegaBlock get(int index) {

    // checks if index is within bounds of list, throws exception accordingly
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Error: Index is out of bounds.");
    }

    // temporarily stores head
    LinkedMegaBlock current = this.head;
    // iterates through list and eventually sets current to MegaBlock at index
    for (int i = 0; i < index; i++) {

      // advance current
      current = current.getNext();
    }

    return current.getBlock();
  }

  /**
   * Sets specified index with specified MegaBlock object
   * 
   * @param index to set
   * @param block to place at index
   * @return MegaBlock that is replaced
   */
  public MegaBlock set(int index, MegaBlock block) {

    // checks if current block at index is not null and of the same color as the new block
    if (get(index) == null || get(index).getColor() != block.getColor()) {
      throw new IllegalArgumentException(
          "Error: Block is null or color is not equal to block at index " + index);
    }

    // checks if index is within bounds
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Error: Index is out of bounds.");
    }

    // create new LinkedMegaBlock object from parameter block
    LinkedMegaBlock newBlock = new LinkedMegaBlock(block);
    // runner
    LinkedMegaBlock current = this.head;
    // stores MegaBlock to be replaced
    MegaBlock replaced = get(index);

    // if index is 0, sets newBlock at front of list
    if (index == 0) {
      newBlock.setNext(head.getNext());
      this.head = newBlock;

    }

    // if index is last index, sets newBlock at end of list
    else if (index == size - 1) {

      for (int i = 0; i < size; i++) {
        if (i == size - 2) {
          newBlock.setNext(current.getNext());
          current.setNext(newBlock);
        }
        current = current.getNext();
      }
      this.tail = newBlock;
    }

    // if index is between 0 and size - 1, sets index in the middle of the list
    else {

      for (int i = 0; i < size; i++) {
        if (i == index - 1) {
          newBlock.setNext(current.getNext().getNext());
          current.setNext(newBlock);
          break;
        }
        current = current.getNext();
      }
    }

    return replaced;
  }

  /**
   * Removes red block from front of list
   * 
   * @return removed red block
   */
  public MegaBlock removeRed() {

    // checks if there are no red blocks in the list and throws exception accordingly
    if (redCount == 0) {
      throw new NoSuchElementException("Error: There is no red block to remove.");
    }

    // stores block to be removed
    MegaBlock remove = get(0);
    // set list head as second block in list, effectively removing first block
    this.head = head.getNext();
    // decrement list size and redCount
    redCount--;
    size--;

    return remove;
  }

  /**
   * Removes blue block from end of list
   * 
   * @return removed blue block
   */
  public MegaBlock removeBlue() {

    // checks if there are no blue blocks in the list and throws exception accordingly
    if (blueCount == 0) {
      throw new NoSuchElementException("Error: There is no yellow block to remove.");
    }

    // stores block to be removed
    MegaBlock remove = get(size - 1);
    // runner
    LinkedMegaBlock current = this.head;
    // loops through list and sets tail as second last block in list, effectively removing last
    // block
    for (int i = 0; i < size; i++) {
      if (i == size - 2) {
        this.tail = current;
        current.setNext(null);
        break;
      }
      // advance runner
      current = current.getNext();
    }

    // decrement list size and blueCount
    blueCount--;
    size--;

    return remove;
  }

  /**
   * Removes yellow block at index from list
   * 
   * @param index - location of yellow block to be removed
   * @return removed yellow block
   */
  public MegaBlock removeYellow(int index) {

    // checks if index is within range for yellow blocks and throws exception accordingly
    if (index < redCount || index >= size - blueCount) {
      throw new IndexOutOfBoundsException("Error: Index is out of range for yellow blocks.");
    }

    // stores block to be removed
    MegaBlock remove = get(index);
    // runner
    LinkedMegaBlock current = this.head;

    // if index is 0 and yellow is the only element in the list, sets head and tail to null
    if (index == 0 && size == 1) {

      head.setNext(null);
      this.head = null;
      this.tail = null;
    }

    // otherwise if index is 0 but there are other elements in the list, sets head as second block
    // in list, effectively removing head yellow block
    else if (index == 0) {

      head.setNext(null);
      this.head = current.getNext();
    }

    // otherwise if index is last element, sets tail as second last element in list, effectively
    // removing tail yellow block
    else if (index == size - 1) {

      // loops through list until reaches second last element
      for (int i = 0; i < size; i++) {
        if (i == size - 2) {
          this.tail = current;
          current.setNext(null);
          break;
        }
        // advance runner
        current = current.getNext();
      }
    }

    // otherwise index is in middle of list, and yellow block is removed by changing the next field
    // of the block before the yellow block
    else {
      // loops through list until reaches index - 1
      for (int i = 0; i < size; i++) {

        if (i == index - 1) {
          current.setNext(current.getNext().getNext());
          break;
        }
        // advance runner
        current = current.getNext();
      }
    }

    // decrement list size and yellowCount
    yellowCount--;
    size--;

    return remove;


  }


  /**
   * Retrieves number of red blocks in list
   * 
   * @return number of red blocks in list
   */
  public int getRedCount() {

    return redCount;
  }

  /**
   * Retrieves number of blue blocks in list
   * 
   * @return number of blue blocks in list
   */
  public int getBlueCount() {

    return blueCount;
  }

  /**
   * Retrieves number of yellow blocks in list
   * 
   * @return number of yellow blocks in list
   */
  public int getYellowCount() {

    return yellowCount;
  }

  /**
   * This method delivers a string representation of the LinkedMegaBlock objects in this
   * LinkedListMegaBlock. Each LinkedMegaBlock has a MegaBlock string representation that includes
   * the block color in all caps and the block label. The final block is followed by "END" to show
   * that the end of the list has been reached.
   * 
   * @return string representation of all LinkedMegaBlocks in list
   */
  @Override
  public java.lang.String toString() {

    // create empty string
    String s = "";

    // checks if list is empty and returns empty string accordingly
    if (isEmpty()) {
      return s;
    }

    // runner
    LinkedMegaBlock current = this.head;
    // loops through list and concatenates string representation of each block to String s
    for (int i = 0; i < size; i++) {

      // concatenate string
      s += current.toString();
      // advance runner
      current = current.getNext();
    }

    return s;


  }


}
