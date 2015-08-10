/***************************************************************************
 *  Compilation:  javac Deque.java
 *  Execution:    java Deque < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A double-ended queue, "deck".
 ****************************************************************************
 *  API
 *  public class Deque<Item> implements Iterable<Item>
 *               Deque()               construct an empty deque
 *       boolean isEmpty()             is the deque empty?
 *           int size()                return the number of items on the deque
 *          void addFirst(Item item)   add the item to the front
 *          void addLast(Item item)    add the item to the end
 *          Item removeFirst()         remove and return the item from the front
 *          Item removeLast()          remove and return the item from the end
 *Iterator<Item> iterator()            return an iterator over items in order from front to end
 *
 *  @author Merlin Robinson
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
   
   private int N;
   private Node first, last;
   
   public Deque() {
      first = null;
      last = first;
      N = 0;
   }

   private class Node {
    Item item;
    Node next;
   }
   
   public boolean isEmpty() {
      return first == null;
   }
   
   public int size() {
      return N;
   }
   
   public void addFirst(Item item) {
      if(item == null) throw new NullPointerException("pushing null");
      
      Node oldfirst = first;
      first = new Node();
      first.item = item;
      first.next = oldfirst;
      N++;
   }
      
   public void addLast(Item item) {
      if(item == null) throw new NullPointerException("pushing null");
      
      Node oldlast = last;
      last = new Node();
      last.item = item;
      oldlast.next = last;
      last.next = null;
      N++;
      
   }

   public Item removeFirst() {
      if (isEmpty()) throw new NoSuchElementException("stack underflow");
      
      Item item = first.item;
      first = first.next;
      N--;
      return item;
   }
   
   public Item removeLast() {
      if (isEmpty()) throw new NoSuchElementException("stack underflow");
   
      Item item = last.item;
      last = null;
      N--;
      return item;
   }

   public Iterator<Item> iterator()         // return an iterator over items in order from front to end


   public static void main(String[] args) {
      Deque deck = new Deque();
    
      while (!StdIn.isEmpty()) {
         String s = StdIn.readString();
      
         if (s.equals("-")) StdOut.print(stack.pop());
         else stack.push(s);
      }
   }
}

/*
deque operation in constant worst-case time
space proportional to the number of items currently in the deque.
iterator implementation must support each operation (including construction) in constant worst-case time

public interface Iterable<Item> {
 Iterator<Item> iterator();
}

public interface Iterator<Item> {
 boolean hasNext();
 Item next();
}
*/

   public Iterator<Item> iterator() { return new ListIterator(); }
   
   private class ListIterator implements Iterator<Item> {
      private Node current = first;

      public boolean hasNext() { return current != null; }
      public void remove() { throw new UnsupportedOperationException("iterator.remove() not supported");  }
      
      public Item next() {
         if(current.next == null) throw new NoSuchElementException("no element to call next()");
         Item item = current.item;
         current = current.next;
         return item;
      }
   }

/*
UNIT TEST SUGGESTIONS
if you call addFirst() with the numbers 1 through N in ascending order, then call removeLast() N times, you should see the numbers 1 through N in ascending order.

Arguably even better are randomized unit tests (which we employ heavily in our correctness testing). We recommend that you create a client class with a name like TestDeque, where each unit test is a method in this class. Don't forget to test your iterator.

One very common bug is for something to go wrong when your data structure goes from non-empty to empty and then back to non-empty.

Make sure to test that multiple iterators can be used simultaneously. You can test this with a nested foreach loop. The iterators should operate independently of one another.
*/
 