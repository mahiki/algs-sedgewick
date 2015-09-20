/***************************************************************************
 *  Compilation:  javac Subset.java
 *  Execution:    echo A B C D E F G H I... | java Subset k
 *  Dependencies: StdIn.java StdOut.java RandomizedQueue.java
 *
 *  A client that reads N strings and returns k of them at random
 *  needs: I didn't do this yet, still need to do.
 ****************************************************************************/
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Subset {
   
   public static void main(String[] args){
   
      int k = Integer.parseInt(args[0]);
      
      RandomizedQueue<String> randQ = new RandomizedQueue<>();
    
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (item.equals("+")) break;
         if (!item.equals("-")) randQ.enqueue(item);
         else if (!randQ.isEmpty()) StdOut.print(randQ.dequeue() + " ");
      }

      for(int i = 0; i < k; i++){
         StdOut.println("" + randQ.dequeue());
      }
   }
}