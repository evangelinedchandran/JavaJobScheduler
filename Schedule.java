/** @author Evangeline Chandran 
  * EECS 132 
  * List of scheduled jobs 
  **/

public class Schedule { 
  
  DoubleLinkedList<ScheduleSlot> list1 = new DoubleLinkedList<ScheduleSlot>(); 
  
  public Schedule() { 
    
  }
  
  public void printSchedule() { 
    for (ScheduleSlot slot: list1) { 
      System.out.println("Start time: " + slot.getStartTime() + slot.getJob().toString()); 
    }
  }
  
  /* 
   * @return profit 
   */ 
  public int getProfit() { 
    int totalProfit = 0; 
    
    for (ScheduleSlot slot: list1) { 
      totalProfit += slot.getJob().getProfit(); 
    }
    return totalProfit; 
  }
  
  /* 
   * @return list1 schedule list 
   */ 
  public DoubleLinkedList<ScheduleSlot> getScheduledJobs() { 
    return list1; 
  }
}