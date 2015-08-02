public class Percolation {
   
   private boolean[][] grid;
   private int N, topNode, bottomNode;
   private WeightedQuickUnionUF uf;
   
   public Percolation(int N){
      if(N <= 0) throw new IllegalArgumentException("grid size argument N=" + N + " must be > 0");
      
      this.N = N;                         // assign the argument to the instance variable N
      grid = new boolean[N+1][N+1];
      topNode = 0;
      bottomNode = N*N+1;
      StdOut.println("bottomNode: " + bottomNode);

      uf = new WeightedQuickUnionUF(N*N+2);
      StdOut.println("uf.count(): " + uf.count());
      for(int h = 1; h <= N; h++){
         uf.union(topNode,    convert(1,h));
         uf.union(bottomNode, convert(N,h));
      }
      StdOut.println("uf.connected(0,1): " + uf.connected(0,1));
      StdOut.println("uf.connected(N*N,bottomNode): " + uf.connected(N*N,bottomNode));
      StdOut.println("uf.connected(topNode,bottomNode): " + uf.connected(topNode,bottomNode));
      StdOut.println("uf.count(): " + uf.count());
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

   private int convert(int i, int j){         // {i,j}  ->  {k} k:1 to N, {i,j > 0}
      return (N*(i-1) + j);
   }

   private void validate(int p) {
      if (p < 1 || p > N) throw new IndexOutOfBoundsException("index " + p + " is not in [1," + N + "]");
   }



   public static void main(String[] args){   // Test Client
      int N = Integer.parseInt(args[0]);
      
      Percolation perc = new Percolation(N);
      
      StdOut.println("contents of perc.grid[][]");
      for(int i = 1; i < N + 1; i++){
         for(int j = 1; j < N + 1; j++)
            StdOut.print("" + perc.grid[i][j] + "{" + perc.convert(i,j) + "}" + "\t");
         System.out.println("");
      }
         
// open random sites {1} to {N^2} stdRandom(N,N) if that site is open choose again
// connect each site    StdRandom.uniform(N)  produces [0,N) random integer #s
// test if it percolates
         
      StdOut.println("perc.percolates(): " +  perc.percolates());
      String str = "X";
      while(!perc.percolates()){
         int iRnd = StdRandom.uniform(N)+1;
         int jRnd = StdRandom.uniform(N)+1;
         if(perc.isOpen(iRnd,jRnd)) continue;
         
         perc.open(iRnd,jRnd);
         for(int i = 1; i<=N+1; i++) StdOut.print("_");
         StdOut.println(" iRnd, jRnd: " + iRnd + ", " + jRnd);
   
         for(int i = 1; i < N + 1; i++){
            System.out.print("|");
            for(int j = 1; j < N + 1; j++){
               str = perc.grid[i][j] ? " " : "X";
               StdOut.print("" + str);
            }
            System.out.println("|");
         }
         for(int i = 1; i<=N+1; i++) StdOut.print("-");
         StdOut.println("\nperc.percolates(): " +  perc.percolates()+"\n");
      }
   }
}
