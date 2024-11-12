package Scheduling.FCFS;
import java.util.*;
import java.io.*;

class Process{
    String id;
    int arrival_time;
    int burst_time;
    int completion_time;
    int turn_around_time;
    int waiting_time;
    Process() {}
    Process(String pid,int ar,int br){
        id=pid;
        arrival_time=ar;
        burst_time=br;
    }
}
public class SchedulingFCFS{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of processes:");
        int n=sc.nextInt();
        //n holds number of processes.

        Process[]process_queue=new Process[n];
        Process temp=new Process();
        String pid;
        int ar,br;
        float avgwt=0,avgtat=0;

        for(int i=0;i<n;++i){
            System.out.print("enter process id,arrival time and burst time");
            pid=sc.next();
            ar=sc.nextInt();
            br=sc.nextInt();
            process_queue[i]=new Process(pid,ar,br);
        }
        Arrays.sort(process_queue,Comparator.comparingInt(p->p.arrival_time));
        for(int i=0;i<n;++i){
            if(i==0){
                process_queue[i].completion_time=process_queue[i].arrival_time+process_queue[i].burst_time;
            }
            else{
                process_queue[i].completion_time=Math.max(process_queue[i].arrival_time,process_queue[i-1].completion_time)+process_queue[i].burst_time;
            }
            //Calculate turn around time and waiting time 
            process_queue[i].turn_around_time=process_queue[i].completion_time-process_queue[i].arrival_time;
            process_queue[i].waiting_time=process_queue[i].turn_around_time-process_queue[i].burst_time;

            //accumulating waiting time and turnaround time
            avgwt+=process_queue[i].waiting_time;
            avgtat+=process_queue[i].turn_around_time;
        }
        System.out.println("---------------------------------");
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        System.out.println("----------------------------------");

        for(int i=0;i<n;++i){
            System.out.printf("%s\t\t%d\t\t%d\t\t%d\t\t\t%d\t\t\t%d\n",
                process_queue[i].id,
                process_queue[i].arrival_time,
                process_queue[i].burst_time,
                process_queue[i].completion_time,
                process_queue[i].turn_around_time,
                process_queue[i].waiting_time
                );
        }
        System.out.println("------------------------------");
        System.out.println("Average waiting time",(avgwt/n));
        System.out.println("Average turn around time",(avgtat/n));
    }
}
/*
Start
  |
  v
Input Number of Processes (n)
  |
  v
For each process (1 to n):
  - Input Process ID, Arrival Time, Burst Time
  |
  v
Sort Processes by Arrival Time using Comparable
  |
  v
Initialize:
  - Completion Time
  - Turnaround TimeStart
  |
  v
Input Number of Processes (n)
  |
  v
For each process (1 to n):
  - Input Process ID, Arrival Time, Burst Time
  |
  v
Sort Processes by Arrival Time using Comparable
  |
  v
Initialize:
  - Completion Time
  - Turnaround Time
  - Waiting Time
  - Accumulate total waiting and turnaround times
  |
  v
Calculate for each process:
  - Completion Time
  - Turnaround Time
  - Waiting Time
  |
  v
Display Process Table
  |
  v
Calculate and Display Averages
  |
  v
End
  - Waiting Time
  - Accumulate total waiting and turnaround times
  |
  v
Calculate for each process:
  - Completion Time
  - Turnaround Time
  - Waiting Time
  |
  v
Display Process Table
  |
  v
Calculate and Display Averages
  |
  v
End
*/