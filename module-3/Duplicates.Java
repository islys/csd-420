// Ryan Monnier
// CSD 420 - Module 3
// 12-June-2025


import java.util.ArrayList;
import java.util.Random;

public class Duplicates {

    public static void main(String[] args) {
        
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();
        
        // filling array 50 with random ints 1-20
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        // Print original list
        System.out.println("Original List:");
        System.out.println(originalList);

        // call Duplicates method
        ArrayList<Integer> uniqueList = Duplicates(originalList);

        // Print unique list
        System.out.println("\nList after removing duplicates:");
        System.out.println(uniqueList);
    }

    // this is the generic method to remove duplicates
    public static <E> ArrayList<E> Duplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }
}