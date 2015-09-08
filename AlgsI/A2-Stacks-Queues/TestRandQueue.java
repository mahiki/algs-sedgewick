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
    
      StdOut.println("testQueueCL ---\n"
         + "\tenter items to enqueue, '-' for dequeue, '=' for size '+' for quit:");
    
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (item.equals("+")) break;
         else if (item.equals("=")) StdOut.println("\t" + randQ.size());
         else if (item.equals("-")) {
            if(!randQ.isEmpty()) StdOut.println("\t" + randQ.dequeue());
            else StdOut.println("\tisEmpty() = " + randQ.isEmpty());
         }
         else randQ.enqueue(item);
      }
      
      StdOut.println("\t( " + randQ.size() + " : left in queue )");
      if(!randQ.isEmpty()) StdOut.println("\t( " + randQ.sample() + " : random sample )");
      else StdOut.println("\tisEmpty() = " + randQ.isEmpty());
      StdOut.println("testQueueCL complete ----------------------------------------\n");
   }

   public static void testIterator() {
      
      RandomizedQueue<String> randQ = new RandomizedQueue<>();
      int count = 0;
      String str = "";
      
      for(int i = 1; i < 21; i++){
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
      StdOut.println("dequeue all five elements:");
      for(int i = 1; i < 21; i++) StdOut.println("" + randQ.dequeue());
      StdOut.println("\t( " + randQ.size() + " left in queue )");
      StdOut.println("expected: all elements, independent random order, 0 left");
      StdOut.println("testIterator complete ----------------------------------------\n");
      
   }

   public static void main(String[] args) {
      testQueueCL();
      testIterator();
   }
}
