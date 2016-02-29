import static org.junit.Assert.*; 
import org.junit.Before; 
import org.junit.Test; 
import java.util.Arrays; 

public class JobTester { 
  
  /* 
   * Tests that job1 and job3 are equal 
   */ 
  @Test 
  public void testJobEquals() { 
    Job job1 = new Job(1, 8, 20, 10, 100); 
    Job job2 = new Job(2, 10, 22, 4, 50); 
    Job job3 = new Job(1, 8, 20, 10, 100); 
    boolean job12 = job1.equals(job2); 
    assert(job12 == false); 
    boolean job13 = job1.equals(job3); 
    assert(job13 == true); 
  }
  
  /* 
   * Tests that JobProfitComparator works and job2 has the lowest profit 
   */ 
  @Test 
  public void testProfitComparator() { 
    Job job1 = new Job(1, 8, 20, 10, 200); 
    Job job2 = new Job(2, 10, 22, 4, 50); 
    Job job3 = new Job(3, 12, 20, 10, 100); 
    JobProfitComparator profitComparator1 = Job.getProfitComparator(); 
    
    Job jobArray[] = {job1, job2, job3};
    Arrays.sort(jobArray, Job.getProfitComparator());
    for(Job job : jobArray) {
      System.out.println(job.toString());
    }

    assert(jobArray[0].getID() == 2); 
  }
  
  /* 
   * Tests JobStartComparator and that job1 start the earliest 
   */ 
  @Test 
  public void testStartComparator() { 
    Job job1 = new Job(1, 8, 20, 10, 200); 
    Job job2 = new Job(2, 10, 22, 4, 50); 
    Job job3 = new Job(3, 12, 20, 10, 100); 
    JobStartComparator startComparator1 = Job.getStartComparator(); 
    
    Job jobArray[] = {job1, job2, job3};
    Arrays.sort(jobArray, Job.getStartComparator());
    for(Job job : jobArray) {
      System.out.println(job.toString());
    }
    assert(jobArray[0].getID() == 1); 
  }
} 