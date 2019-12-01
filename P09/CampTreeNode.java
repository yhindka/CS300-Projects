//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P09 Camp Badger
// Files: Camper.java, CampTreeNode.java, CamperBST.java, CampManager.java, CampEnrollmentApp.java
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
 * Class to represent the nodes of the binary search tree.
 * 
 * @author Michelle Jensen (mejensen5)
 */

public class CampTreeNode {

  private Camper data; // data field of node
  private CampTreeNode leftNode; // node to left of this node
  private CampTreeNode rightNode; // node to right of this node

  /**
   * Constructor, creates empty node by initializing fields to null
   */
  public CampTreeNode() {
    // initialize fields
    data = null;
    leftNode = null;
    rightNode = null;
  }

  /**
   * Getter for data field.
   * 
   * @return The data of this CampTreeNode
   */
  public Camper getData() {
    return data;
  }

  /**
   * Getter for leftNode field.
   * 
   * @return The leftNode of this CampTreeNode
   */
  public CampTreeNode getLeftNode() {
    return leftNode;
  }

  /**
   * Getter for rightNode field.
   * 
   * @return The rightNode of this CampTreeNode
   */
  public CampTreeNode getRightNode() {
    return rightNode;
  }

  /**
   * Setter for data field
   * 
   * @param camper, the Camper that the data field will be set to
   */
  public void setData(Camper camper) {
    data = camper;
  }

  /**
   * Setter for leftNode field
   * 
   * @param node, the CampTreeNode that the leftNode field will be set to
   */
  public void setLeftNode(CampTreeNode node) {
    leftNode = node;
  }

  /**
   * Setter for rightNode field
   * 
   * @param node, the CampTreeNode that the rightNode field will be set to
   */
  public void setRightNode(CampTreeNode node) {
    rightNode = node;
  }

}
