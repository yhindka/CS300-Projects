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
 * Class to represent a camper as an object. Implements the comparable interface to allow us to
 * compare them to each other.
 * 
 * @author Michelle Jensen
 */

public class Camper implements Comparable<Camper> {

  private String firstName; // first name of Camper
  private String lastName; // last name of Camper
  private int age; // age of Camper
  private String cabin; // cabin assigned to Camper

  /**
   * Constructor that sets the firstName, lastName, and age of an instance of the camper class.
   * 
   * @param firstName, the first name of the camper
   * @param lastName,  the last name of the camper
   * @param age,       the age of the camper
   * @throws IllegalArgumentException, if the age is outside of the range [8,14] (inclusive).
   */
  public Camper(String firstName, String lastName, int age) {
    if (age > 14 || age < 8)
      throw new IllegalArgumentException(
          "This person is either too old or too young to be in Camp Badger.");

    // initialize fields
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.cabin = "";
  }

  /**
   * Accessor that returns both the first and last name of a Camper in the correct format.
   * 
   * @return the string formated as "lastName, firstName". Ex. "Badger, Bucky"
   */
  public String getName() {
    return lastName + ", " + firstName;
  }

  /**
   * Getter for age field.
   * 
   * @return The age of this Camper.
   */
  public int getAge() {
    return age;
  };

  /**
   * Getter for firstName field. @ return The firstName of this Camper.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for lastName field.
   * 
   * @return The lastName of this Camper.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Getter for cabin field.
   * 
   * @return The cabin of this Camper.
   */
  public String getCabin() {
    return cabin;
  }

  /**
   * Mutator for cabin field.
   * 
   * @param The name of the cabin to be assigned to this Camper.
   */
  public void assignCabin(String cabin) {
    this.cabin = cabin;
  }

  /**
   * Returns a string representation of this Camper.
   * 
   * @return This instance of camper formatted as "<lastName>, <firstName> Age: <age> Cabin:
   *         <cabin>". Ex. "Bucky, Badger Age: 10 Cabin: Badger Bunkhouse"
   */
  public String toString() {
    return lastName + ", " + firstName + " Age: " + age + " Cabin: " + cabin;
  }

  /**
   * Method required to use the Comparable interface. Compares based on "lastName, firstName" string
   * lexigraphically.
   * 
   * @return 0 if they are the same, a negative int (<0) if this Camper is less than the argument, a
   *         positive int (>0) if this Camper is greater than the argument.
   * @author Yash Hindka/yhindka@wisc.edu
   */
  @Override
  public int compareTo(Camper camper) {
    // retrieve name of this camper
    String name1 = getName();
    // retrieve name of camper to compare this camper to
    String name2 = camper.getName();
    // check if name has dash in it, and return positive value accordingly, as the name with the
    // dash
    // should be placed after the other name alphabetically
    if (name1.compareTo(name2) < -26) {
      return 1;
    } else if (name1.compareTo(name2) > 26) {
      return -1;
    }
    return name1.compareTo(name2);
  }
}
