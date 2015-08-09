/***************************************************************************
 *  Compilation:  javac Deque.java
 *  Execution:    java Deque < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A double-ended queue, "deck".
 ****************************************************************************
 *
 *
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
 
public class Deque<Item> implements Iterable<Item> {

   public Deque()                           // construct an empty deque


   public boolean isEmpty()                 // is the deque empty?
   public int size()                        // return the number of items on the deque
   public void addFirst(Item item)          // add the item to the front
   public void addLast(Item item)           // add the item to the end
   public Item removeFirst()                // remove and return the item from the front
   public Item removeLast()                 // remove and return the item from the end
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end


   public static void main(String[] args)   // unit testing
}

/*
Throw a java.lang.NullPointerException if the client attempts to add a null item\nthrow a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque
throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator
throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.

deque operation in constant worst-case time
space proportional to the number of items currently in the deque.
iterato implementation must support each operation (including construction) in constant worst-case time
*/
 