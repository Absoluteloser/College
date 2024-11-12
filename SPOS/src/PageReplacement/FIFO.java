package PageReplacement;
import java.io.*;
public class FIFO{
    public static void main(String[]args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int frames,pointer=0,hit=0,fault=0,ref_len;
        int buffer[];
        int reference[];
        int mem_layout[][];
        System.out.println("enter the number of framesa");
        frames=Integer.ParseInt(br.readLine());
        System.out.println("enter the length of reference string");
        ref_len=Integer.parseInt(br.readLine());
    }
}