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
 *          void testFIFO()            runs through sample inputs on addFirst(), removeFirst()
 *          void testToBe()            the original LinkedStack.java test
 *
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

   public static void main(String[] args) {
      testStackCL();
      testQueueCL();
      testLIFO();
      testLIFO2();
      testFIFO();
      testFIFO2();
   }
}

/*
Make sure to test that multiple iterators can be used simultaneously. You can test this with a nested foreach loop. The iterators should operate independently of one another.

testStackCL    command line testing: item, -, + to quit
testQueueCL    command line testing: item, -, + to quit
testLIFO       read from file, output all, reload, output all, addFirst removeFirst
testLIFO2      same, using addLast removeLast
testFIFO       read from file, output all, reload, output all, addFirst removeLast
testFIFO2      same, using addLast removeFirst
*/
 
