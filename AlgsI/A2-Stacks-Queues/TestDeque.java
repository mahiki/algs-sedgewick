/***************************************************************************
 *  Compilation:  javac TestDeque.java
 *  Execution:    java TestDeque
 *  Dependencies: StdIn.java StdOut.java Deque.java
 *
 *  A test client for the Deque class
 ****************************************************************************
 *  API
 *  public class TestDeque
 *               Deque()<Item>         construct an empty deque
 *          void testStackCL    command line testing: item, -, + to quit
 *          void testQueueCL    command line testing: item, -, + to quit
 *          void testLIFO       read from file, output all, reload, output all, addFirst removeFirst
 *          void testLIFO2      same, using addLast removeLast
 *          void testFIFO       read from file, output all, reload, output all, addFirst removeLast
 *          void testFIFO2      same, using addLast removeFirst
 *          void testIterator   see if foreach statement works
 *          void testSimulIter  run nested foreach loop to see if iterators are independent
 *  @author Merlin Robinson
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestDeque {

   private TestDeque() {/*don't instantiate*/ }

   public static void testStackCL() {
    
      Deque<String> deck = new Deque<>();
    
      StdOut.println("testStackCL --- enter items to push, '-' for pop, '+' for quit:");
    
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (item.equals("+")) break;
         if (!item.equals("-")) deck.addFirst(item);
         else if (!deck.isEmpty()) StdOut.print(deck.removeFirst() + " ");
      }
      
      StdOut.println("\t( " + deck.size() + " left in deque )");
      StdOut.println("testStackCL complete ----------------------------------------\n");
   }
   
   public static void testQueueCL() {
    
      Deque<String> deck = new Deque<>();
      
      StdOut.println("testQueueCL --- enter items to enqueue, '-' for deque, '+' for quit:");
    
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (item.equals("+")) break;
         if (!item.equals("-")) deck.addLast(item);
         else if (!deck.isEmpty()) StdOut.print(deck.removeFirst() + " ");
      }
      
      StdOut.println("\t( " + deck.size() + " left in deque )");
      StdOut.println("testQueueCL complete ----------------------------------------\n");
   }
   
   public static void testLIFO() {
      
      Deque<String> deck = new Deque<>();
      
      try { In in = new In("./test/num-1-to-5.txt");

         while (!in.isEmpty()) {
             String s = in.readLine();
             StdOut.println("\t\tin:\t" + s);
            if(s.equals("-")) StdOut.print(deck.removeFirst() + " ");
            else deck.addFirst(s);
         }
         
         StdOut.println("\t( " + deck.size() + " left on deck )");
         
      } catch (Exception e) { StdOut.println(e); }
      
      StdOut.println("expected: 5 to 1 descending order, x2, ( 0 left in deque )");
      StdOut.println("testLIFO complete ----------------------------------------\n");
   }

   public static void testLIFO2() {
      
      Deque<String> deck = new Deque<>();
      
      try { In in = new In("./test/num-1-to-5.txt");

         while (!in.isEmpty()) {
             String s = in.readLine();
             StdOut.println("\t\tin:\t" + s);
            if(s.equals("-")) StdOut.print(deck.removeLast() + " ");
            else deck.addLast(s);
         }
         
         StdOut.println("\t( " + deck.size() + " left on deck )");
         
      } catch (Exception e) { StdOut.println(e); }
      
      StdOut.println("expected: 5 to 1 descending order, x2, ( 0 left in deque )");
      StdOut.println("testLIFO2 complete ----------------------------------------\n");
   }

   public static void testFIFO() {
      
      Deque<String> deck = new Deque<>();
      
      try { In in = new In("./test/num-1-to-5.txt");

         while (!in.isEmpty()) {
             String s = in.readLine();
             StdOut.println("\t\tin:\t" + s);
            if(s.equals("-")) StdOut.print(deck.removeLast() + " ");
            else deck.addFirst(s);
         }
         
         StdOut.println("\t( " + deck.size() + " left on deck )");
         
      } catch (Exception e) { StdOut.println(e); }
      
      StdOut.println("expected: 1 to 5 ascending order, x2, ( 0 left in deque )");
      StdOut.println("testFIFO complete ----------------------------------------\n");
   }

   public static void testFIFO2() {
      
      Deque<String> deck = new Deque<>();
      
      try { In in = new In("./test/num-1-to-5.txt");

         while (!in.isEmpty()) {
             String s = in.readLine();
             StdOut.println("\t\tin:\t" + s);
            if(s.equals("-")) StdOut.print(deck.removeFirst() + " ");
            else deck.addLast(s);
         }
         
         StdOut.println("\t( " + deck.size() + " left on deck )");
         
      } catch (Exception e) { StdOut.println(e); }
      
      StdOut.println("expected: 1 to 5 ascending order, x2, ( 0 left in deque )");
      StdOut.println("testFIFO2 complete ----------------------------------------\n");
   }
   
   public static void testIterator() {
      
      Deque<String> deck = new Deque<>();
      int count = 0;
      String str = "";
      
      for(int i = 1; i < 6; i++){
         deck.addFirst("" + i);
      }
      
      for(String s : deck){
         count++;
         str += s;
         str += " ";
      }
      
      StdOut.println("testIterator begin:");
      StdOut.println("deck.size():\t" + deck.size() + "\titerator count:\t" + count);
      StdOut.println("iterator contents (space separated):\t" + str);
      StdOut.println("deque all five elements:");
      for(int i = 1; i < 6; i++) StdOut.println("" + deck.removeLast());
      StdOut.println("expected: same result by both methods (reverse order)");
      StdOut.println("testIterator complete ----------------------------------------\n");
      
   }

   public static void main(String[] args) {
      testStackCL();
      testQueueCL();
      testLIFO();
      testLIFO2();
      testFIFO();
      testFIFO2();
      testIterator();
   }
}
