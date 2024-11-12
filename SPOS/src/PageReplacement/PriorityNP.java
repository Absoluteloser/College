package Schedule.PriorityNP;
import java.util.*;
import java.io.*;
class Process{
    String id;
    int arrival_time;
    int completion_time;
    int burst_time;
    int waiting_time;
    int turn_around_time;
    int priority;
    boolean isCompleted;
    Process(String id,int at,int bt,int pr){
        id=id;
        arrival_time=ar;
        burst_time=br;
        priority=pr;
    }
}
public class PriorityNP{
    public static void main(String[]args){
        //n ->number of processes
        int n,at,bt,pr,completed=0,current_time=0;
        float avgwt=0,avgtat=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of processes");
        n=sc.nextInt();
        Process[]p_queue=new Process[n];
        //create such n processes
        Process currentprocess;
        for(int i=0;i<n;++i){
            System.out.print("enter the process for"+(i+1));
            id=sc.nextInt();
            System.out.print("enter the arrival time:");
            at=sc.nextInt();
            System.out.print("enter the burst time:");
            bt=sc.nextInt();
            System.out.print("enter priority:");
            pr=sc.nextInt();
            p_queue[i]=new Process(id,at,bt,pr);
        }
        while(completed<n){
            prior=Integer.MAX_VALUE;
            currentprocess=null;
            for(Process p:p_queue){
                if(!p.completed&&p.arrival_time<current_time&&p.priority<prior){
                    prior=p.priority;
                    currentprocess=p;
                }
            }
            if(currentprocess!=null){
                //csb tca wtb 
                //completion time=start time-burst time
                //turnaround time=completion time-arrival time
                //waiting time=turnaround time-burst time
                currentprocess.completion_time=currentprocess.arrival_time+currentprocess.burst_time;
                currentprocess.turn_around_time=currentprocess.completion_time-currentprocess.arrival_time;
                currentprocess.waiting_time=currentprocess.turn_around_time-currentprocess.burst_time;
                avgtat+=currentprocess.turn_around_time;
                avgwt+=currentprocess.waiting_time;
                currentprocess.isCompleted=true;
                completed++;
                current_time=currentprocess.completion_time;
            }
            else{
                current_time++;
            }
        }
        avgtat/=n;
        avgwt/=n;
        System.out.println("===================");
        System.out.println("Process\t\tArrival Time\tBurst Time\tCompletion Time\tTurnAround Time\tWaiting Time");
        for(int i=0;i<n;++i){
            System.out.println(" "+p_queue[i].id+"\t\t\t"+
                                p_queue[i].arrival_time+"\t\t\t"+
                                p_queue[i].burst_time+"\t\t\t"+
                                p_queue[i].completion_time+"\t\t\t"+
                                p_queue[i].turn_around_time+"\t\t\t"+
                                p_queue[i].waiting_time+"\t\t\t"
            );
        }
        System.out.println("-----------------------");
        System.out.println("Average TAT :"+avg_tat);
        System.out.println("Average WT :"+avg_wt);
        sc.close();
    }
}