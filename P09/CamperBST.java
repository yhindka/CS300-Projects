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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class defines a binary search tree that stores nodes of type CampTreeNode. Standard BST
 * operations are included, such as insert, delete, size, and isEmpty.
 * 
 * @author Yash Hindka
 *
 */

public class CamperBST {

  public CampTreeNode root; // root node of BST
  private int size; // number of nodes in BST
  // LinkedList to maintain current traversal
  private LinkedList<Camper> traversedLList;

  /**
   * Constructor, initializes size to 0
   */
  public CamperBST() {

    // initialize fields
    size = 0;
  }

  /**
   * Gets current size of the CamperBST
   * 
   * @return size of BST
   */
  public int size() {

    return size;
  }

  /**
   * Uses size to see if BST is empty or not
   * 
   * @return true if empty, false otherwise
   */
  public boolean isEmpty() {

    return size == 0;
  }

  /**
   * starts tree insertion by calling insertHelp() on the root and assigning root to be the subtree
   * returned by that method
   * 
   * @param newCamper - Camper object to be inserted
   */
  public void insert(Camper newCamper) {
    // begin tree insertion
    root = insertHelp(root, newCamper);
    // increment size
    size++;
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current,   The "root" of the subtree we are inserting into, ie the node we are currently
   *                   at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {

    // base case: checks if current is empty and places new node into that slot
    if (current == null) {

      // create new CampTreeNode
      CampTreeNode newNode = new CampTreeNode();
      // set new node's data to newCamper
      newNode.setData(newCamper);
      // return as root of subtree
      return newNode;
    }
    // if current is not empty, checks if newCamper is less than current's camper
    else if (newCamper.compareTo(current.getData()) < 0) {

      // recursive call with node to the left of current
      current.setLeftNode(insertHelp(current.getLeftNode(), newCamper));
    }

    // if current is not empty, checks if newCamper is greater than current's camper
    else if (newCamper.compareTo(current.getData()) > 0) {

      // recursive call with node to the right of current
      current.setRightNode(insertHelp(current.getRightNode(), newCamper));
    }

    return current;

  }

  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key, the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {

    // begin tree deletion
    root = deleteHelp(root, key);
    // decrement size
    size--;
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current, The "root" of the subtree we are deleting from, ie the node we are currently
   *                 at.
   * @param key,     the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree or if key is null
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {

    // checks if key is null, throws exception accordingly
    if (key == null) {
      throw new NoSuchElementException("That camper is not enrolled.");
    }

    // checks if key is less than current node's camper
    if (key.compareTo(current.getData()) < 0) {
      // if there is no left node, throws exception
      if (current.getLeftNode() == null) {
        throw new NoSuchElementException("That camper is not enrolled.");
      }
      // otherwise recursive call with node to the left of current
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));
    }

    // checks if key is greater than current node's camper
    else if (key.compareTo(current.getData()) > 0) {

      // if there is no right node, throws exception
      if (current.getRightNode() == null) {
        throw new NoSuchElementException("That camper is not enrolled.");
      }
      // otherwise recursive call with node to the right of current
      current.setRightNode(deleteHelp(current.getRightNode(), key));
    }

    // checks if key is equal to current node's camper
    else if (key.compareTo(current.getData()) == 0) {

      // sets current to right node if left is empty, thereby deleting current
      if (current.getLeftNode() == null) {

        current = current.getRightNode();
      }

      // otherwise, sets current to left node if right is empty, thereby deleting current
      else if (current.getRightNode() == null) {

        current = current.getLeftNode();
      }

      // otherwise, uses while loop to find lowest element in right subtree
      else {

        current = current.getRightNode();
        while (current.getLeftNode() != null) {

          current = current.getLeftNode();
        }
        // deletes node that replaced the node to be deleted
        current.setRightNode(deleteHelp(current, current.getData()));
      }
    }

    return current;
  }

  /**
   * Returns an iterator of camper in the correct order as designated
   * 
   * @param order - specifies iterator as INORDER, POSTORDER, OR PREORDER
   * @return iterator of traversedLList
   */
  public Iterator<Camper> traverse(String order) {
    // first time traversing need to initialize LinkedList
    if (traversedLList == null) {
      traversedLList = new LinkedList<Camper>();
    } else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }
    // begin tree traversal
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }


  /**
   * Traverses CamperBST and adds nodes to traversedLList according to specified order
   * 
   * @param current - current node in traversal
   * @param order   - specifies iterator type as INORDER, POSTORDER, OR PREORDER
   */
  private void traverseHelp(CampTreeNode current, String order) {

    // checks if INORDER traversal is specified
    if (order.equals("INORDER")) {
      // base case: end of BST reached, end recursion and return
      if (current == null) {
        return;
      }
      // visit every node on left
      traverseHelp(current.getLeftNode(), order);
      // add left nodes before parent and right child
      traversedLList.add(current.getData());
      // visit every node on right
      traverseHelp(current.getRightNode(), order);
    }

    // checks if PREORDER traversal is specified
    else if (order.equals("PREORDER")) {
      // base case: end of BST reached, end recursion and return
      if (current == null) {
        return;
      }

      // add parents to list before children
      traversedLList.add(current.getData());
      // visit left nodes
      traverseHelp(current.getLeftNode(), order);
      // visit right nodes
      traverseHelp(current.getRightNode(), order);
    }

    // checks if POSTORDER traversal is specified
    else if (order.equals("POSTORDER")) {

      // base case: end of BST reached, end recursion and return
      if (current == null) {
        return;
      }

      // visit all left nodes
      traverseHelp(current.getLeftNode(), order);
      // visit all right nodes
      traverseHelp(current.getRightNode(), order);
      // add left and right children before parents
      traversedLList.add(current.getData());
    }
  }


  /**
   * Prints the contents of this tree in alphabetical order based on the string "lastName,
   * firstName"
   */
  public void print() {
    // begin inorder traversal
    printHelp(root);
  }

  /**
   * Traverses CamperBST and prints with inorder traversal
   * 
   * @param current - current node to traverse
   */
  private void printHelp(CampTreeNode current) {
    // base case: end of BST reached, end recursion and return
    if (current == null) {
      return;
    }
    // visit left nodes
    printHelp(current.getLeftNode());
    // print left nodes before parent and right child
    System.out.println(current.getData());
    // visit right nodes
    printHelp(current.getRightNode());
  }


}
