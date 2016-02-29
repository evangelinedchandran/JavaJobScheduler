/** @author Evangeline Chandran 
  * EECS 132 
  * Schedules a job as early as possible 
  **/ 

public class ScheduleAsEarlyAsPossible implements ScheduleMetric { 
  
  /* @param schedule schedule of jobs 
   * @param job job to be scheduled 
   */ 
  public boolean scheduleJob(Schedule schedule, Job job) {
    
    DoubleLinkedList<ScheduleSlot> listOfJobs = schedule.getScheduledJobs();
    ScheduleSlot scheduledJob;
    if (listOfJobs.isEmpty()) {
      scheduledJob = new ScheduleSlot(job, job.getEarliestStart());
      listOfJobs.add(scheduledJob);
      return true;
    }
    
    
    //iterate from start of the list to see if this job can be scheduled before the rest
    int previousJobFinishTime = 0;
    for (ScheduleSlot scheduledjob: listOfJobs) {
      
      Job currentJob = scheduledjob.getJob();
      
      //cannot start at the earliest start as the previous job takes longer to finish
      if (job.getEarliestStart() <= previousJobFinishTime) {
        //can it be scheduled?
        if ( previousJobFinishTime + job.getDuration() > job.getDeadline()) {
          return false; // cannot be scheduled as the previous job with greater profit takes longer
        }
      }
      
      //set the earliest possible start time based on when the previous job finished
      int newJobEarliestStart = previousJobFinishTime;
      if ( job.getEarliestStart() > previousJobFinishTime) {
        newJobEarliestStart = job.getEarliestStart();
      }
      
      int endTimeNewJob = newJobEarliestStart + job.getDuration();
      
      if (newJobEarliestStart <= scheduledjob.getStartTime()) { //has an earlier start time
        if (endTimeNewJob < scheduledjob.getStartTime()) { //no overlap
          listOfJobs.add(new ScheduleSlot(job, newJobEarliestStart));
          return true;
        }
        else { //overlap
          if (endTimeNewJob + currentJob.getDuration() < currentJob.getDeadline()) { //can we move current job
            scheduledjob.setStartTime(endTimeNewJob);
            listOfJobs.add(new ScheduleSlot(job, newJobEarliestStart));
            return true;
          }
        }
      }
      else {
        int durationNewJob = scheduledjob.getStartTime() + job.getDuration();
        
        if (durationNewJob + currentJob.getDuration() < currentJob.getDeadline()) { //can we move current job
          scheduledjob.setStartTime(durationNewJob);
          listOfJobs.add(new ScheduleSlot(job, job.getEarliestStart()));
          return true;
        }
      }
      previousJobFinishTime = currentJob.getDuration() + scheduledjob.getStartTime();
    }
    
    //can we add as last job
    ScheduleSlot lastScheduledjob = listOfJobs.getBack().getElement();
    int timeToCompleteLastJob = lastScheduledjob.getStartTime() + lastScheduledjob.getJob().getDuration();
    
    if (job.getEarliestStart() >=  timeToCompleteLastJob ) //can we add as last job
    {
      listOfJobs.addToBack(new ScheduleSlot(job, job.getEarliestStart()));
      return true;
    }
    return false;
  }
}