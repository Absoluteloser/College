package practice;
import java.util.*;
import java.io.*;

class Process{
    String processid;
    int completiontime;
    int starttime;
    int bursttime;
    int turnaroundtime;
    int arrivaltime;
    int waitingtime;
    boolean isCompleted;
    int priority;
    Process(String pid, int at, int bt, int pr){
        processid = pid;
        arrivaltime = at;
        bursttime = bt;
        priority = pr;
        isCompleted = false;
    }
}
public class PriorityNP{
    public static void main(String[]args)throws IOException{
        int n, at, bt, pr, completed = 0, currenttime = 0;
        String pid;
        float avgwt=0,avgtat=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of processes:");
        n=sc.nextInt();
        Process priority_queue[]=new Process[n];
        //make array of processes of length n;
        Process currentprocess;
        for(int i=0;i<n;++i){
            System.out.println("enter the values of pid,at,bt,pr");
            pid=sc.next();
            at = sc.nextInt();
            bt = sc.nextInt();
            pr = sc.nextInt();
            priority_queue[i] = new Process(pid, at, bt, pr);
        }
        while(completed < n){
            int highestPriority = Integer.MAX_VALUE;
            currentprocess = null;
            for(Process p : priority_queue){
                if(!p.isCompleted && p.arrivaltime <= currenttime && p.priority < highestPriority){
                    highestPriority = p.priority;
                    currentprocess = p;
                }
            }
            if(currentprocess != null){
                //csb tca wtb
                currentprocess.starttime = currenttime;
                currentprocess.completiontime = currentprocess.starttime + currentprocess.bursttime;
                currentprocess.turnaroundtime = currentprocess.completiontime - currentprocess.arrivaltime;
                currentprocess.waitingtime = currentprocess.turnaroundtime - currentprocess.bursttime;
                avgwt += currentprocess.waitingtime;
                avgtat += currentprocess.turnaroundtime;
                currentprocess.isCompleted = true;
                completed++;
                currenttime = currentprocess.completiontime;
            }
            else{
                currenttime++;
            }
        }
        avgtat/=n;
        avgwt/=n;
        System.out.println("===================");
        System.out.println("Process\t\tArrival Time\tBurst Time\tCompletion Time\tTurnAround Time\tWaiting Time");
        for(int i=0;i<n;++i){
            System.out.println(priority_queue[i].processid + "\t\t" +
                    priority_queue[i].arrivaltime + "\t\t" +
                    priority_queue[i].bursttime + "\t\t" +
                    priority_queue[i].completiontime + "\t\t" +
                    priority_queue[i].turnaroundtime + "\t\t" +
                    priority_queue[i].waitingtime);
        }
        System.out.println("-----------------------");
        System.out.println("Average TAT :"+avgtat);
        System.out.println("Average WT :"+avgwt);
        sc.close();
    }
}