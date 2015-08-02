   /****************************************************************************
 *  Compilation:  javac PercolationStats.java
 *  Execution:    java Percolation <int N> <int T>
 *  Dependencies: StdIn.java StdOut.java WeightedQuickUnionUF.java
 *                Percolation.java
 *
 *  Percolation test series of NxN grid develops estimate of probability p
 ****************************************************************************/

/**
 * API
 *  class PercolationStats
 *        PercolationStats(int N, int T)   perform T independent experiments on an N-by-N grid
 * double mean()                           sample mean of percolation threshold
 * double stddev()                         sample standard deviation of percolation threshold
 * double confidenceLo()                   low  endpoint of 95% confidence interval
 * double confidenceHi()                   high endpoint of 95% confidence interval
 * static void main(String[] args)         test client
 *
 *  private fields
 *      int N                 grid size is NxN
 *      int T                 number of Percolation trials
 * double[] x                 percentage open/total at percolation
 *   double mu                sample mean of x
 *   double sigma             standard deviation of trial percentages
 */

public class PercolationStats {
   private int N,T;
   private double[] x;
   private double mu, sigma;
   private Percolation perc;
   
   public PercolationStats(int N, int T){ // perform T independent experiments on an N-by-N grid
      if(N <= 0 || T <= 0) throw new IllegalArgumentException(
            "Arguments N,T:" + N + "," + T + " must be > 0");

      this.N = N;
      this.T = T;
      x = new double[T];
      
      int openCells;
      int iRnd = 0;
      int jRnd = 0;

      for(int i = 0; i < T; i++){
         openCells = 0;
         perc = new Percolation(N);
         while(!perc.percolates()){
            iRnd = StdRandom.uniform(N)+1;
            jRnd = StdRandom.uniform(N)+1;
            if(perc.isOpen(iRnd,jRnd)) continue;
            
            perc.open(iRnd,jRnd);
            openCells++;
         }
         x[i] = 1.0 * openCells / (N*N);
      }
   }

   public double mean(){
      double tempMean = 0;
      for(int i = 0; i < T; i++){
         tempMean += x[i];
      }
      return mu = tempMean/T;
   }
   
   public double stddev(){
      double temp = 0;
      for(int i = 0; i < T; i++){
         temp += (x[i] - mu)*(x[i] - mu);
      }
      return sigma = Math.sqrt(temp/(T-1));
   }
   public double confidenceLo(){
      return (mu - 1.96*sigma/Math.sqrt(T));
   }
   
   public double confidenceHi(){
      return (mu + 1.96*sigma/Math.sqrt(T));
   }

   public static void main(String[] args){
      
      int N = Integer.parseInt(args[0]);
      int T = Integer.parseInt(args[1]);
      
      PercolationStats ps = new PercolationStats(N,T);
      StdOut.println("mean\t\t\t= "                + ps.mean());
      StdOut.println("stddev\t\t\t= "              + ps.stddev());
      StdOut.println("95% confidence interval\t= "
               + ps.confidenceLo() + "," + ps.confidenceHi() + "\n");
   }
   
}