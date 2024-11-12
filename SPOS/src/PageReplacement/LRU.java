import PageReplacement;
import java.util.*;
import java.io.*;
public class LRU{
    public static void main(String[]args)throws IOException{
        int frames;
        int hits=0;
        int faults=0;
        int ref_len;
        BufferedReader br=new BUfferedReader(new InputStreamReader(System.in));
        Stack<Integer>frameStack=new Stack<>();
        int buffer[];
        int references[];
        int memorylayout[][];
        System.out.println("enter the number of frames");
        frames=Integer.parseInt(br.readLine());
        System.out.println("enter the number of references");
        ref_len=Integer.parseInt(br.readLine());
        buffer=new int[frames];
        references=new int[ref_len];
        memorylayout=new int[ref_len][frames];
        System.out.println("Please enter the reference string");
        for(int i=0;i<ref_len;++i){
            referenceString[i]=Integer.parseInt(br.readline());
        }
        //LRU algorithm implementation using stack
        for(int i=0;i<ref_len;++i){
            int currentPage=referenceString[i];
            if(frameStack.contains(currentPage)){
                //found
                frameStack.remove((Integer)currentPage);
                //readd as the most currentpage
                frameStack.push(currentPage);
                hits++;
            }
            //not found
            else{
                if(frameStack.size()==numberOfFrames){
                //added this dont know why ???????? will see later
                frameStack.remove(0);
            }
            frameStack.push(currentPage);
            faults++;
            }
        }
        for(int j=0;j<frames;++j){
            memorylayout[i][j]=(j<frameStack.size())?frameStack.get(j):-1;
        }
        System.out.println("\nMemory Layout");
        for(int i=0;i<frames;++i){
            for(int j=0;j<ref_len;++j){
                System.out.println("%3d",memorylayout[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nThe number of hits"+hits);
        System.out.println("\nThe number of misses"+faults);
        System.out.println("hit ratio"+((float)hits/ref_len));
    }
}