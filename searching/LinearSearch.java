/**
 *  Works for unsorted and sorted arrays. 
 *  The algorithm iterates through all indexes to find the target value.
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
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(target) == 0){
                return i;
            }
        }
        return -1;
    }
}