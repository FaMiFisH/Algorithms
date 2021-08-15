package sorting;
import java.util.Random;

/**
 * Bubble sort consists of n rounds. On each round, the algorithm iterates
 * through the elements of the array. Whenever two consecutive elements are found
 * that are not in correct order, the algorithm swaps them.
 * Time complexity:     Worst case: O(n^2),  Best case: O(n), Average: O(n^2)
 * Space Complexity:    O(1)
 */
public class BubbleSort{
    
    /**
     * Generic bubble sort
     * @param arr sorts the content of this arr
     */
    public static <T extends Comparable<? super T>> void sort(T[] arr){
        try{
            int n = arr.length-1;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    // if element at index i is greater than i+1
                    if(arr[j].compareTo(arr[j+1]) > 0){
                        // swap the elements
                        T temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Caught " + e);
        }
    }

    // tests
    public static void main(String[] args){ 
        System.out.println("Testing bubble sort...");

        // generate an array of random integers
        int size = 100;
        int maxNumber = 1000;

        int count = 0;
        for(int i = 0; i < 100; i++){
            count++;
            Integer[] arr = new Integer[size];
            Random rand = new Random();
            for(int j = 0; j < size; j++){
                arr[j] = (Integer) rand.nextInt(maxNumber);
            }

            BubbleSort.sort(arr);
            try{
                for(int k = 0; k < size-1; k++) assert arr[k] <= arr[k+1];
            }catch(AssertionError e){
                count--;
            }
        }

        System.out.println("Passed " + count + "/100 tests!");
            
    }
}