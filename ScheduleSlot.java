/** @author Evangeline Chandran 
  * EECS 132 
  * Scheduled time for the job 
  **/ 

public class ScheduleSlot { 
  
  private Job job; 
  int startTime; 
  
  /* 
   * @param job job in scheduled slot 
   * @param startTime starting time of job 
   */ 
  public ScheduleSlot(Job job, int startTime) { 
    this.job = job; 
    this.startTime = startTime; 
  }
  
  /* 
   * @return job job in scheduled slot 
   */ 
  public Job getJob() { 
    return job; 
  } 
  
  /* 
   * @param job job to be scheduled 
   */ 
  public void setJob(Job job) { 
    this.job = job; 
  } 
  
  /* 
   * @return startTime starting time of job 
   */ 
  public int getStartTime() { 
    return startTime; 
  } 
  
  /* 
   * @param startTime starting time to be scheduled of job 
   */ 
  public void setStartTime(int startTime) { 
    this.startTime = startTime; 
  } 
  
} 