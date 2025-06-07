// Ryan Monnier
// CSD-420
// 07-June-2025
// Mod 2 Writer

import java.io.FileWriter; // importing FileWriter to write to files
import java.io.IOException;
import java.util.Random;



public class DataWrite {
    public static void main(String[] args) {

        // initialize our variables
        Random rand = new Random();
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];
        String filename = "monnier-datafile.dat"; 

        // for loop that iterates 5 times to fill the arrays with random values
        for (int i=0; i<5; i++) {
            intArray[i] = rand.nextInt(100); // random int from 0 to 99
            doubleArray[i] = rand.nextDouble() * 100; // random double 0.0-99.9
        }

        // using try/catch to handle exceptions
        try {
            FileWriter writer = new FileWriter(filename, true); // true enables appending, neato
            // iterates through the intArray to write integers to the file
            writer.write("Integers: ");
            for (int i = 0; i < intArray.length; i++) {
                writer.write(intArray[i] + (i < intArray.length - 1 ? "," : ""));
            }
            writer.write("\n");

            // same iteration for the doubleArray, but formatted to 2 decimal places
            writer.write("Doubles: ");
            for (int i = 0; i < doubleArray.length; i++) {
                writer.write(String.format("%.2f", doubleArray[i]) + (i < doubleArray.length - 1 ? "," : ""));
            }
            writer.write("\n");

            writer.close();
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

