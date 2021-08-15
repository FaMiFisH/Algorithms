package search;
import java.util.Random;
/**
 *  Works for unsorted and sorted arrays. 
 *  The algorithm iterates through all indexes to find the target value.
 * 
 *  Time complexity:    Worst case: O(n), Best case: O(1), Average: O(n)
 *  Space complexity:   O(1)
*/
public class LinearSearch{
    /** 
     * Generic linear search
     * @param arr array to be searched
     * @param target value to be searched for
     * @return index of the target value
    */
    public static <T extends Comparable<T>> int search(T[] arr, T target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(target) == 0){
                return i;
            }
        }
        return -1;
    }

    // Tests
    public static void main(String[] args){
        System.out.println("Testing linear search...");

        // generating an array of random numbers
        int size = 100;
        int maxNumber = 100000;
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        for(int i = 0; i < size; i++) arr[i] = Integer.valueOf(rand.nextInt(maxNumber));

        int count = 0;
        for(int i = 0; i < 100; i++){
            // find a random target
            Integer target = Integer.valueOf(arr[rand.nextInt(size)]);
            int linearSearchIndex = LinearSearch.search(arr, target);
            int result = linearSearchIndex != -1 && arr[linearSearchIndex].compareTo(target) == 0 ? 1 : 2;
            if(result != 2) count++;
        }

        System.out.println(": " + "Passed " + count + "/100 tests!");
    }
}