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

/**
 * This class is designed to test the various methods of MegaBlock and LinkedMegaBlock to see if
 * they properly create a LinkedList of MegaBlocks.
 * 
 * @author Yash Hindka
 *
 */

public class MegaBlockBuilderTester {

  /**
   * Main method that calls various tester methods.
   * 
   * @param args - input arguments
   */
  public static void main(String[] args) {

    // calling various tester methods
    System.out.println(MegaBlockBuilderTester.testMegaBlockEquals());
    System.out.println(MegaBlockBuilderTester.testMegaBlockToString());
    System.out.println(MegaBlockBuilderTester.testLinkedMegaBlock());
    System.out.println(MegaBlockBuilderTester.testLinkedMegaBlockListAddRed());
    System.out.println(MegaBlockBuilderTester.testLinkedListMegaBlockRemoveBlue());

  }

  /**
   * Checks if MegaBlock#equals() correctly identifies if two MegaBlock objects have the same color
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testMegaBlockEquals() {

    // create new MegaBlock objects to compare
    MegaBlock m = new MegaBlock(Color.RED, 'a');
    MegaBlock m2 = new MegaBlock(Color.RED, 'b');
    MegaBlock m3 = new MegaBlock(Color.YELLOW, 'a');
    LinkedMegaBlock m4 = new LinkedMegaBlock(m2);
    // tests method with two MegaBlock objects of the same Color
    if (!(m.equals(m2)))
      return false;
    // tests method with two MegaBlock objects of different Colors
    if (m.equals(m3))
      return false;
    // compares MegaBlock object with LinkedMegaBlock
    if ((m.equals(m4)))
      return false;
    // compares MegaBlock object with Color
    if (m.equals(Color.RED))
      return false;
    return true;
  }

  /**
   * Checks if MegaBlock#toString() correctly returns string representation of MegaBlock
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testMegaBlockToString() {

    // creates new MegaBlock object
    MegaBlock m = new MegaBlock(Color.RED, 'a');
    // checks if toString() method properly returns MegaBlock color and label
    if (!(m.toString().equals("RED a")))
      return false;
    return true;
  }

  /**
   * Tests LinkedMegaBlock class constructor, getter, and setter methods
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLinkedMegaBlock() {

    // create new LinkedMegaBlock object
    LinkedMegaBlock l = new LinkedMegaBlock(new MegaBlock(Color.RED, 'a'));
    // checks if constructor properly initialized LinkedMegaBlock
    if (l.getNext() != null)
      return false;
    // creates another LinkedMegaBlock object
    LinkedMegaBlock l2 = new LinkedMegaBlock(new MegaBlock(Color.BLUE, 'a'));
    // links l and l2
    l.setNext(l2);
    // checks if setNext() method properly linked l and l2
    if (l.getNext() != l2)
      return false;
    return true;
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.addRed() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLinkedMegaBlockListAddRed() {

    // create new LinkedMegaBlock object
    LinkedListMegaBlock l = new LinkedListMegaBlock();
    // add red MegaBlock to list
    l.addRed(new MegaBlock(Color.RED, 'a'));
    // checks if red MegaBlock was properly added
    if (l.get(0).getColor() != Color.RED)
      return false;
    // adds another red MegaBlock to list
    l.addRed(new MegaBlock(Color.RED, 'b'));
    // checks if new red MegaBlock was added to front of list
    if (l.get(0).getLabel() != 'b')
      return false;
    return true;
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.removeBlue() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {

    // create new LinkedListMegaBlock object
    LinkedListMegaBlock l = new LinkedListMegaBlock();
    // adds several blocks to list
    l.addRed(new MegaBlock(Color.RED, 'a'));
    l.addRed(new MegaBlock(Color.RED, 'b'));
    l.addBlue(new MegaBlock(Color.BLUE, 'a'));
    l.addBlue(new MegaBlock(Color.BLUE, 'b'));
    // removes blue block from end of list
    l.removeBlue();
    // checks if blue block was properly removed
    if (l.get(2).getLabel() != 'a')
      return false;
    return true;
  }



}
