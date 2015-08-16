/***************************************************************************
 *  Compilation:  javac TestRandQueue.java
 *  Execution:    java TestRandQueue
 *  Dependencies: StdIn.java StdOut.java RandomizedQueue.java
 *
 *  A test client for the RandomizedQueue class
 ****************************************************************************
 *  API
 *  public class TestRandQueue
 *               RandomizedQueue()<Item>  construct an empty queue
 *          void testQueueCL              command line testing: item, -, + to quit
 *          void testXXX()                runs through sample inputs on enqueue() dequeue()
 *          void testIterator             see if foreach statement works
 *          void testSimulIter            run nested foreach loop to see if iterators are independent
 *
 *  @author Merlin Robinson
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestRandQueue {

   private TestRandQueue() { /*don't instantiate*/ }

   public static void testQueueCL() {
    
      RandomizedQueue<String> randQ = new RandomizedQueue<>();
    
      StdOut.println("testQueueCL --- enter items to enqueue, '-' for dequeue, '+' for quit:");
    
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (item.equals("+")) break;
         if (!item.equals("-")) randQ.enqueue(item);
         else if (!randQ.isEmpty()) StdOut.print(randQ.dequeue() + " ");
      }
      
      StdOut.println("\t( " + randQ.size() + " left in queue )");
      StdOut.println("\t( " + randQ.sample() + " random sample )");
      StdOut.println("testQueueCL complete ----------------------------------------\n");
   }

   public static void testIterator() {
      
      RandomizedQueue<String> randQ = new RandomizedQueue<>();
      int count = 0;
      String str = "";
      
      for(int i = 1; i < 6; i++){
         randQ.enqueue("" + i);
      }
      
      for(String s : randQ){
         count++;
         str += s;
         str += " ";
      }
      
      StdOut.println("testIterator begin:");
      StdOut.println("randQ.size():\t" + randQ.size() + "\titerator count:\t" + count);
      StdOut.println("iterator contents (space separated):\t" + str);
      StdOut.println("deque all five elements:");
      for(int i = 1; i < 6; i++) StdOut.println("" + randQ.dequeue());
      StdOut.println("\t( " + randQ.size() + " left in queue )");
      StdOut.println("expected: same result by both methods");
      StdOut.println("testIterator complete ----------------------------------------\n");
      
   }

   public static void main(String[] args) {
      testQueueCL();
      testIterator();
   }
}
