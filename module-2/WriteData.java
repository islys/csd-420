import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String filename = "Ryan_datafile.dat"; 
        Random rand = new Random();

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Fill arrays with random values
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // random int from 0 to 99
            doubleArray[i] = rand.nextDouble() * 100; // random double from 0.0 to 99.999...
        }

        try (FileWriter writer = new FileWriter(filename, true)) { // true enables appending
            writer.write("Integers: ");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.write("\nDoubles: ");
            for (double d : doubleArray) {
                writer.write(String.format("%.2f ", d)); // formatted to 2 decimal places
            }
            writer.write("\n\n"); // Separate entries
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
