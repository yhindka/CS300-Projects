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
import java.util.List;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CampEnrollmentApp {

  /**
   * 
   * @param args - input arguments
   * @throws IOException if file is nonexistent
   */
  public static void main(String[] args) {

    // create new CampManager object
    CampManager cm = new CampManager();
    // enclose error-prone code in try block
    try {
      List<String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
      // iterate through all lines in file
      for (String s : fileLines) {
        // substring of first letter in line
        String sub = s.substring(0, 1);
        // checks if printStatistics operation is specified
        if (sub.equals("S")) {
          // print statistics
          cm.printStatistics();
        }
        // otherwise checks if enroll operation is specified
        else if (sub.equals("E")) {
          // stores parts of line in array
          String[] enrollParts = s.split(" ");
          // enroll camper
          cm.enrollCamper(
              new Camper(enrollParts[2], enrollParts[1], Integer.parseInt(enrollParts[3])));
          System.out
              .println("Enrollment of " + enrollParts[2] + " " + enrollParts[1] + " Successful!");
        }
        // otherwise checks if unenroll operation is specified
        else if (sub.equals("R")) {
          // stores parts of line in array
          String[] unenrollParts = s.split(" ");
          try {
            // unenroll camper
            cm.unenrollCamper(cm.findCamper(unenrollParts[2], unenrollParts[1]));
            System.out.println(
                "Unenrollment of " + unenrollParts[2] + " " + unenrollParts[1] + " Successful!");
          }
          // catch block for NoSuchElementException
          catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
          }
        }
        // otherwise checks if traverse operation is specified
        else if (sub.equals("T")) {
          // store parts of line in array
          String[] traverseParts = s.split(" ");
          // create iterator
          Iterator<Camper> itr = cm.traverse(traverseParts[1]);
          // traverse list
          while (itr.hasNext()) {
            System.out.println(itr.next());
          }
        }
      }
    }
    // catch blocks for exceptions
    catch (IOException e) {
      e.getMessage();
    }

    catch (IllegalArgumentException e2) {
      System.out.println(e2.getMessage());
    }

  }

}
