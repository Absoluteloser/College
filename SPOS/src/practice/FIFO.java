/**
 * This class implements the FIFO (First-In-First-Out) page replacement algorithm.
 * It reads the number of frames and the reference string from the user, simulates
 * the FIFO page replacement process, and displays the memory layout after each reference.
 * It also calculates and displays the total number of hits, hit ratio, and total number of misses.
 * 
 * The FIFO algorithm works by replacing the oldest page in memory with the new page when a page fault occurs.
 * 
 * The program performs the following steps:
 * 1. Reads the number of frames and the length of the reference string from the user.
 * 2. Initializes the buffer (frames) and memory layout.
 * 3. Reads the reference string from the user.
 * 4. Simulates the FIFO page replacement process:
 *    - Checks if the current reference is already in the buffer (hit).
 *    - If not, replaces the oldest page in the buffer with the new reference (miss).
 *    - Updates the memory layout after each reference.
 * 5. Displays the memory layout after processing all references.
 * 6. Displays the total number of hits, hit ratio, and total number of misses.
 * 
 * Note: The buffer is initialized with -1 to indicate empty frames.
 * 
 * @throws IOException if an I/O error occurs while reading input from the user.
 */
import PageReplacement;
package practice;

import java.util.*;
import java.io.*;

public class FIFO {
    public static void main(String[] args) throws IOException {
        int numberOfFrames;
        int numberOfReferences;
        int buffer[];
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
                System.out.printf("%3d",memoryLayout[i][j]);
            }
            System.out.println();
        }

        // Display hits and misses
        System.out.println("\nTotal Hits: " + hits);
        System.out.println("\nHit ratio: " + (float) hits / numberOfReferences);
        System.out.println("\nTotal Misses: " + misses);
    }
}