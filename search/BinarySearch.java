package search;

/**
 * Only works for sorted arrays. 
 * Checks the middle index of the active region, check either the left or right region depending in the value of the middle index.
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
    public static <T extends Comparable<T>> int binarySearch(T[] arr, T target){
        return search(arr, target, 0, arr.length);
    }

     /**
      * 
      * @param arr array to be searched
      * @param target value to be searched for
      * @param left pointer to the lower bound
      * @param right pointer to the upper bound
      * @return index of the target value
      */
     private static <T extends Comparable<T>> int search(T[] arr, T target, int left, int right){
        if(right < left) return -1;
        
        // binary sift right, ignores value at MSB
        int mid = (right + left) >>> 1;
        int comp = target.compareTo(arr[mid]);

        if( comp == 0) return mid;
        else if (comp < 0) return search(arr, target, left, mid-1);
        else return search(arr, target, mid+1, right);
     }
 }