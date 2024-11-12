import PageReplacement;
import java.util.*;
import java.io.*;
public class FIFO{
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //first variable initialization
        int frames;
        int ref_len;
        int hits=0;
        int faults=0;
        int buffer[];
        int references[];
        int memorylayout[][];
        System.out.println("enter the number of frames");
        frames=Integer.parseInt(br.readline());
        System.out.println("enter the length of refernce string");
        ref_len=Integer.parseInt(br.readline());
        buffer=new int[frames];
        references=new int[ref_len];
        memorylayout=new int[ref_len][frames];
        for(int i=0;i<frames;++i){
            buffer[i]=-1;
        }
        
    }
}