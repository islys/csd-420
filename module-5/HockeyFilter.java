// Ryan Monnier
// CSD 420 - Module 5
// 22-June-2025

import java.io.*;
import java.util.*;

public class HockeyFilter {
    public static void main(String[] args) {
        // using TreeSet makes removing duplicates and ordering trivial
        Set<String> wordSet = new TreeSet<>(); 

        // i don't think that i have used BufferedReader before I don't think, 
        // but it seems to be better for reading text files line by line
        // when compared to the Scanner class
        try (BufferedReader reader = new BufferedReader(new FileReader("collection_of_words.txt"))) {
            String line;
            // reads each line from the file, until it reaches 'null'
            // which is the end of the file

            while ((line = reader.readLine()) != null) {
                // get rid of dead space with .trim(), i added a couple of spaces for funsies
                // this also removes any empty lines, which i also included
                if (!line.trim().isEmpty()) {
                    wordSet.add(line.trim());
                }
            }
        // catch errors like file not found 
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
        // thanks to TreeSet, all we need to do is print to unique+ascending
        System.out.println("Unique set of hockey terms / player names in ascending order:");
        for (String word : wordSet) {
            System.out.println(word);
        }
        // and then we can reverse the set to print in descending order
        System.out.println("\nUnique set of hockey terms / player names in descending order:");
        List<String> reversed = new ArrayList<>(wordSet);
        // Collections.reverse() is a static method that reverses the order of the list
        Collections.reverse(reversed);
        for (String word : reversed) {
            System.out.println(word);
        }
    }
}


/* So after finishing this and talking with my wife about what she did,
 * it occured to me that there are a couple ways to go about doing this.
 * I went about this by assuming we'd be using a collection of words that
 * were ordered line by line, and indeed some of my 'words' were in fact two
 * words, or a first and last name. If the goal were to dissect a paragraph
 * or a sentence, then I would have used a different approach. I think a good
 * tactic would be to split each line into words using regex, and then you could 
 * do something very similar to what I did here, again using a TreeSet to make the
 * sorting super easy. 
 */