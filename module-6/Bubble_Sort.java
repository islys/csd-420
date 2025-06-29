// Ryan Monnier
// CSD 420 - Module 6
// 28-June-2025



import java.util.Arrays;
import java.util.Comparator;

public class Bubble_Sort {

    // bubble sort using natural ordering
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // bubble sort using custom comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 3};
        bubbleSort(numbers);
        System.out.println("Sorted Integers (natural order):");
        System.out.println(Arrays.toString(numbers));

        String[] words = {"German Shepherd", "Belgian Malinois", "Doberman", "Canine Corso", "Rottweiler"};
        bubbleSort(words);
        System.out.println("\nSorted Strings (natural order):");
        System.out.println(Arrays.toString(words));

        String[] moreWords = {"German Shepherd", "Belgian Malinois", "Doberman", "Canine Corso", "Rottweiler"};
        bubbleSort(moreWords, Comparator.reverseOrder());
        System.out.println("\nSorted Strings (reverse order):");
        System.out.println(Arrays.toString(moreWords));
    }
}