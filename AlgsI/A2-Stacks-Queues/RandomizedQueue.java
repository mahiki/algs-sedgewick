/***************************************************************************
 *  Compilation:  javac RandomizedQueue.java
 *  Execution:    java RandomizedQueue < input.txt
 *  Dependencies: StdIn.java StdOut.java StdRandom.java
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
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


public class RandomizedQueue<Item> implements Iterable<Item> {
   
   private Item[] q;
   private int N = 0;
   private int first = 0;       // index of first element of queue
   private int last  = 0;       // index of next available slot

   public RandomizedQueue(){
      
      q = (Item[]) new Object[2];
   }
  
   public boolean isEmpty(){ return N == 0; }
  
   public int size(){ return N;}
  
   public void enqueue(Item item){
      
      if (N == q.length) resize(2*q.length);
      q[last++] = item;
      if (last == q.length) last = 0;
      N++;
   }

   public Item dequeue(){
      
      if (isEmpty()) throw new NoSuchElementException("Queue underflow");
      int randex = (StdRandom.uniform(N) + first) % q.length;
      
      Item tmp = q[randex];
      q[randex] = q[first];
      q[first] = tmp;                                    // swap
      
      Item item = q[first];
      q[first] = null;
      N--;
      first++;
      if (first == q.length) first = 0;                  // wrap-around
      
      if (N > 0 && N == q.length/4) resize(q.length/2);  // shrinker
      return item;
   }
  
   public Item sample(){
      
      if (isEmpty()) throw new NoSuchElementException("Queue underflow");
      return q[(StdRandom.uniform(N) + first) % q.length];
   }

   public Iterator<Item> iterator() {
   
      return new ArrayIterator();
   }
      
   private class ArrayIterator implements Iterator<Item> {
   
      private int i = 0;
      public boolean hasNext()  { return i < N; }
      public void remove()      { throw new UnsupportedOperationException("remove() not supported"); }
       
      public Item next() {
         if (!hasNext()) throw new NoSuchElementException();
         Item item = q[(i + first) % q.length];
         i++;
         return item;
      } //Use StdRandom.shuffle() /????
   }
   
   private void resize(int max) {
      
      Item[] temp = (Item[]) new Object[max];
      for (int i = 0; i < N; i++) {
         temp[i] = q[(i + first) % q.length];
      }
      q = temp;
      first = 0;
      last  = N;
    }


   public static void main(String[] args) {
   /* test client is TestRandQueue */
   }
}