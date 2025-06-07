// Ryan Monnier
// CSD-420
// 07-June-2025
// Mod 2 Reader

import java.io.BufferedReader; // this time we import BufferedReader to read the file
import java.io.FileReader;
import java.io.IOException;

public class DataRead {
    public static void main(String[] args) {

        // declaring our variable, the name of the file created in the DataWrite class
        String filename = "monnier-datafile.dat";

        try {
            // Using BufferedReader to read the file line by line
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            // providing user with some context!
            System.out.println("Contents of " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
