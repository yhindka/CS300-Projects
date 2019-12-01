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
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/**
 * This class creates a Bank Teller object, which is designed to handle multiple Bank Account
 * objects. It can add Bank Accounts, add transactions to those bank accounts from a file, and more.
 * 
 * @author Yash Hindka
 *
 */

public class BankTeller {

  private ArrayList<BankAccount> accounts; // stores all accounts created in this Bank Teller object

  /**
   * BankTeller Constructor, initializes fields
   */
  public BankTeller() {

    // initialize fields
    accounts = new ArrayList<BankAccount>();
  }

  /**
   * Adds newAccount to the list of accounts of this BankTeller
   * 
   * @param newAccount - a new account to add
   * @throws IllegalStateException    if accountID is taken
   * @throws IllegalArgumentException if newAccount is null
   */
  public void addBankAccount(BankAccount newAccount)
      throws IllegalStateException, IllegalArgumentException {

    // loops through accounts ArrayList
    for (int i = 0; i < accounts.size(); i++) {

      // throws error if account to be added has same ID as existing account
      if (newAccount.getID().equals(accounts.get(i).getID())) {
        throw new IllegalStateException("Error: Account ID taken.");
      }
    }
    // throws error if account to be added is null
    if (newAccount.getID().equals(null)) {
      throw new IllegalArgumentException("Error: The account you are trying to add is null.");
    }

    // otherwise adds account to accounts ArrayList
    accounts.add(newAccount);
  }

  /**
   * Adds a new transaction to the account's list of transactions. When added, a withdrawal or
   * deposit transaction should change the account's balance
   * 
   * @param transaction - to add
   * @param account     - bank account
   * @throws DataFormatException  if format of transaction incorrect
   * @throws NullPointerException if account is null
   */
  public void addTransaction(String transaction, BankAccount account)
      throws DataFormatException, NullPointerException {

    // throws error if format of String transaction is incorrect
    if (!checkValidFormat(transaction)) {
      throw new DataFormatException("Error: format of transaction is not correct.");
    }

    // throws error if account is null
    else if (account == null) {
      throw new NullPointerException("Error: account is null.");
    }

    // eliminates white spaces from transaction String
    transaction = transaction.trim();
    // creates substring of first letter/number, which is a transaction code (0 or 1)
    String transactionCode = transaction.substring(0, 1);
    // creates substring of transaction amount
    String transactionAmount = transaction.substring(1);
    transactionAmount = transactionAmount.trim();
    // performs deposit or withdrawal action depending on transactionCode
    if (transactionCode.equals("1")) {
      account.deposit(Integer.valueOf(transactionAmount));
    } else if (transactionCode.equals("0")) {
      account.withdraw(Integer.valueOf(transactionAmount));
    }

  }

  /**
   * Returns the bank account that has exactly the provided identifier. Case sensitive comparison
   * must be considered.
   * 
   * @param id - string representing identifier of bank account
   * @throws NoSuchElementException if no account with the provided id is found
   * 
   * @return reference to matching bank account
   */
  public BankAccount findAccount(String id) throws NoSuchElementException {

    // loops through accounts ArrayList
    for (int i = 0; i < accounts.size(); i++) {

      // if there exists an account which has a matching ID, returns that account
      if (accounts.get(i).getID().equals(id)) {
        return accounts.get(i);
      }
    }

    // if no account has a matching ID, throws error
    throw new NoSuchElementException("Error: There is no such account.");
  }

  /**
   * Returns the total number of accounts created so far (i.e., the size of the Arraylist of
   * accounts
   * 
   * @return total number of accounts added to this BankTeller
   */
  public int getAccountsCount() {

    return accounts.size();
  }

  /**
   * Loads a set of transactions from a provided file object. Each transaction is in a separate
   * line. Each transaction line should contain two items: the transaction code "0" or "1" followed
   * by the transaction amount, separated by spaces. Extra spaces at the beginning and at the end of
   * a transaction line should be ignored. Not correctly formatted lines must be skipped. Valid
   * transactions must change the balance of the bank account. If java.util.Scanner object is used
   * to read from the file object, make sure to close the scanner object whenever a
   * FileNotFoundException was thrown or not.
   * 
   * @param file    - File object referring to file of transactions, one per line
   * @param account - reference to BankAccount object
   * @throws NullPointerException  if account is null
   * @throws FileNotFoundException if file object does not object
   */
  public void loadTransactions(File file, BankAccount account)
      throws NullPointerException, FileNotFoundException {

    // throws error if account is null
    if (account == null) {
      throw new NullPointerException("Error: Account is null.");
    }
    // throws error if file does not exist
    if (!file.exists()) {
      throw new FileNotFoundException("Error: File not found.");
    }
    // creates new scanner object outside of try block
    Scanner scn = new Scanner(file);
    // loop runs as long as there is another line to read in the file
    try {

      while (scn.hasNextLine()) {
        // sets String transaction to the next line the scanner reads
        String transaction = scn.nextLine();
        // tries to add transaction specified in String transaction to account, otherwise catches
        // and prints errors
        addTransaction(transaction, account);
      }
    } catch (DataFormatException d) {
      System.out.println(d.getMessage());
    } catch (NullPointerException n) {
      System.out.println(n.getMessage());
    }


    // ensures scanner is closed
    finally {
      scn.close();

    }
  }

  /**
   * Checks if transaction is of a valid format, namely has a 0 or 1 as a transaction code and an
   * Integer as a transaction amount.
   * 
   * @param transaction - String to check
   * 
   * @return true if transaction format is correct, false otherwise
   */
  private static boolean checkValidFormat(String transaction) {

    // eliminates white spaces from transaction String
    transaction = transaction.trim();
    // creates substring of first letter/number, which is a transaction code (0 or 1)
    String transactionCode = transaction.substring(0, 1);
    // creates substring of transaction amount
    String transactionAmount = transaction.substring(1);
    transactionAmount = transactionAmount.trim();
    // returns true if transaction code is 0 or 1 and transaction amount is an Integer
    if ((transactionCode.equals("0") || transactionCode.equals("1"))
        && (Integer.valueOf(transactionAmount) >= 0)) {

      return true;
    } else {
      return false;
    }
  }
}
