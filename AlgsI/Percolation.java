/****************************************************************************
 *  Compilation:  javac Percolation.java
 *  Execution:    java Percolation <integer N>
 *  Dependencies: StdIn.java StdOut.java WeightedQuickUnionUF.java
 *
 *  Percolation test of NxN grid
 ****************************************************************************/

/**
 *  an instance of Percolation will create an NxN grid and a union-find
 *  array data structure object.  The client can select grid elements and
 *  open them, which connects to any adjacent open cells.  The client can test
 *  if there is a connection (implying flow in the physical model) between
 *  top and bottom rows of the grid.
 *
 * API
 * public class Percolation
 *              Percolation(int N)     create N-by-N grid, with all sites blocked
 *         void open(int i, int j)     open site (row i, column j) if not open already
 *      boolean isOpen(int i, int j)   is site (row i, column j) open?
 *      boolean isFull(int i, int j)   is site (row i, column j) full?
 *      boolean percolates()           does the system percolate?
 *  static void main(String[] args     test client (optional)
 *
 *      private methods
 *  private int convert(int i, int j)  convert grid coordinate to linear component id
 * private void validate(int p)        tests out-of-bounds
 * private void adjacentUnion(i,j)     union of {i,j} with all open adjacent cells
 *
 *  @author Merlin Robinson
 */
public class Percolation {
   
   private boolean[][] grid;
   private int N, topNode, bottomNode;
   private WeightedQuickUnionUF uf;
   
   public Percolation(int N){
      if(N <= 0) throw new IllegalArgumentException(
            "grid size argument N=" + N + " must be > 0");
      
      this.N = N;    // this is important :-)
      grid = new boolean[N+1][N+1];
      topNode = 0;
      bottomNode = N*N+1;
      uf = new WeightedQuickUnionUF(N*N+2);

      for(int h = 1; h <= N; h++){
         uf.union(topNode,    convert(1,h));
         uf.union(bottomNode, convert(N,h));
      }
   }

   public void open(int i, int j){
      validate(i);
      validate(j);

      if(!grid[i][j]){
         grid[i][j] = true;
         adjacentUnion(i,j);
      }
   }

   public boolean isOpen(int i, int j){
      validate(i);
      validate(j);
      return grid[i][j];
   }
   
   public boolean isFull(int i, int j){
      validate(i);
      validate(j);
      return uf.connected(convert(i,j),topNode);
   }

   public boolean percolates(){
      return uf.connected(topNode,bottomNode);
   };

   private void adjacentUnion(int i, int j){
         
      if(i>1 && grid[i-1][j]) uf.union(convert(i-1,j),convert(i,j));
      if(i<N && grid[i+1][j]) uf.union(convert(i+1,j),convert(i,j));
      if(j>1 && grid[i][j-1]) uf.union(convert(i,j-1),convert(i,j));
      if(j<N && grid[i][j+1]) uf.union(convert(i,j+1),convert(i,j));
   }

   private int convert(int i, int j){  // {i,j}  ->  {k} k:1 to N, {i,j > 0}
      return (N*(i-1) + j);
   }

   private void validate(int p) {
      if (p < 1 || p > N) throw new IndexOutOfBoundsException(
            "index " + p + " is not in [1," + N + "]");
   }



   public static void main(String[] args){

      int N = Integer.parseInt(args[0]);
      double p = 1.0;
      int openCells = 0;
      int iRnd = 0;
      int jRnd = 0;
      Percolation perc = new Percolation(N);
      
      while(!perc.percolates()){
         iRnd = StdRandom.uniform(N)+1;
         jRnd = StdRandom.uniform(N)+1;
         if(perc.isOpen(iRnd,jRnd)) continue;
         
         perc.open(iRnd,jRnd);
         openCells++;
      }

      String str = "X";
      StdOut.print("  \t ");
      for(int i = 1; i<=N; i++) StdOut.print("_");
      StdOut.println();
      for(int i = 1; i < N + 1; i++){
         System.out.print("" + i + "\t|");
         for(int j = 1; j < N + 1; j++){
            str = perc.grid[i][j] ? " " : "X";
            StdOut.print("" + str);
         }
            System.out.println("|");
      }
      StdOut.print("  \t");
      for(int i = 1; i<=N+2; i++) StdOut.print("-");
      
      p = 1.0 * openCells / (N*N);
      StdOut.println("\nPercolates: " +  perc.percolates());
      StdOut.println("Last Opened Cell: {" + iRnd + "," + jRnd + "}");
      StdOut.println("Open Cells|N^2|Ratio: "
         + openCells + "|" + N*N + "|" + p + "\n");
   }
}
