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
 * This class implements methods that an iterator can use to iterate through the songs in
 * SongCollection in reverse order.
 * 
 * @author Yash Hindka
 *
 */

public class ReversePlaylist implements Iterator<Song> {

  DoublyLinkedNode<Song> current; // empty node

  /**
   * Constructor that sets field current to tail DoublyLinkedNode
   * 
   * @param tail - DoublyLinkedNode that is last in SongCollection
   */
  public ReversePlaylist(DoublyLinkedNode<Song> tail) {

    // initialize fields
    current = tail;
  }

  /**
   * Checks if there is another song in list to iterate through
   * 
   * @return true if there is another song, false otherwise
   */
  @Override
  public boolean hasNext() {
    return (current != null);
  }

  /**
   * Retrieves song stored in previous node in list
   * 
   * @return next Song
   * @throws NoSuchElementException if there is no next song
   */
  @Override
  public Song next() {

    // checks if there is a next song, throws exception accordingly
    if (!(hasNext())) {

      throw new NoSuchElementException("Error: There is no next song.");
    }

    // makes copy of current node
    DoublyLinkedNode<Song> currentCopy = current;
    // advances current to previous node
    current = current.getPrevious();
    // returns copy
    return currentCopy.getData();
  }

}
