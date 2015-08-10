/***************************************************************************
 *  Compilation:  javac TestDeque.java
 *  Execution:    java Deque
 *  Dependencies: StdIn.java StdOut.java
 *
 *  A test client for the Deque class
 ****************************************************************************
 *  API
 *  public class TestDeque
 *               Deque()               construct an empty deque
 *       boolean isEmpty()             is the deque empty?
 *           int size()                return the number of items on the deque
 *          void addFirst(Item item)   add the item to the front
 *          void addLast(Item item)    add the item to the end
 *          Item removeFirst()         remove and return the item from the front
 *          Item removeLast()          remove and return the item from the end
 *
 *  @author Merlin Robinson
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestDeque {
   
   
   
   
}


/*
UNIT TEST SUGGESTIONS
if you call addFirst() with the numbers 1 through N in ascending order, then call removeLast() N times, you should see the numbers 1 through N in ascending order.

Arguably even better are randomized unit tests (which we employ heavily in our correctness testing). We recommend that you create a client class with a name like TestDeque, where each unit test is a method in this class. Don't forget to test your iterator.

One very common bug is for something to go wrong when your data structure goes from non-empty to empty and then back to non-empty.

Make sure to test that multiple iterators can be used simultaneously. You can test this with a nested foreach loop. The iterators should operate independently of one another.

1.
% more tobe.txt
 to be or not to - be - - that - - - is
% java LinkedStack < tobe.txt
 to be not that or be (2 left on stack)
>>checks!


*/
 
