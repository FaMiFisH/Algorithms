package search;
import java.util.Random;
/**
 * Only works for sorted arrays. 
 * Checks the middle index of the active region, check either the left or right region depending in the value of the middle index.
 * 
 * Time complexity: Best case: O(1), Worst case: O(log n), Average: O(log n)  
 * Space complexity: O(1)
 */

 public class BinarySearch{
     /**
      * 
      * @param <T> any comparable type
      * @param arr array to search through
      * @param target value being searched for
      * @return index of the taget value if found, else -1
      */
    public static <T extends Comparable<T>> int search(T[] arr, T target){
        return helper(arr, target, 0, arr.length);
    }

     /**
      * 
      * @param arr array to be searched
      * @param target value to be searched for
      * @param left pointer to the lower bound
      * @param right pointer to the upper bound
      * @return index of the target value
      */
     private static <T extends Comparable<T>> int helper(T[] arr, T target, int left, int right){
        if(right < left) return -1;
        
        // binary sift right, ignores value at MSB
        int mid = (right + left) >>> 1;
        int comp = target.compareTo(arr[mid]);

        if( comp == 0) return mid;
        else if (comp < 0) return helper(arr, target, left, mid-1);
        else return helper(arr, target, mid+1, right);
     }

     // tests
     public static void main(String[] args){ 
        System.out.println("Testing binary search...");

        // generate order list 
        int size = 100;
        Integer[] arr = new Integer[size];
        for(int i = 0; i < size; i++) arr[i] = i+1;

        //find a random target
        Random rand = new Random();
        int count = 0;
        for(int i = 0; i < 100; i++){
            Integer target = rand.nextInt(size) + 1;
            int binarySearchIndex = BinarySearch.search(arr, target);   
            int result = binarySearchIndex != -1 && arr[binarySearchIndex].compareTo(target) == 0 ? 1 : 2;
            if(result != 2) count++;
        }
        
        System.out.println(": " + "Passed " + count + "/100 tests!");
     }
 }