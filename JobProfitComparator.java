/** @author Evangeline Chandran 
  * EECS 132 
  * Compares profit of two jobs 
  **/ 

import java.util.Comparator; 

public class JobProfitComparator implements Comparator<Job> { 
  
  /** 
   * @param job1 first job to be compared 
   * @param job2 second job to be compared 
   * */ 
  public int compare(Job job1, Job job2) { 
    return Integer.compare(job1.getProfit(), job2.getProfit()); 
  }
  
} 