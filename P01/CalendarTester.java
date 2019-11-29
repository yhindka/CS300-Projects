//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P01 Calendar Printer
// Files: CalendarPrinter.java, CalendarTester.java
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
 * The CalendarTester class contains various methods that verify the accuracy of their respective 
 * methods in the CalendarPrinter class. For example, testGetCentury() tests that
 * CalendarPrinter#getCentury() performs correctly.  
 * 
 * @author Yash Hindka
 *
 */

public class CalendarTester {


  public static void main(String[] args) {

    
  }


  /**
   * Tests CalendarPrinter#getCentury() to see if the method returns the correct century given a 
   * year
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter#getYearWithinCentury() to see if method returns the correct number of 
   * years that have passed since the start of the century
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("44444") != 44)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter#getIsLeapYear() to see if method correctly identifies if a given year is
   * a leap year
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGetIsLeapYear() {
    if ((CalendarPrinter.getIsLeapYear("2")))
      return false;
    if ((CalendarPrinter.getIsLeapYear("2019")))
      return false;
    if (!(CalendarPrinter.getIsLeapYear("44444")))
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter#getMonthIndex() to see if method correctly converts string of month to 
   * index of month
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("January") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex("April") != 3)
      return false;
    if (CalendarPrinter.getMonthIndex("September") != 8)
      return false;
    return true;
  }
  
  /**
   * Tests CalendarPrinter#getNumberofDaysInMonth() to see if method correctly returns the number
   * of days present in the specified month
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("February", "2019") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("February", "44444") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("March", "2") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("September", "2019") != 30)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter#getFirstDayOfWeekInMonth() to see if formula in method correctly
   * returns the index of the first day of the week in the month
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGetFirstDayOfWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("September", "2019") != 6)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("August", "1996") != 3)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("February", "2020") != 5)
      return false;
    return true;
  }

  /**
   * Tests CalendarPrinter#generateCalendar() to see if method correctly returns a matrix (calendar)
   * of the specified month and year
   * @param none
   * @return true when all tests are passed, and false otherwise
   */
  public static boolean testGenerateCalendar() {
    // create new array for testing
    String[][] testArray = new String[7][7];
    // set testArray equal to output of generateCalendar() for test 1
    testArray = CalendarPrinter.generateCalendar("September", "2019");
    if (!(testArray[1][6].equals("1  ")))
      return false;
    // test 2
    testArray = CalendarPrinter.generateCalendar("August", "1996");
    if (!(testArray[3][1].equals("13 ")))
      return false;
    // test 3
    testArray = CalendarPrinter.generateCalendar("February", "2030");
    if (!(testArray[5][2].equals("27 ")))
      return false;
    return true;
  }

}
