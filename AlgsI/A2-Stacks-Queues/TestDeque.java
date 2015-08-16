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

   public static void testLifoCL() {
    
      Deque<String> deck = new Deque<>();
    
      StdOut.println("testLifoCL --- enter items to push, '-' for pop, '+' for quit:");
    
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (item.equals("+")) break;
         if (!item.equals("-")) deck.addFirst(item);
         else if (!deck.isEmpty()) StdOut.print(deck.removeFirst() + " ");
      }
      
      StdOut.println("\t( " + deck.size() + " left in deque )");
      StdOut.println("testLifoCL complete ----------------------------------------\n");
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

   public static void main(String[] args) {
      testLifoCL();
      testLIFO();
      testFIFO();
   }
}

/*
Make sure to test that multiple iterators can be used simultaneously. You can test this with a nested foreach loop. The iterators should operate independently of one another.

1. testLifoCL  command line testing: item, -, + to quit
2. testLIFO    read from file, output all, reload, output all
3. testFIFO    read from file, output all, reload, output all
*/
 
