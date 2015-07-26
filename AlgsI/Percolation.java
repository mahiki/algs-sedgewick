public class Percolation {

   // Percolation class: fields, constructor, methods, test client
   
   public boolean[] grid;

   public Percolation(int N){ //constructor
      
      grid = new boolean[N];
   }
            
      


//  don't catch
//  if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");





/*
   public void open(int i, int j);          // open site (row i, column j) if it is not open already
   public boolean isOpen(int i, int j);     // is site (row i, column j) open?
   public boolean isFull(int i, int j);     // is site (row i, column j) full?
   public boolean percolates();             // does the system percolate?
*/
   public static void main(String[] args){
      
      Percolation perc = new Percolation(Integer.parseInt(args[0]));
      
      System.out.println("your Percolation grid is size: " + perc.grid.length);
      System.out.println("contents of perc.grid[]");
      
      for(int i = 0; i < perc.grid.length; i++) System.out.print("" + perc.grid[i] + "\t");
      System.out.println("");
      
   }

}
