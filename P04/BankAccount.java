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

import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * This class defines a Bank Account. A user can create a Bank Account object and perform several
 * functions, including withdrawal, deposit, checking the balance, getting the account ID, getting
 * the most recent transactions, and more.
 * 
 * 
 * @author Yash Hindka
 *
 */

public class BankAccount {

  private String accountID;
  private int balance;
  private ArrayList<String> transactions; // stores all transactions performed on account

  /**
   * Creates new bank account with certain identifier and initial balance
   * 
   * @param accountID      - account's unique identifier
   * @param initialBalance - account's initial balance
   * @throws IllegalArgumentException if initialBalance less than 10
   */
  public BankAccount(String accountID, int initialBalance) throws IllegalArgumentException {

    // throws error if initial balance is less than 10
    if (initialBalance < 10) {
      throw new IllegalArgumentException(
          "Error: Cannot create Bank Account with an initial balance of less than 10.");
    }
    // initialize fields
    this.accountID = accountID;
    balance = initialBalance;
    transactions = new ArrayList<String>();
    transactions.add("1 " + initialBalance);
  }

  /**
   * Deposits amount to account and adds deposit to list of transactions.
   * 
   * @param depositAmount - amount to be added/deposited to account
   * @throws IllegalArgumentException if depositAmount is negative
   */
  public void deposit(int depositAmount) throws IllegalArgumentException {


    // throws error if user tries to deposit a negative amount
    if (depositAmount < 0) {
      throw new IllegalArgumentException("Error: Cannot deposit a negative amount.");
    }
    // otherwise increases account balance by amount deposited
    balance += depositAmount;
    // adds deposit to list of transactions
    transactions.add("1 " + depositAmount);
  }

  /**
   * Checks if another bank account is equal to this one
   * 
   * @param other - another BankAccount object
   * @return true if this account's identifier matches another (case sensitive), false otherwise
   */
  public boolean equals(BankAccount other) {

    return accountID.equals(other.accountID);
  }

  /**
   * Gets account's current balance
   * 
   * @return current account balance
   */
  public int getBalance() {

    return balance;
  }

  /**
   * Gets unique account identifier
   * 
   * @return unique account id
   */
  public String getID() {

    return accountID;
  }

  /**
   * Gets most recent 5 transactions of bank account. If there have been less than 5 transactions,
   * the unused slots of the array will be null.
   * 
   * @return String array of recent transactions
   */
  public String[] getMostRecentTransactions() {

    // creates oversize array to be returned
    String[] recentTransactions = new String[5];
    // number of significant elements in recentTransactions array
    int transactionsCount = 0;
    // the following if/else block simply sets transactionsCount to a maximum of 5 if there have
    // been more than 5 transactions
    if (getTransactionsCount() <= 5) {
      transactionsCount = getTransactionsCount();
    } else {
      transactionsCount = 5;
    }
    // fills recentTransactions with last 5 elements of transactions ArrayList
    for (int i = transactionsCount - 1; i >= 0; i--) {

      recentTransactions[i] = transactions.get(transactions.size() - 1 - i);
    }

    return recentTransactions;
  }

  /**
   * Gets total number of transactions performed on this bank account
   * 
   * @return size of transactions ArrayList
   */
  public int getTransactionsCount() {

    return transactions.size();
  }

  /**
   * Withdraws amount from account and adds withdrawal to list of transactions.
   * 
   * @param withdrawAmount - amount to be withdrawn
   * @throws DataFormatException   if withdrawAmount is negative or not a multiple of 10
   * @throws IllegalStateException if withdrawAmount is larger than bank account's balance
   */
  public void withdraw(int withdrawAmount) throws DataFormatException, IllegalStateException {

    // throws error if user tries to withdraw negative amount, withdraw an amount that is not a
    // multiple of 10, or withdraw an amount that is larger than the account's current balance
    if (withdrawAmount < 0) {
      throw new DataFormatException("Error: Cannot withdraw a negative amount.");
    } else if (withdrawAmount % 10 != 0) {
      throw new DataFormatException("Error: Cannot withdraw an amount that is not a multiple 10");
    } else if (withdrawAmount > balance) {
      throw new IllegalStateException("Error: Withdrawal amount exceeds total account balance");
    }
    // otherwise decreases account balance by amount withdrawn
    balance -= withdrawAmount;
    // adds withdrawal to transactions
    transactions.add("0 " + withdrawAmount);
  }

}
