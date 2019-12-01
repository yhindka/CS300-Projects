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
 * This class contains methods that call various functions in the CamperBST class.
 * 
 * @author Yash Hindka
 *
 */
public class CampManager {

  private CamperBST campers; // instance of BST
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"}; // cabin names

  /**
   * Constructor, initializes campers field
   */
  public CampManager() {

    // initialize fields
    campers = new CamperBST();
  }

  /**
   * Prints statistics based on the current "state" of the camp. The statistics to be printed is the
   * total number of campers.
   */
  public void printStatistics() {

    System.out.println("--- Camp Statistics ---\nNumber of Campers: " + campers.size());
  }

  /**
   * "Enrolls" a camper by determining their cabin and adding them to the tree.
   * 
   * @param newCamper - camper to be enrolled into camp
   */
  public void enrollCamper(Camper newCamper) {

    // calls insert method on BST
    campers.insert(newCamper);
    // assigns appropriate cabin according to age
    if (newCamper.getAge() == 8 || newCamper.getAge() == 9) {
      newCamper.assignCabin(CABIN_NAMES[0]);
    } else if (newCamper.getAge() == 10 || newCamper.getAge() == 11) {
      newCamper.assignCabin(CABIN_NAMES[1]);
    } else if (newCamper.getAge() == 12 || newCamper.getAge() == 13) {
      newCamper.assignCabin(CABIN_NAMES[2]);
    }
  }


  /**
   * "Unenrolls" a camper by removing them from the BST
   * 
   * @param delCamper - camper to be removed from camp
   * @throws java.util.NoSuchElementException if CamperBST's delete() method throws exception
   *                                          (thrown if camper is not enrolled in camp)
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {

    // calls delete method on BST
    campers.delete(delCamper);
  }

  /**
   * Finds camper given camper's first and last name. Can assist in deleting camper from BST.
   * 
   * @param first - camper's first name
   * @param last  - camper's last name
   * @return Camper object with specified first and last name, null if no such camper exists
   */
  public Camper findCamper(String first, String last) {

    String camperName = last + first;
    CampTreeNode current = campers.root;
    String compareString = current.getData().getLastName() + current.getData().getFirstName();
    while (compareString.compareTo(camperName) != 0) {
      int compare = camperName.compareTo(compareString);
      if (compare < 0 && compare >= -26 && current.getLeftNode() != null) {
        current = current.getLeftNode();
        compareString = current.getData().getLastName() + current.getData().getFirstName();
      } else if (current.getRightNode() != null) {
        current = current.getRightNode();
        compareString = current.getData().getLastName() + current.getData().getFirstName();
      } else {
        return null;
      }
    }

    return current.getData();
  }

  /**
   * Traverses the tree in the designated order by calling it through the CamperBST class.
   * 
   * @param order - type of traversal to perform
   * @return the Iterator of Campers from CampBST.traverse()
   */
  public java.util.Iterator<Camper> traverse(java.lang.String order) {

    return campers.traverse(order);
  }

}
