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
        System.out.println("enter the reference string");
        for(int i=0;i<ref_len;++i){
            references[i]=Integer.parseInt(br.readLine());
        }
        System.out.println("============================================");
        //traverse through the references array
        for(int i=0;i<ref_len;++i){
            int search=-1;
            for(int j=0;j<frames;++j){
                if(buffer[j]==references[i]){
                    search=j;
                    hits++;
                    break;
                }
            }
            if(search==-1){
                buffer[pointer]=references[i];
                fault++;
                pointer++;
                if(pointer==frames){
                    pointer=0;
                }
            }
            for(int j=0;j<frames;++j){
                memorylayout[j][i]=buffer[j];
            }
        }
        for(int i=0;i<frames;++i){
            for(int j=0;j<ref_len;++j){
                System.out.println("%3d",memorylayout[i][j]);
            }
            System.out.println();
        }
        System.out.println("the number of hits"+hits);
        System.out.println("the ratio:"+(float)((float)hits/ref_len));
        System.out.println("the number of Faults"+fault);
    }
}