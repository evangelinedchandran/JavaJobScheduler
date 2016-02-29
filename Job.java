/** @author Evangeline Chandran 
  * EECS 132 
  * Creates a new job 
  **/ 

import java.lang.Comparable; 

public class Job implements Comparable<Job> { 
  
  //identifies the job 
  protected int id; 
  //earliest time at which job may be started 
  protected int earliestStart;
  //latest time at which job must be complete 
  protected int deadline; 
  //length of time it takes to complete job 
  protected int duration; 
  //amount of profit earned if job is completed 
  protected int profit; 
  
  /** @param id identifies the job 
    * @param earliestStart earliest time at which job may be started 
    * @param deadline time at which job must be complete 
    * @param duration length of time it takes to complete job 
    * @param profit amount of profit earned if job is complete 
    * */ 
  public Job(int id, int earliestStart, int deadline, int duration, int profit) { 
    this.id = id; 
    this.earliestStart = earliestStart; 
    this.deadline = deadline; 
    this.duration = duration; 
    this.profit = profit; 
  } 
  
  /** 
   * @return returns id 
   * */ 
  public int getID() { 
    return id; 
  }
  
  /** 
   * @param id identifies the job 
   * */ 
  public void setID(int id) { 
    this.id = id; 
  }
  
  /** 
   * @return returns earliestStart 
   * */ 
  public int getEarliestStart() { 
    return earliestStart; 
  } 
  
  /** 
   * @param earliestStart earliest time at which job may be started 
   * */ 
  public void setEarliestStart(int earliestStart) { 
    this.earliestStart = earliestStart; 
  } 
  
  /** 
   * @return returns deadline 
   * */ 
  public int getDeadline() { 
    return deadline; 
  } 
  
  /** 
   * @param deadline time at which job must be complete 
   * */ 
  public void setDeadline(int deadline) { 
    this.deadline = deadline; 
  } 
  
  /** 
   * @return returns duration 
   * */ 
  public int getDuration() { 
    return duration; 
  } 
  
  /** 
   * @param duration length of time it takes to complete job 
   * */ 
  public void setDuration(int duration) { 
    this.duration = duration; 
  } 
  
  /** 
   * @return returns profit 
   * */ 
  public int getProfit() { 
    return profit; 
  } 
  
  /** 
   * @param profit amount of profit earned if job is complete 
   * */ 
  public void setProfit(int profit) { 
    this.profit = profit; 
  } 
  
  /** 
   * @return returns true if jobs are equal 
   * @param job job to be compared 
   * */ 
  public boolean equals(Object job) { 
    Job inputJob = (Job)job; 
    if (inputJob.getEarliestStart() == this.earliestStart && inputJob.getDeadline() == this.deadline && 
        inputJob.getDuration() == this.duration && inputJob.getProfit() == this.profit) { 
      return true; 
    }
    return false; 
  }
  
  /** 
   * @param job job to be compared 
   * @return int compares ID's 
   * */ 
  public int compareTo(Job job) { 
    return Integer.compare(this.id, job.getID()); 
  }
  
  /** 
   * @return JobProfitComparator compares job profits 
   * */ 
  public static JobProfitComparator getProfitComparator() { 
    return new JobProfitComparator(); 
  }
  
  /** 
   * @return JobStartComparator compares job earliest start  
   * */ 
  public static JobStartComparator getStartComparator() { 
    return new JobStartComparator(); 
  }
  
  /* 
   * @return string of all parameters 
   */ 
  public String toString() {
    return "\nId:" + getID() + "  EarliestStart:" + getEarliestStart() + "  Deadline:" + getDeadline() + " Duration: " + getDuration() + " Profit:" + getProfit();
  }
}