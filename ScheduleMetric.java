/* Evangeline Chandran 
 * EECS 132 
 * Takes a schedule and returns a boolean 
 */ 

public interface ScheduleMetric { 
  
  /* @param schedule1 schedule of jobs 
   * @param job1 job to be scheduled 
   */ 
  public boolean scheduleJob(Schedule schedule1, Job job1); 
  
}