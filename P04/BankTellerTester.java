//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P04 Exceptional Bank Teller
// Files: BankAccount.java, BankAccountTester.java, BankTeller.java, BankTellerTester.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

/**
 * This class tests the methods of the BankTeller class for correctness using methods that return
 * booleans.
 * 
 * @author Yash Hindka
 *
 */

public class BankTellerTester {

  /**
   * BankTellerTester constructor, empty
   */
  public BankTellerTester() {


  }

  /**
   * Calls the test methods defined in this BankTellerTester class
   * 
   * @param args - input arguments
   */
  public static void main(String[] args) {

    // calls different methods in BankTeller class
    System.out.println(testBankTellerConstructor());
    System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    System.out.println(testBankTellerLoadTransactionsFileNotFound());
    testBankTellerLoadTransactions();

  }

  /**
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it
   * is passed a bank account with an identifier already used.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerAddBankAccountUsedIdentifier() {

    BankTeller bt = new BankTeller();
    BankAccount ba = new BankAccount("1234", 20);
    BankAccount ba2 = new BankAccount("1234", 30); // second account with same id
    bt.addBankAccount(ba);
    // trying to add second account with same id, return false if successful
    try {
      bt.addBankAccount(ba2);
      return false;
    }

    // catch error and print exception
    catch (IllegalStateException i) {
      System.out.println(i.getMessage());
      return true;
    }


  }

  /**
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an
   * empty ArrayList of bank accounts.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerConstructor() {

    BankTeller bt = new BankTeller();
    // checks if number of accounts in BankTeller object is initialized to 0
    if (bt.getAccountsCount() != 0)
      return false;
    return true;
  }

  /**
   * This method checks whether the BankTeller.loadTransactions() method that takes a File parameter
   * throws a FileNotFoundException, when it is passed a File object that does not correspond to an
   * actual file within the file system, and a non null reference of type BankAccount.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankTellerLoadTransactionsFileNotFound() {

    // creates instance of file that does not exist in computer
    File file = new File("Non-existent.txt");
    BankTeller bt = new BankTeller();
    BankAccount ba = new BankAccount("1234", 20);
    bt.addBankAccount(ba);
    // tries to load transactions from file to account, returns false if successful
    try {
      bt.loadTransactions(file, ba);
      return false;
    }

    // catch error and print exception
    catch (FileNotFoundException f) {
      System.out.println(f.getMessage());
      return true;
    }

  }
  
  public static void testBankTellerLoadTransactions() {
    
 // creates instance of file that does not exist in computer
    File file = new File("src/TestBankTeller.txt");
    BankTeller bt = new BankTeller();
    BankAccount ba = new BankAccount("1234", 1000);
    bt.addBankAccount(ba);
    // tries to load transactions from file to account, returns false if successful
    try {
      bt.loadTransactions(file, ba);
      System.out.println(ba.getBalance());
    }

    // catch error and print exception
    catch (FileNotFoundException f) {
      System.out.println(f.getMessage());
    }
  }

}
