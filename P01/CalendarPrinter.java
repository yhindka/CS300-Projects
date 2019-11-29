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

import java.util.Scanner;


/**
 * The CalendarPrinter class is designed to take in a month and year from the user as an input and
 * output a calendar of the month from the specified year.
 * 
 * @author Yash Hindka
 *
 */
public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

  private static String year = "";
  private static String month = "";

  private static String[][] Calendar = new String[7][7];


  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);
    // set up user interface
    setInterface(1);

    // scanner sets String Month as user input
    month = getInput(scnr);

    // advances user interface
    setInterface(2);

    // scanner sets String year as user input
    year = getInput(scnr);

    // use generateCalendar() method to generate a calendar
    Calendar = generateCalendar(month, year);

    // prints each column of each row
    printCalendar();
    
    // Thanks user
    setInterface(3);


  }


  /**
   * Produces text that tells user what to input.
   * 
   * @param none
   * @return void
   */
  public static void setInterface(int set) {

    // sets interface and tells user to enter month
    if (set == 1) {
      System.out.println("Welcome to the Calendar Printer.");
      System.out.println("================================");
      System.out.println("Enter the month to print: ");
    }

    // advances interface and tells user to enter year
    else if (set == 2) {
      System.out.print("Enter the year to print: ");
    }
    
    //advances interface and thanks user
    else if (set == 3) {
      System.out.println();
      System.out.println("================================");
      System.out.println("Thanks, and have a nice day.");
    }

  }

  /**
   * Uses Scanner scnr to get user input.
   * 
   * @param Scanner
   * @return String of user input
   */
  public static String getInput(Scanner s) {
    return s.next();
  }

  /**
   * Prints Calendar using for loops.
   * 
   * @param none
   * @return void
   */
  public static void printCalendar() {

    // first for loop cycles through each row and moves to new line after end of each row
    for (int r = 0; r < Calendar.length; r++) {
      System.out.println();
      // second for loop cycles through each column and prints each element at Calendar[r][c]
      for (int c = 0; c < Calendar[0].length; c++) {
        System.out.print(Calendar[r][c] + " ");
      }
    }
  }

  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {

    // convert String year into an int
    int yearInt = Integer.parseInt(year);

    // calculation for getting zero-based century
    return yearInt / 100;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99.
   * 
   * @param year to compute the year within century of (Gregorian Calendar AD) String must contain
   *             the digits of a single non-negative int for year.
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {

    // convert String year into an int
    int yearInt = Integer.parseInt(year);

    // mod calculation returns last two digits of yearInt
    return yearInt % 100;

  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param yearString is the year that is being checked for leap-year-ness String must contain the
   *                   digits of a single non-negative int for year.
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean getIsLeapYear(String yearString) {

    //convert String year into an int
    int yearInt = Integer.parseInt(yearString);
    //if year is not divisible by 4, not leap year
    if (yearInt % 4 != 0)
      return false;
    //else if year is not divisible by 100, is leap year
    else if (yearInt % 100 != 0)
      return true;
    //else if year is not divisible by 400, is not leap year
    else if (yearInt % 400 != 0)
      return false;
    //if all above conditions fail, then is leap year
    else
      return true;
  }

  /**
   * Converts the name or abbreviation for any month into the index of that month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @return the index within MONTHS_OF_YEAR that a match is found at and returns -1, when no match
   *         is found
   */
  public static int getMonthIndex(String month) {

    //takes only first 3 letters of month string into consideration
    month = month.substring(0, 3);
    //converts all characters in month string to upper case in order to match MONTHS_OF_YEAR
    month = month.toUpperCase();
    //loops through MONTHS_OF_YEAR to find index of month
    for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {

      if (MONTHS_OF_YEAR[i].equals(month))
        return i;
    }
    
    //if month string is not present in MONTHS_OF_YEAR, return -1
    return -1;
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {

    //uses getMonthIndex() to see if month is February
    if (getMonthIndex(month) == 1) {
      //uses getIsLeapYear() to check if year is leap year
      if (getIsLeapYear(year))
        return 29;
      else
        return 28;
    }

    //if month is not February, checks if month has 31 or 30 days
    else if (getMonthIndex(month) % 2 == 0 && getMonthIndex(month) >= 0
        && getMonthIndex(month) <= 6) {
      return 31;
    } else if (getMonthIndex(month) % 2 != 0 && getMonthIndex(month) >= 0)
      return 31;
    else
      return 30;
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) {

    //convert String year into int
    int yearInt = Integer.parseInt(year);
    //calculates index of month using getMonthIndex()
    int monthIndex = getMonthIndex(month);
    //if month is January, sets index to 12 and year to the previous year
    if (monthIndex == 0) {
      monthIndex = 12;
      yearInt--;
    } 
    //if month is February, sets index to 13 and year to the previous year
    else if (monthIndex == 1) {
      monthIndex = 13;
      yearInt--;
    }
    year = Integer.toString(yearInt);
    //use formula to calculate index of first day of week in month
    int dayIndex = (int) ((1 + Math.floor(((13.0 * (monthIndex + 2.0)) / 5.0))
        + getYearWithinCentury(year) + Math.floor((getYearWithinCentury(year) / 4.0))
        + Math.floor((getCentury(year) / 4.0)) + (5.0 * getCentury(year))) % 7);
    //convert calculated index so that it matches index in DAYS_OF_WEEK
    if (dayIndex <= 1)
      return dayIndex + 5;
    else
      return dayIndex - 2;
  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result:
   *
   * MON TUE WED THU FRI SAT SUN . . . . . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
   * 22 23 24 25 26 27 28 29 30 . . . . . .
   *
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   * @return 2d array of strings depicting the contents of a calendar
   */
  public static String[][] generateCalendar(String month, String year) {

    int date = 1;
    int indexOfFirstDay = getFirstDayOfWeekInMonth(month, year);
    int numDaysInMonth = getNumberOfDaysInMonth(month, year);
    //calculates number of rows needed in matrix
    int rows = (int) (Math.ceil((numDaysInMonth + indexOfFirstDay)/7.0) + 1);
    //initializes matrix
    String[][] Calendar = new String[rows][7];

    //sets first row of matrix as days of week
    for (int c = 0; c < Calendar[0].length; c++) {
      Calendar[0][c] = DAYS_OF_WEEK[c];
    }

    //fills first row of matrix with first few dates of the month
    for (int c = indexOfFirstDay; c < Calendar[0].length; c++) {
      Calendar[1][c] = Integer.toString(date) + "  ";
      date++;
    }

    //fills rest of matrix with rest of days in month
    for (int r = 2; r < Calendar.length; r++) {
      for (int c = 0; c < Calendar[r].length; c++) {
        if (date >= 10 && (date <= getNumberOfDaysInMonth(month, year))) {
          Calendar[r][c] = Integer.toString(date) + " ";
          date++;
        } else if (date <= numDaysInMonth) {
          Calendar[r][c] = Integer.toString(date) + "  ";
          date++;
        }
      }
    }

    //replaces null locations in matrix with "."
    for (int r = 0; r < Calendar.length; r++) {
      for (int c = 0; c < Calendar[r].length; c++) {
        if (Calendar[r][c] == null) {
          Calendar[r][c] = ".  ";
        }
      }
    }



    return Calendar;

  }



}
