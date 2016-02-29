import java.util.Arrays; 
import java.io.File; 
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.LinkedList; 
import java.util.Scanner; 
import java.util.Comparator; 
import java.util.Collections; 

public class JobScheduler { 
  
  public static void main(String[] args) { 
    try { 
      /* 
       * "c" creates a job 
       * "s" schedules
       * How to create: "java JobScheduler c job1.txt" 
       * How to schedule: "java JobScheduler s job1.txt"
       */ 
      if (args.length == 2) { 
        if (args[0].equalsIgnoreCase("c")) { 
          createJobFile(args[1], createRandomJobs(5, 10, 3, 5, 20)); 
        }
        else if (args[0].equalsIgnoreCase("s")) { 
          File jobfile = new File(args[1]); 
          LinkedList<Job> joblist = new LinkedList<Job>(); 
          int[] jobsdata = new int[5]; 
          Scanner filescanner = new Scanner(jobfile); 
          int index = 0; 
          while (filescanner.hasNextInt()) { 
            jobsdata[index++] = filescanner.nextInt(); 
            if (index == 5) { 
              index = 0; 
              Job job2 = new Job(jobsdata[0], jobsdata[1], jobsdata[2], jobsdata[3], jobsdata[4]); 
              joblist.add(job2); 
            }
          }
          filescanner.close(); 
          
          Schedule schedule1 = scheduleJobs(joblist, Job.getProfitComparator(), new ScheduleAsEarlyAsPossible()); 
          Schedule schedule2 = scheduleJobs(joblist, Job.getProfitComparator(), new ScheduleAsLateAsPossible()); 
          System.out.println("\nScheduleAsEarlyAsPossible output: \n"); 
          schedule1.printSchedule(); 
          System.out.println("\nScheduleAsLateAsPossible output: \n"); 
          schedule2.printSchedule(); 
          
          int profit1 = schedule1.getProfit(); 
          System.out.println("\nScheduleAsEarlyAsPossible profit: \n" + profit1); 
          int profit2 = schedule2.getProfit(); 
          System.out.println("\nScheduleAsLateAsPossible profit: \n" + profit2); 
          
          if (profit1 > profit2) { 
            System.out.println("ScheduleAsEarlyAsPossible profit is greater."); 
          }
          else if (profit1 < profit2) { 
            System.out.println("ScheduleAsLateAsPossible profit is greater."); 
          } 
          else { 
            System.out.println("The profits are equal."); 
          }
        }
      }
      else { 
        System.out.println("Please provide two arguments. [s or c] to schedule or create file name."); 
      }
    }
    catch(Exception e) { 
      e.printStackTrace(); 
    }
  }
  
  /**
   * Creates a file with random job data, based on the parameters given.  The job data will be 
   * sorted by earliest start time.
   * @param numJobs   the number of jobs to create
   * @param maxStart  the latest time at which a job may set as its earliest start time
   * @param maxDuration  the maximum time that a job can take to complete
   * @param maxLag   the greatest time between the earliest start time for a job and the latest time that a job must start to meet its deadline
   * @param maxProfic  the maximum amount of profit from a job
   * @return an array containing the random jobs
   */
  public static Job[] createRandomJobs(int numJobs, int maxStart, int maxDuration, int maxLag, int maxProfit) {
    Job[] jobs = new Job[numJobs];
    
    // For each desired job, create 4 random numbers based on the parameters, use the numbers to create a job,
    // and store the job in an array.
    for (int i = 0; i < numJobs; i++) {
      int start = (int)(Math.random() * maxStart) + 1;
      int duration = (int)(Math.random() * maxDuration) + 1;
      int deadline = start + duration + (int)(Math.random() * (maxLag + 1));
      int profit = (int)(Math.random() * maxProfit) + 1;
      jobs[i] = new Job(i, start, deadline, duration, profit); 
    }
    
    // Sort the jobs by earliest start time
    Arrays.sort(jobs, Job.getStartComparator());
    
    return jobs;
  }
  
  /**
   * Creates a file with job data.
   * @param fileName  the name of the file to store the job data.  The file must not exist.
   * @param jobs an array containing the jobs
   */
  public static void createJobFile(String fileName, Job[] jobs) {
    // Check that the output file does not already exist
    File file = new File(fileName);
    if (file.exists()) {
      System.out.println("Error: file " + fileName + " already exists.");
      return;
    }
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      
      // For each job in the array, write the job to the file as 5 numbers separated by spaces.
      // Place an each job on a new line.
      for (int i = 0; i < jobs.length; i++) {
        String s = i + " " + jobs[i].getEarliestStart() + " " + jobs[i].getDeadline() + " " + jobs[i].getDuration() + " " + jobs[i].getProfit();
        writer.write(s, 0, s.length());
        writer.newLine();
      }
      writer.flush();
      writer.close();
    }
    catch (IOException e) {
      System.out.println("Error writing to file " + fileName);
    }
  }
  
  private static Schedule scheduleJobs(LinkedList<Job> jobs, Comparator<Job> jobComparator, ScheduleMetric scheduleMetric)
  {
    Schedule schedule = new Schedule();
    
    //sort jobs using comparator
    Collections.sort(jobs, jobComparator);
    
    System.out.println("\nJobs from file ordered by profit: \n" + jobs);
    
    for(Job job: jobs) 
    {
      scheduleMetric.scheduleJob(schedule, job);
    }
    
    
    return schedule;
  }
  
} 