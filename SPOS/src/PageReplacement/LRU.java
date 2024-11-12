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
        Boolean isFull=false;
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
    }
}