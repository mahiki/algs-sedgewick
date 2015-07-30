public class Percolation {

//  Percolation class: fields, constructor, methods, test client
//  use WeightedQuickUnionUF class, stdlib.jar
//  don't catch
//  if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
   
   private boolean[][] grid;
   private int N;
   
   public Percolation(int N){
      
      grid = new boolean[N+1][N+1];

      WeightedQuickUnionFindUF uf = new WeightedQuickUnionFindUF(N+1);
      
      grid[0,0] = true;
      grid[N+1,0] = true;  // does it matter if grid location is true or false?
      for(int i = 1; i <= N; i++) uf.union(grid.convert(0,0), grid.convert(1,i);
      for(int i = 1; i <= N; i++) uf.union(grid.convert(N+1,0), grid.convert(N+1,i);
   }


   public void open(int i, int j){             // open site (row i, column j) if it is not open already
      
      grid[i][j] = true;
    
   }

   public boolean isOpen(int i, int j){       // is site (row i, column j) open?
      return grid[i][j];
   }
   
//   public boolean isFull(int i, int j);     // is site (row i, column j) full?
//    if grid[i][j] is connected to top node


//   public boolean percolates();             // does the system percolate?


   private int convert(int i, int j){         // {i,j}  ->  {k} k:1 to N
      return (N*(i-1) + j);
   }
   
   private int[] gridLocation(int k){         // {k}  ->  {i,j} with k:1 to N
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
         
// open random sites {1} to {N^2} stdRandom(N,N) if that site is open choose again
// connect each site
// test if it percolates

      
         
      
         
      }
   }

}
