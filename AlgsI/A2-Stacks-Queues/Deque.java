/***************************************************************************
 *  Compilation:  javac Deque.java
 *  Execution:    java Deque < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A double-ended queue, "deck".
 ****************************************************************************
 *   API
 *   public class Deque<Item> implements Iterable<Item>
 *                Deque()               construct an empty deque
 *        boolean isEmpty()             is the deque empty?
 *            int size()                return the number of items on the deque
 *           void addFirst(Item item)   add the item to the front
 *           void addLast(Item item)    add the item to the end
 *           Item removeFirst()         remove and return the item from the front
 *           Item removeLast()          remove and return the item from the end
 * Iterator<Item> iterator()            return an iterator over items in order from front to end
 *
 *  see java.lang.Iterable and java.util.Iterator
 *  @author Merlin Robinson
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
   
   private int N;
   private Node first, last;
   
   private class Node {
    Item item;
    Node next;
   }
   
   public Deque() {
      first = null;
      last = null;
      N = 0;
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
      last.next = null;
      if (isEmpty()) first = last;
      else           oldlast.next = last;
      N++;

   }

   public Item removeFirst() {
      if (isEmpty()) throw new NoSuchElementException("deque underflow");
      
      Item item = first.item;
      first = first.next;
      N--;
      return item;
   }
   
   public Item removeLast() {
      if (isEmpty()) throw new NoSuchElementException("deque underflow");
   
      Item item = last.item;
      last = null;
      N--;
      return item;
   }

   public Iterator<Item> iterator() { return new ListIterator(); }
   
   private class ListIterator implements Iterator<Item> {
      private Node current = first;

      public boolean hasNext() { return current != null; }
    
      public void remove() { throw new UnsupportedOperationException("remove() not supported");  }
      
      public Item next() {
         if(!hasNext()) throw new NoSuchElementException("no element to call next()");

         Item item = current.item;
         current = current.next;
         return item;
      }
   }

   public static void main(String[] args) {
/*
      Deque<String> deck = new Deque<>();
    
      while (!StdIn.isEmpty()) {
         String s = StdIn.readString();
      
         if (!s.isEmpty()) {
            
            if(s.equals("-")) StdOut.print(deck.removeFirst() + " ");
            else if(s.equals("+")) StdOut.print("size is: " + deck.size() + " ");
            else if(s.equals("/")) brea;
            else deck.addFirst(s);
         }
      }
     StdOut.println("   ( " + deck.size() + " left on stack )");
*/   }
     
}