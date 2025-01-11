import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import java.util.*;

/**
 * @Tai Nghiem
 * January 10, 2025
 * Methods Priority_Test task
 */
public class Task implements Priority, Comparable
{
    private double p;
    private String task;
    private boolean complete;
   
    // default and overloaded constructor to create a task
   public Task (String task, double p)
   {
      this.task = task;
      this.p = p;
   }
   
   public Task(String task, double p, boolean complete) {
        this.task = task;
        this.p = p;
        this.complete = complete;
    }
   
   /**lockable methods----------------------------
      //  This is the section to implement interface Priority
      */
     public double getPriority (double p)
     {
          return p;
     }

     // Set priority
    public void setPriority(double p) {
        this.p = p;
    }

     // write compareTo
   
    /**  This is the section to implement interface Comparable
          // it compares the task priority numbers,
          // and if the numbers are the same, compares the tasks alphabetically.
    */
    public int compareTo (Object obj)
    {
       Task other = (Task) obj;
   
        if (this.p < other.p) {
        return -1;  // the this.task has a lower priority
       
        } else if (this.p > other.p) {
        return 1;   // the this.task has a higher priority
       
        } else {
        // if the two priorities are equal, compare the tasks alphabetically
        return this.task.compareTo(other.task);
    }
    }
   
    // toString method for printing out whether the task is complete or not and what the task is
   public String toString(){
      String result = "";
     if(this.complete == true)
        result = this.p + "   " + this.task + " is Done";
    else
        result = this.p + "   " + this.task;
    return result;

   }
}
