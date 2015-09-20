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
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
   private int T;
   private double[] x;
   
   public PercolationStats(int N, int T){ // perform T independent experiments on an N-by-N grid
      if(N <= 0 || T <= 0) throw new IllegalArgumentException(
            "Arguments N,T:" + N + "," + T + " must be > 0");

      this.T = T;
      x = new double[T];
      Percolation perc;
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
      return tempMean/T;
   }
   
   public double stddev(){
      double temp = 0;
      for(int i = 0; i < T; i++){
         temp += (x[i] - mean())*(x[i] - mean());
      }
      return Math.sqrt(temp/(T-1));
   }
   public double confidenceLo(){
      return (mean() - 1.96*stddev()/Math.sqrt(T));
   }
   
   public double confidenceHi(){
      return (mean() + 1.96*stddev()/Math.sqrt(T));
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

// still a memory problem, perc instance should be kept local.  fine!