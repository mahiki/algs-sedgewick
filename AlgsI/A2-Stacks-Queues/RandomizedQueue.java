/***************************************************************************
 *  Compilation:  javac RandomizedQueue.java
 *  Execution:    java RandomizedQueue < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A queue that returns items at random
 ****************************************************************************
 *  API
 *         class RandomizedQueue<Item> implements Iterable<Item>
 *               RandomizedQueue()     construct an empty randomized queue
 *       boolean isEmpty()             is the queue empty?
 *           int size()                return the number of items on the queue
 *          void enqueue(Item item)    add the item
 *          Item dequeue()             remove and return a random item
 *          Item sample()              return (but do not remove) a random item
 *Iterator<Item> iterator()            return an independent iterator over items in random order
 *
 *  see java.lang.Iterable and java.util.Iterator
 *  @author Merlin Robinson
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
  
   public RandomizedQueue(){};                 // construct an empty randomized queue
  
   public boolean isEmpty(){};                // is the queue empty?
  
   public int size(){};                        // return the number of items on the queue
  
   public void enqueue(Item item){};           // add the item
  
   public Item dequeue(){};                    // remove and return a random item
  
   public Item sample(){};                     // return (but do not remove) a random item


   public Iterator<Item> iterator() { return new ListIterator(); }
   
   private class ListIterator implements Iterator<Item> {
      //private Node current = first;

      public boolean hasNext() {return true; } // fix
    
      public void remove() { throw new UnsupportedOperationException("remove() not supported");  }
      
      public Item next() {
         if(!hasNext()) throw new NoSuchElementException("no element to call next()");

         Item item = current.item;
         current = current.next;*/
         return ???;
      }
   }


   public static void main(String[] args) {
      
      
      
   }
}