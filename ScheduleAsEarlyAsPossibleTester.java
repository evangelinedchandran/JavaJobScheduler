import static org.junit.Assert.*; 
import org.junit.Before; 
import org.junit.Test; 

public class ScheduleAsEarlyAsPossibleTester { 
  
  /* 
   * Tests that both jobs are added, and job2 is first to be completed 
   */ 
  @Test 
  public void testScenario1() { 
    Job job1 = new Job(1, 2, 10, 4, 100); 
    Job job2 = new Job(2, 1, 5, 2, 50); 
    Schedule schedule1 = new Schedule(); 
    ScheduleAsEarlyAsPossible scheduleAsEarlyAsPossible1 = new ScheduleAsEarlyAsPossible(); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job1); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job2); 
    schedule1.printSchedule(); 
    assert(schedule1.getScheduledJobs().getFront().getElement().getJob().getID() == 2); 
    assert(schedule1.getProfit() == 150); 
  }
  
  /* 
   * Tests that all three jobs were added, and job2 is first to be completed 
   */ 
  @Test 
  public void testScenario2() { 
    Job job1 = new Job(1, 2, 10, 4, 100); 
    Job job2 = new Job(2, 1, 5, 2, 50); 
    Job job3 = new Job(3, 10, 15, 2, 30); 
    Schedule schedule1 = new Schedule(); 
    ScheduleAsEarlyAsPossible scheduleAsEarlyAsPossible1 = new ScheduleAsEarlyAsPossible(); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job1); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job2); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job3); 
    schedule1.printSchedule(); 
    assert(schedule1.getScheduledJobs().getFront().getElement().getJob().getID() == 2); 
    assert(schedule1.getProfit() == 180); 
  }
  
  /* 
   * Tests that all four jobs were added, and job4 is the first to be completed. 
   */ 
  @Test 
  public void testScenario3() { 
    Job job1 = new Job(1, 18, 20, 4, 10); 
    Job job2 = new Job(2, 16, 22, 2, 50); 
    Job job3 = new Job(3, 10, 23, 2, 30); 
    Job job4 = new Job(4, 6, 23, 10, 10); 
    Schedule schedule1 = new Schedule(); 
    ScheduleAsEarlyAsPossible scheduleAsEarlyAsPossible1 = new ScheduleAsEarlyAsPossible(); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job1); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job2); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job3); 
    scheduleAsEarlyAsPossible1.scheduleJob(schedule1, job4); 
    schedule1.printSchedule(); 
    assert(schedule1.getScheduledJobs().getFront().getElement().getJob().getID() == 4); 
  }
}