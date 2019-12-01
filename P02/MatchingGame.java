//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P02 Matching Game
// Files: MatchingGame.java
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
import java.util.Arrays;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The MatchingGame class is designed to produce a memory card matching game for the user. It
 * randomly places 12 cards in a grid and allows the user to click on each and try to match the
 * cards.
 * 
 * @author Yash Hindka
 *
 */

public class MatchingGame {

  // Congratulations message
  private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
  // Cards not matched message
  private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
  // Cards matched message
  private final static String MATCHED = "CARDS MATCHED! Good Job!";
  // 2D-array which stores cards coordinates on the window display
  private final static float[][] CARDS_COORDINATES =
      new float[][] {{170, 170}, {324, 170}, {478, 170}, {632, 170}, {170, 324}, {324, 324},
          {478, 324}, {632, 324}, {170, 478}, {324, 478}, {478, 478}, {632, 478}};
  // Array that stores the card images filenames
  private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png", "ball.png",
      "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};

  private static PApplet processing; // PApplet object that represents
  // the graphic display window
  private static Card[] cards; // one dimensional array of cards
  private static PImage[] images; // array of images of the different cards
  private static Random randGen; // generator of random numbers
  private static Card selectedCard1; // First selected card
  private static Card selectedCard2; // Second selected card
  private static boolean winner; // boolean evaluated true if the game is won,
  // and false otherwise
  private static int matchedCardsCount; // number of cards matched so far
  // in one session of the game
  private static String message; // Displayed message to the display window
  private static boolean matched;
  private static boolean notMatched;

  public static void main(String[] args) {

    // starts application
    Utility.runApplication();
  }

  /**
   * Defines the initial environment properties of this game as the program starts
   */
  public static void setup(PApplet processing) {

    MatchingGame.processing = processing;

    // initializes images array
    images = new PImage[CARD_IMAGES_NAMES.length];
    // fills images array with card images
    for (int i = 0; i < images.length; i++) {
      images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
    }

    // calls initGame() in order to initialize fields
    initGame();


  }

