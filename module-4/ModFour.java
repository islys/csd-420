import java.util.Iterator;
import java.util.LinkedList;

public class ModFour {

    public static void main(String[] args) {
        testTraversal(50_000);
        System.out.println("---------------------------");
        testTraversal(500_000);
    }

    private static void testTraversal(int size) {
        System.out.println("Testing with LinkedList size: " + size);

        // create and fill the LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // correctness test
        if (list.size() != size) {
            System.out.println("Error: List size is incorrect!");
            return;
        }
        if (list.get(0) != 0 || list.get(size - 1) != size - 1) {
            System.out.println("Error: List contents are incorrect!");
            return;
        }

        // traverse using Iterator and time it
        long startIterator = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        long sumIterator = 0; // Just to use the values
        while (iterator.hasNext()) {
            sumIterator += iterator.next();
        }
        long endIterator = System.currentTimeMillis();

        // traverse using get(index) and time it
        long startGet = System.currentTimeMillis();
        long sumGet = 0;
        for (int i = 0; i < list.size(); i++) {
            sumGet += list.get(i);
        }
        long endGet = System.currentTimeMillis();

        // print results
        System.out.println("Iterator traversal time: " + (endIterator - startIterator) + " ms");
        System.out.println("get(index) traversal time: " + (endGet - startGet) + " ms");

        // check sums to make sure traversal worked correctly
        if (sumIterator != sumGet) {
            System.out.println("Error: Sums do not match!");
        }

        /*
         * In your comments, explain the results and discuss the time taken using 
         * both values and their difference with the get(index) approach:
         * 
         * 
         * 
         * 
         * The results show a significant difference in traversal times between the two methods.
         * The Iterator approach is generally more efficient for traversing a
         * LinkedList because it does not require accessing elements by index,
         * which can be slow for linked structures. Instead, it moves from one
         * element to the next in constant time.
         */
    }
}
