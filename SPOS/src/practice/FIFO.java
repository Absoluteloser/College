package PageReplacement;

import java.util.*;
import java.io.*;

public class FIFO {
    public static void main(String[] args) throws IOException {
        int numberOfFrames;
        int numberOfReferences;
        int buffer[];a
        int references[];
        int memoryLayout[][];
        int misses = 0;
        int hits = 0;
        int pointer = 0;

        // Initialize BufferedReader to read input from the user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Prompt and read the number of frames
        System.out.println("Enter the number of frames:");
        numberOfFrames = Integer.parseInt(br.readLine());

        // Prompt and read the length of the reference string
        System.out.println("Enter the length of reference string:");
        numberOfReferences = Integer.parseInt(br.readLine());

        // Initialize arrays based on user input
        buffer = new int[numberOfFrames];
        references = new int[numberOfReferences];
        memoryLayout = new int[numberOfReferences][numberOfFrames];

        // Initialize all frames in the buffer to -1 indicating they are empty
        for (int i = 0; i < numberOfFrames; ++i) {
            buffer[i] = -1;
        }

        // Prompt and read the reference string from the user
        System.out.println("Enter the reference string:");
        for (int i = 0; i < numberOfReferences; ++i) {
            references[i] = Integer.parseInt(br.readLine());
        }

        // Traverse through the reference string
        for (int i = 0; i < numberOfReferences; ++i) {
            int searchIdx = -1;

            // Check if the current reference is already in the buffer (hit)
            for (int j = 0; j < numberOfFrames; ++j) {
                if (references[i] == buffer[j]) {
                    searchIdx = j;
                    hits++;
                    break;
                }
            }

            // If not found in buffer (miss), add it using FIFO policy
            if (searchIdx == -1) {
                buffer[pointer] = references[i];
                misses++; 
                pointer++;

                // Reset pointer if it reaches the number of frames
                if (pointer == numberOfFrames) {
                    pointer = 0;
                    //this to show the cyclic behaviour
                }
            }

            // Update the memory layout for the current reference
            for (int j = 0; j < numberOfFrames; ++j) {
                memoryLayout[i][j] = buffer[j];
            }
        }

        // Display the memory layout
        System.out.println("\nMemory Layout:");
        for(int i=0;i<numberOfReferences;++i){
            for(int j=0;j<numberOfFrames;++j){
                System.out.println("%3d",memoryLayout[i][j]);
            }
            System.out.println();
        }

        // Display hits and misses
        System.out.println("\nTotal Hits: " + hits);
        System.out.println("\nHit ratio: " + (float) hits / numberOfReferences);
        System.out.println("\nTotal Misses: " + misses);
    }
}