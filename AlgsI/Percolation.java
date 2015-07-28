public class Percolation {

   // Percolation class: fields, constructor, methods, test client
   // use WeightedQuickUnionUF class, stdlib.jar
   
   private boolean[][] grid;
   private int N;
   
   public Percolation(int N){ //constructor, nodes [1][1] to [N][N]
      
      grid = new boolean[N+1][N+1];
      // connect[0][0] to all nodes in top row
      // connect[N+1][N] to all nodes in bottom row grid[N]
   }

//  don't catch
//  if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");


   public void open(int i, int j){             // open site (row i, column j) if it is not open already
      
      // stdRandom(N,N) if that site is open choose again
      
      grid[i][j] = true;
   }

   public boolean isOpen(int i, int j){       // is site (row i, column j) open?
      return grid[i][j];
   }
   
//   public boolean isFull(int i, int j);     // is site (row i, column j) full?
//    if grid[i][j] is connected to top node


//   public boolean percolates();             // does the system percolate?


   private int convert(int i, int j){         // convert grid coordinate to linear component id
      return (N*(i-1) + j);
   }
   
   private int[] gridLocation(int k){         // grid coordinates of component id
      int[] a = {k / N + 1,  ((k - 1) % N) + 1};
      return a;
   }

/*   private void validate(int p) {            // validate that p is a valid index
        int N = parent.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
        }
    }*/


   public static void main(String[] args){   // Test Client
      
      Percolation perc = new Percolation(Integer.parseInt(args[0]));
      
      for(int i = 0; i < perc.grid.length; i++)
         System.out.println("your Percolation grid["+i+"] is size: " + perc.grid[i].length);
   
      System.out.println("contents of perc.grid[][]");
      
      for(int i = 0; i < perc.grid.length; i++){
         for(int j = 0; j < perc.grid.length; j++) System.out.print("" + perc.grid[i][j] + "\t");
         System.out.println(";");
      }
   }

}
