import WeightedQuickUnionUF.*;

public class Percolation {
   //  Percolation class: fields, constructor, methods, test client
   //  use WeightedQuickUnionUF class, stdlib.jar
   
   private boolean[][] grid;
   private int N;
   private boolean topNode, bottomNode;
   
   public Percolation(int N){
      if(N <= 0) throw new IllegalArgumentException("grid size argument N=" + N + "must be > 0");
      
      grid = new boolean[N+1][N+1];
      grid[0][0] = true;
      grid[N][0] = true;
      topNode = grid[0][0];  // this is reference to a boolean array value
      bottomNode = grid[N][0];

      WeightedQuickUnionFindUF uf = new WeightedQuickUnionFindUF(N+1);
      
      for(int i = 1; i <= N; i++){
         uf.union(grid.convert(0,0), grid.convert(1,i));
         uf.union(grid.convert(N,0), grid.convert(N,i));
      }
   }


   public void open(int i, int j){
      validate(i);
      validate(j);

      if(!grid[i][j]){
         grid[i][j] = true;
         uf.adjacentUnion(i,j);  ///////////////// need to connect all adjacents that are open
      }
   }

   public boolean isOpen(int i, int j){
      validate(i);
      validate(j);
   
      return grid[i][j];
   }
   
   public boolean isFull(int i, int j);{
      validate(i);
      validate(j);
      
      return connected(grid.convert(i,j),grid.convert(0,0));
   }

   public boolean percolates(){
      return connected(grid.convert(N,0),grid.convert(0,0));
   };

   private void adjacentUnion(int i, int j){  // this unites all valid adjacent grid sites
   
   }

   private int convert(int i, int j){         // {i,j}  ->  {k} k:1 to N
      return (N*(i-1) + j);
   }
   
   private int[] gridLocation(int k){         // {k}  ->  {i,j} with k:1 to N
      int[] a = {k / N + 1,  ((k - 1) % N) + 1};
      return a;
   } // is this needed?
   

   private void validate(int p) {
      if (p < 1 || p > N) throw new IndexOutOfBoundsException("index " + p + " is not in [1," + N + "]");
   }



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
