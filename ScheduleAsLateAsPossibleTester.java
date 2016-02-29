import static org.junit.Assert.*; 
import org.junit.Before; 
import org.junit.Test; 

public class ScheduleAsLateAsPossibleTester { 
  
  /* 
   * Tests that both jobs are added, and job2 is first to be completed 
   */ 
  @Test 
  public void testScenario1() { 
    Job job1 = new Job(1, 2, 10, 4, 100); 
    Job job2 = new Job(2, 1, 5, 2, 50); 
    Schedule schedule1 = new Schedule(); 
    ScheduleAsLateAsPossible scheduleAsLateAsPossible1 = new ScheduleAsLateAsPossible(); 
    scheduleAsLateAsPossible1.scheduleJob(schedule1, job1); 
    scheduleAsLateAsPossible1.scheduleJob(schedule1, job2); 
    schedule1.printSchedule(); 
    assert(schedule1.getScheduledJobs().getFront().getElement().getJob().getID() == 2); 
    assert(schedule1.getProfit() == 150); 
  }
  
  /* 
   * Tests that all three jobs are added, and job2 is first to be completed
   */ 
  @Test 
  public void testScenario2() { 
    Job job1 = new Job(1, 2, 10, 4, 100); 
    Job job2 = new Job(2, 1, 5, 2, 50); 
    Job job3 = new Job(3, 10, 15, 2, 30); 
    Schedule schedule1 = new Schedule(); 
    ScheduleAsLateAsPossible scheduleAsLateAsPossible1 = new ScheduleAsLateAsPossible(); 
    scheduleAsLateAsPossible1.scheduleJob(schedule1, job1); 
    scheduleAsLateAsPossible1.scheduleJob(schedule1, job2); 
    scheduleAsLateAsPossible1.scheduleJob(schedule1, job3); 
    schedule1.printSchedule(); 
    assert(schedule1.getScheduledJobs().getFront().getElement().getJob().getID() == 2); 
    assert(schedule1.getScheduledJobs().getBack().getElement().getJob().getID() == 1); 
    assert(schedule1.getProfit() == 180); 
  }
}