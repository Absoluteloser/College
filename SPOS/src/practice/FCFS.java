package practice;
import java.util.*;
import java.io.*;

class Process{
    String processid;
    int completiontime;
    int starttime;
    int bursttime;
    int turnaroundtime;
    int waitingtime;
    Process() {}
    //constructor with id,arrival and burst.
    Process(String id,int arrival,int burst){
        processid=id;
        starttime=arrival;
        bursttime=burst;
    }
}
//trick :csb tca wtb
public class FCFS{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of processes:");
        int numberofprocesses=sc.nextInt();

        //creating such n processes
        Process process_queue[]=new Process[numberofprocesses];
        String id;
        int arrival,burst;
        float avgwaiting=0;
        float avgturnaround=0;

        //take the input values for n processes.
        for(int i=0;i<numberofprocesses;++i){
            System.out.println("enter the arrival,burst and process id:");
            arrival=sc.nextInt();
            burst=sc.nextInt();
            id=sc.next();
            process_queue[i]=new Process(id,arrival,burst);
        }
        Arrays.sort(process_queue,Comparator.comparingInt(p->p.starttime));
        for(int i=0;i<numberofprocesses;++i){
            if(i==0){
                process_queue[i].completiontime=process_queue[i].starttime+process_queue[i].bursttime;
            }
            else{
                process_queue[i].completiontime=Math.max(process_queue[i].starttime,process_queue[i-1].completiontime)+process_queue[i].bursttime;
            }
            process_queue[i].turnaroundtime=process_queue[i].completiontime-process_queue[i].starttime;
            process_queue[i].waitingtime=process_queue[i].turnaroundtime-process_queue[i].bursttime;

            //accumulating the result
            avgwaiting+=process_queue[i].waitingtime;
            avgturnaround+=process_queue[i].turnaroundtime;
        }
        //out of the Loop
        System.out.println("---------------------------------");
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        System.out.println("----------------------------------");
        //displaying for n items all values 
        for(int i=0;i<numberofprocesses;++i){
            System.out.println(process_queue[i].processid + "\t\t" + 
                               process_queue[i].arrivaltime + "\t\t" + 
                               process_queue[i].bursttime + "\t\t" + 
                               process_queue[i].completiontime + "\t\t\t" + 
                               process_queue[i].turnaroundtime + "\t\t\t" + 
                               process_queue[i].waitingtime);
        }
        System.out.println("------------------------------");
        System.out.println("Average waiting time: " + (avgwaiting / numberofprocesses));
        System.out.println("Average turnaround time: " + (avgturnaround / numberofprocesses));
        sc.close();
    }
}