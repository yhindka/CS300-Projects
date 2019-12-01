//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P07 Study Playlist
// Files: Song.java, DoublyLinkedNode.java, SongCollection.java, Playlist.java, ReversePlaylist.java
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
import java.util.NoSuchElementException;

/**
 * This class creates and stores a doubly linked list of Songs
 * 
 * @author Yash Hindka
 *
 */
public class SongCollection implements Iterable<Song> {

  private DoublyLinkedNode<Song> head; // head node of doubly linked list
  private DoublyLinkedNode<Song> tail; // tail node of doubly linked list
  private boolean playDirectionForward; // boolean storing direction that songs play

  /**
   * No argument constructor that initializes fields, thus creating an empty doubly linked list
   */
  public SongCollection() {

    // initialize fields
    head = null;
    tail = null;
    playDirectionForward = true;
  }

  /**
   * Adds song to the end/tail of this doubly linked list. When song is null, throws a
   * NullPointerException
   * 
   * @param song - Song object to be added to list
   * @throws NullPointerException if song parameter is null
   */
  public void add(Song song) {

    // checks if song is null, throws exception accordingly
    if (song == null) {
      throw new NullPointerException("Error: Song is null.");
    }

    // create new node from song parameter
    DoublyLinkedNode<Song> newSong = new DoublyLinkedNode<Song>(song);
    // if list is empty, points head and tail pointers to newSong
    if (this.head == null && this.tail == null) {

      this.head = newSong;
      this.tail = newSong;
    }

    // if list is not empty, adds song to end of list
    else {

      this.tail.setNext(newSong);
      newSong.setPrevious(this.tail);
      newSong.setNext(null);
      this.tail = newSong;

    }
  }


  /**
   * Removes and returns song from the front/head of this list, when list is empty, throws a
   * NoSuchElementException
   * 
   * @return removed song
   * @throws NoSuchElementException when list is empty
   */
  public Song remove() {

    // checks if list is empty, throws exception accordingly
    if (head == null && tail == null) {
      throw new NoSuchElementException("Error: List is empty.");
    }

    // stores Song stored in head node to be removed
    Song remove = this.head.getData();

    // checks if there is more than 1 element in list
    if (head.getNext() != null) {

      // checks if there are only 2 elements in list
      if (head.getNext() == tail) {
        this.head = tail;
        tail = null;
      }
      // checks if there are more than 2 elements in list
      else {
        this.head = this.head.getNext();
        this.head.setPrevious(null);
      }
    }

    // sets head to null, and therefore list to empty, if there is only 1 block in list
    else {
      this.head = null;
    }

    // return removed Song
    return remove;

  }

  /**
   * Creates new instance of iterator object. Iterator will use the methods in the Playlist class to
   * iterate in forward direction if playDirectionForward is true. Otherwise it will use the methods
   * in the ReversePlaylist class to iterate in the reverse direction if playDirectionForward is
   * false.
   * 
   * @return new iterator object of type Song
   */
  @Override
  public Iterator<Song> iterator() {

    // checks if playDirectionForward is true, returns Playlist iterator accordingly
    if (playDirectionForward) {
      return new Playlist(this.head);
    }

    // returns ReversePlaylist iterator
    else {
      return new ReversePlaylist(this.tail);
    }
  }

  /**
   * Mutator method that can change the value of the playDirectionForward boolean
   * 
   * @param isForward - boolean value to set playDirectionForward to
   */
  public void setPlayDirection(boolean isForward) {

    this.playDirectionForward = isForward;
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // For each of the following big-O time complexity analyses, consider the problem
  // size to be the number of Songs that are stored within the argument songs, when
  // the method is first called.
  //
  // For analysisMethodA, the big-O time complexity is ____O(1)________.
  //
  // For analysisMethodB, the big-O time complexity is _____O(N)_______.
  //
  // For analysisMethodC, the big-O time complexity is __O(1)__________.
  //
  ///////////////////////////////////////////////////////////////////////////////////

}
