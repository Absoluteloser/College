import PageReplacement;
package practice;

import java.util.*;
import java.io.*;

public class LRU{
    public static void main(String[] args)throws IOException{
        int frames;
        int reflength;
        int buffer[];
        int refs[];
        int memorylayout[][];
        int hits=0;
        int misses=0;
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer>ReferenceStack=new Stack<>();

        System.out.println("enter the number of frames in buffer");
        frames=Integer.parseInt(br.readLine());
        System.out.println("enter the number of references in buffer");
        reflength=Integer.parseInt(br.readLine());

        buffer=new int[frames];
        refs=new int[reflength];
        memorylayout=new int[reflength][frames];
        System.out.println("enter the reference string:");
        for(int i=0;i<reflength;++i){
            refs[i]=Integer.parseInt(br.readLine());
        }

        //LRU implementation using stack
        for(int i=0;i<reflength;++i){
            int current=refs[i];
            if(ReferenceStack.contains(current)){
                ReferenceStack.remove((Integer)(current));
                ReferenceStack.push(current);
                //fount in stack
                hits++;
            }
            else{
                if(ReferenceStack.size()==frames){
                    ReferenceStack.remove(0);
                }
                ReferenceStack.push(current);
                misses++;
            }
            for(int j=0;j<frames;++j){
                memorylayout[i][j]=(j<ReferenceStack.size())?ReferenceStack.get(j):-1;
            }
            System.out.println("the 2d memory layout is:");
            for(int i=0;i<frames;++i){
                for(int j=0;j<reflength;++j){
                    System.out.printf("%3d",memorylayout[i][j]);
                }
                System.out.println();
            }
            System.out.println("number of hits"+hits);
            System.out.println("number of misses"+misses);
            System.out.println("hit ratio"+((float)hits/reflength));
        }
    }
}
