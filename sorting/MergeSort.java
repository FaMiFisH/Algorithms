package sorting;
import java.util.Random;

/**
 * Based on recursion. Merge sort sorts a subarray array[a...b] as follows:
 * 1. If a = b, do not do anything, because the subarray is already sorted.
 * 2. Calculate the position of the middle element: k = floorFunction((a+b)/2).
 * 3. Recursively sort the subarray array[a...k].
 * 4. Recursively sort the subarray array[k+1...b].
 * 5. Merge the sorted subarrays array[a...k] and array[k +1...b] into a sorted subarray array[a...b] 
 * 
 * The recursion consists of `O(log n)` levels, and processing each level takes `O(n)` time. 
 * Merging the subarrays array[a...k] and array[k+1...b] is possible in linear time, because they are already sorted.
 * 
 * Time complexity: O(n*log n) in all 3 cases
 * Space complexity: O(n)
 */
public class MergeSort{

    /**
     * @param arr array to be sorted
     */
    public static <T extends Comparable<? super T>> void sort(T[] arr){
        if(arr.length > 0) sort(arr, 0, arr.length-1);
    }

    /**
     * @param arr sub-array to be sorted 
     * @param start pointer to the first index of the sub-array 
     * @param end pointer to the last index of the sub-array
     */
    public static <T extends Comparable<? super T>> void sort(T[] arr, int start, int end){
        if(start < end){
            int middle = (start + end)/2;

            sort(arr, start, middle);  // sort the first half 
            sort(arr, middle+1, end);  // sort the second half 

            merge(arr, start, middle, end); // merge the sorted halves 
        }
    }

    /**
     * @param arr the first and second half of the sub-array have been sorted seperatly, merge the 2 halfs together
     * @param start pointer to the start of the first half of the sub-array
     * @param middle pointer to the middle of the sub-array
     * @param end pointer to the end of the sub-array
     */
    private static <T extends Comparable<? super T>> void merge(T[] arr, int start, int middle, int end){
        // copy the given array into 2 seperate arrays, split down the middle
        T[] leftArr = (T[]) new Comparable[middle - start + 1];
        T[] rightArr = (T[]) new Comparable[end - middle];
        for (int i = 0; i < leftArr.length; i++){
            leftArr[i] = arr[start + i];
        }
        for (int i = 0; i < rightArr.length; ++i){
            rightArr[i] = arr[middle + i + 1];
        }

        // merge the 2 arrays
        int leftIndex = 0, rightIndex = 0, currentIndex= start;
        while(leftIndex < leftArr.length && rightIndex < rightArr.length){
            if(leftArr[leftIndex].compareTo(rightArr[rightIndex]) <= 0){
                arr[currentIndex++] = leftArr[leftIndex++];
            }else{
                arr[currentIndex++] = rightArr[rightIndex++];
            }
        }
        // copy the remaining indexes over
        while(leftIndex < leftArr.length){
            arr[currentIndex++] = leftArr[leftIndex++];
        }
        while(rightIndex < rightArr.length){
            arr[currentIndex++] = rightArr[rightIndex++];
        }
    }

    public static void main(String[] args){
        System.out.println("Testing merge sort...");

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

            MergeSort.sort(arr);
            try{
                for(int k = 0; k < size-1; k++) assert arr[k] <= arr[k+1];
            }catch(AssertionError e){
                count--;
            }
        }

        System.out.println("Passed " + count + "/100 tests!");
    }
}