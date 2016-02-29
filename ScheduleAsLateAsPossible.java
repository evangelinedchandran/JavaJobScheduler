/** @author Evangeline Chandran 
  * EECS 132 
  * Schedules a job as late as possible 
  **/ 

import java.util.ListIterator; 

public class ScheduleAsLateAsPossible implements ScheduleMetric { 
  
  /* 
   * @param schedule schedule of jobs 
   * @param job job to be scheduled 
   */ 
  public boolean scheduleJob(Schedule schedule, Job job) {
    
    DoubleLinkedList<ScheduleSlot> listOfJobs = schedule.getScheduledJobs();
    ScheduleSlot scheduledJob;
    if (listOfJobs.isEmpty()) {
      scheduledJob = new ScheduleSlot(job, job.getDeadline() - job.getDuration());
      listOfJobs.add(scheduledJob);
      return true;
    }
    
    //iterate from the back of the list to schedule as late as possible
    int jobLatestStart = job.getDeadline() - job.getDuration();
    ListIterator<ScheduleSlot> listIterator = schedule.getScheduledJobs().iterator();
    
    while (listIterator.hasPrevious()) {
      ScheduleSlot currentScheduleSlot = listIterator.previous();
      int timeToCompleteCurrentJob = currentScheduleSlot.getStartTime() + currentScheduleSlot.getJob().getDuration();
      
      //job has to start after the current one
      if (jobLatestStart >= timeToCompleteCurrentJob) {
        if ( listIterator.hasNext()) {
          listIterator.next();
          listOfJobs.add(new ScheduleSlot(job, jobLatestStart));
        }
        else {
          listOfJobs.addToBack(new ScheduleSlot(job, jobLatestStart));
        }
        return true;
      }
    }
    
    
    //can we add as first job
    ScheduleSlot firstScheduledjob = listOfJobs.getFront().getElement();
    
    if (firstScheduledjob.getStartTime() - job.getDuration() > job.getEarliestStart()) { //can we add as last job
      listOfJobs.addToFront(new ScheduleSlot(job, firstScheduledjob.getStartTime() - job.getDuration()));
      return true;
    }
    return false;
  }
} 