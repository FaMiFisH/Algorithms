package sorting;

/**
 * Bubble sort consists of n rounds. On each round, the algorithm iterates
 * through the elements of the array. Whenever two consecutive elements are found
 * that are not in correct order, the algorithm swaps them.
 * Time complexity:     Worst case: O(n^2),  Best case: O(n), Average: O(n^2)
 * Space Complexity:    O(1)
 */
public class BubbleSort<T extends Comparable<? super T>>{
    
    /**
     * Generic bubble sort
     * @param arr sorts the content of this arr
     */
    public void bubbleSort(T[] arr){
        int n = arr.length;
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
    }


}