  /**
   * Initializes the Game
   */
  public static void initGame() {

    // initialize static fields
    randGen = new Random(Utility.getSeed());
    selectedCard1 = null;
    selectedCard2 = null;
    matchedCardsCount = 0;
    winner = false;
    message = "";
    cards = new Card[CARD_IMAGES_NAMES.length * 2];
    // creates copy of CARDS_COORDINATES
    float[][] cardsCoordinatesCopy =
        new float[CARDS_COORDINATES.length][CARDS_COORDINATES[0].length];
    // int to keep track of significant elements in cardsCoordinatesCopy
    int cardsCoordinatesCopySize = CARDS_COORDINATES.length;
    // fills cardsCoordinatesCopy with elements from CARDS_COORDINATES
    for (int r = 0; r < cardsCoordinatesCopySize; r++) {
      for (int c = 0; c < CARDS_COORDINATES[0].length; c++) {
        cardsCoordinatesCopy[r][c] = CARDS_COORDINATES[r][c];
      }
    }

    int imagesIndex = 0;
    int counter = 0;
    // fills cards array with elements of type Card() at random locations in grid
    for (int i = 0; i < cards.length; i++) {
      int random = randGen.nextInt(cardsCoordinatesCopySize);
      cards[i] = new Card(images[imagesIndex], cardsCoordinatesCopy[random][0],
          cardsCoordinatesCopy[random][1]);

      // increments imagesIndex every other card
      if (counter % 2 != 0) {
        imagesIndex++;
      }
      counter++;
      // removes coordinate element from cardsCoordinatesCopy
      for (int j = random; j < cardsCoordinatesCopySize - 1; j++) {
        cardsCoordinatesCopy[j][0] = cardsCoordinatesCopy[j + 1][0];
        cardsCoordinatesCopy[j][1] = cardsCoordinatesCopy[j + 1][1];
      }
      // decrements cardsCoordinatesCopySize after the used element is removed
      cardsCoordinatesCopySize--;

    }


  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {

    // reshuffles cards for new game when 'n' or 'N' key is pressed
    if (processing.key == 'n' || processing.key == 'N') {
      setup(processing);
    }
  }

  /**
   * Callback method draws continuously this application window display
   */
  public static void draw() {

    // sets background color to mint green
    processing.background(245, 255, 250);

    // draws cards
    for (int s = 0; s < cards.length; s++) {
      cards[s].draw();
    }

    // checks if all cards are matched and game is won/finished
    if (matchedCardsCount == 12) {

      winner = true;
    }

    // changes message displayed depending on whether cards were matched, not matched, or the game
    // is won
    if (matched && winner) {
      displayMessage(CONGRA_MSG);
    } else if (matched) {
      displayMessage(MATCHED);
    } else if (notMatched) {
      displayMessage(NOT_MATCHED);
    } else if (winner) {
      displayMessage(CONGRA_MSG);
    } else {
      // draws message
      displayMessage(message);
    }

  }

  // draws message
  // displayMessage(message);


  /**
   * Displays a given message to the display window
   * 
   * @param message to be displayed to the display window
   */
  public static void displayMessage(String message) {
    // formats message
    processing.fill(0);
    processing.textSize(20);
    processing.text(message, processing.width / 2, 50);
    processing.textSize(12);
  }

  /**
   * Checks whether the mouse is over a given Card
   * 
   * @return true if the mouse is over the storage list, false otherwise
   */
  public static boolean isMouseOver(Card card) {

    // sets xPos and yPos to current position of mouse
    int xPos = processing.mouseX;
    int yPos = processing.mouseY;

    // checks if mouse is over card specified in parameter
    if (Math.abs(xPos - card.getX()) <= card.getWidth() / 2
        && Math.abs(yPos - card.getY()) <= card.getHeight() / 2) {
      return true;
    }
    return false;
  }


  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    if (selectedCard1 != null && selectedCard2 != null && matched) {
   // the selectedCards and selectedCount are reset
      selectedCard1.deselect();
      selectedCard2.deselect();
      selectedCard1 = null;
      selectedCard2 = null;
    }
    // loop calls isMouseOver(), sending each card in the cards array as a parameter to see which
    // card the mouse is over
    for (int i = 0; i < cards.length; i++) {

      if (isMouseOver(cards[i])) {

        if (!(cards[i].isVisible()))
          if (selectedCard1 != null && selectedCard2 != null) {

            if (selectedCard1.isVisible() && selectedCard2.isVisible() && notMatched) {

              selectedCard1.deselect();
              selectedCard1.setVisible(false);
              selectedCard2.deselect();
              selectedCard2.setVisible(false);
              selectedCard1 = null;
              selectedCard2 = null;
            }
          }


        cards[i].setVisible(true);
        cards[i].select();
        // adds card that was clicked on to selectedCards
        if (selectedCard1 == null) {
          selectedCard1 = cards[i];
        } else {
          selectedCard2 = cards[i];
        }
        break;
      }
    }


    if (selectedCard1 != null && selectedCard2 != null) {


      // if 2 cards are selected, checks if the cards are the same
      if (matchingCards(selectedCard1, selectedCard2)) {

        // if the cards match, sets message to MATCHED and matchedCardsCount is incremented
        notMatched = false;
        matched = true;
        matchedCardsCount += 2;


      } else {

        // if the cards do not match, sets message to NOT_MATCHED
        matched = false;
        notMatched = true;


      }
    }

  }

  /**
   * Checks whether two cards match or not
   * 
   * @param card1 reference to the first card
   * @param card2 reference to the second card
   * @return true if card1 and card2 image references are the same, false otherwise
   */
  public static boolean matchingCards(Card card1, Card card2) {


    // checks if 2 selected cards have the same image and are at different locations
    if (card1.getImage().equals(card2.getImage()) && card1.getX() != card2.getX()) {

      return true;
    }
    return false;
  }



}
