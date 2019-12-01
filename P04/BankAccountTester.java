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

import java.util.zip.DataFormatException;

/**
 * This class tests the methods of the BankAccount class for correctness using methods that return
 * booleans.
 * 
 * @author Yash Hindka
 *
 */

public class BankAccountTester {

  /**
   * BankAccountTester constructor, empty
   */
  public BankAccountTester() {


  }

  /**
   * Calls different test methods
   * 
   * @param args - input arguments
   */
  public static void main(String[] args) {

    // call different methods in BankAccount class
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println(testBankAccountEquals());
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
    System.out.println(testBankAccountWithdrawValidAmount());
    System.out.println(testBankAccountDepositNegativeAmount());

  }

  /**
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException when
   * it is passed a balance smaller than 10.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountConstructorNotValidInitialBalance() {

    // tries to add account with invalid initial balance
    try {
      BankAccount ba = new BankAccount("1234", 9);
      // return false if the account is added
      return false;
    }

    // catch exception and print error message
    catch (IllegalArgumentException i) {
      System.out.println(i.getMessage());
      return true;
    }

  }

  /**
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (greater of equal to 10). Checks whether the new account is created
   * with the provided account id and balance. It checks also that the list of transactions of the
   * created account contains only one transaction /"1 " + the initial balance/
   * 
   * @return true when test verifies correct functionality, false otherwise
   */
  public static boolean testBankAccountConstructorValidInitialBalance() {

    BankAccount ba = new BankAccount("1234", 10);
    // checks if account was created properly
    if (!(ba.getID().equals("1234")))
      return false;
    if (ba.getBalance() != 10)
      return false;
    if (!(ba.getMostRecentTransactions()[0].equals("1 10")))
      return false;
    return true;

  }

  /**
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is
   * passed a negative number. The balance of the bank account should not change after the method
   * call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountDepositNegativeAmount() {

    BankAccount ba = new BankAccount("1234", 10);
    // tries to deposit negative amount, returns false if deposit successful
    try {
      ba.deposit(-5);
      return false;
    }

    // catch exception and print error message
    catch (IllegalArgumentException i) {

      System.out.println(i.getMessage());
      // checks if balance changed or left alone
      if (ba.getBalance() != 10) {
        return false;
      } else {
        return true;
      }
    }



  }

  /**
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having the same account identifier (case sensitive comparison); and it returns
   * false otherwise.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountEquals() {

    // create 3 new accounts
    BankAccount ba = new BankAccount("1234", 10);
    BankAccount ba2 = new BankAccount("1234", 20);
    BankAccount ba3 = new BankAccount("1235", 30);
    // checks if bank account equals method performs correctly
    if (!(ba.equals(ba2)))
      return false;
    if (ba.equals(ba3))
      return false;
    return true;

  }

  /**
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a
   * negative number or a number not multiple of 10. The account balance should not change after the
   * withdraw() method returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawInvalidAmount() {

    BankAccount ba = new BankAccount("1234", 10);
    // tries to withdraw negative amount, returns false if withdrawal successful
    try {
      ba.withdraw(-2);
      return false;

    }

    // catch error and print exception
    catch (DataFormatException d) {
      System.out.println(d.getMessage());
      // checks if account balance changed or left alone
      if (ba.getBalance() != 10) {
        return false;
      } else {
        return true;
      }
    }



  }

  /**
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed
   * a number larger than the account's balance. The account balance should not change after that
   * withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {

    BankAccount ba = new BankAccount("1234", 10);
    // tries to withdraw amount larger than account balance, returns false if withdrawal successful
    try {
      ba.withdraw(20);
    }

    // catch error and print exception
    catch (IllegalStateException i) {
      System.out.println(i.getMessage());
      return true;
    }

    // catch error and print exception
    catch (DataFormatException d) {
      System.out.println(d.getMessage());
    }
    return false;

  }

  /**
   * Checks whether BankAccount.withdraw() method returns without any exception when it is passed a
   * positive number smaller than the account's balance. The withdrawal amount should be subtracted
   * from the balance after the withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testBankAccountWithdrawValidAmount() {

    BankAccount ba = new BankAccount("1234", 20);
    // tries to withdraw valid amount, return false if balance not changed
    try {
      ba.withdraw(10);
      if (ba.getBalance() != 10)
        return false;
    }

    // catch error and print exception
    catch (IllegalStateException i) {
      System.out.println(i.getMessage());
      return false;
    }

    // catch error and print exception
    catch (DataFormatException d) {
      System.out.println(d.getMessage());
      return false;
    }

    return true;


  }

}
