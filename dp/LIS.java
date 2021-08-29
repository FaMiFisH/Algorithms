package dp;
import java.util.Arrays;

/**
 * Problem:     Find the longest increasing subsequence in an array of n elements. This is a maximum-length sequence of array elements that goes
 *              from left to right, and each element in the sequence is larger than the previous element. 
 * Algorithm:   Subsequence at index i has an optimal length subSeqLength[j]+1 if there is an index j < i such that arr[j] < arr[i] also holds. If 
 *              there is no such index j, then the length of the optimal subsequence is just 1; arr[i].
 * Evaluation:  The algorithm works in O(n^2) time and has space complexity of O(n). It is possible to have a O(n*log n) solution. If the new element is 
 *              greater than the element at last index, clone the subsequence and add it to the end. Now there are multiple active subsequences. For any
 *              new element greater than the last index of all active subsequences, clone the longest subsequence and add it to the end. For any new element
 *              less than the value at the first index of all active subsequences, create a new active subsequence containing the new element. Discard any 
 *              active subsequences if another active subsequence exists of same length with a smaller value at last index. For any new element in between,
 *              add the element at the end of any active subsequence where the value at the last index is less than the new element. In our implementation, 
 *              since we only care about the length, we can work with only a single array and replace index values accordingly.
 */
public class LIS{

    private static void algorithm(int[] arr){
        int[] subSeqLength = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            subSeqLength[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]) subSeqLength[i] = max(subSeqLength[i], subSeqLength[j] + 1);
            }
        }

        // output
        System.out.println("Array: " + Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++){
            System.out.println("Index " + i + ": " + subSeqLength[i]);
        }
    }

    // max function
    private static int max(int a, int b){
        return (a > b ? a : b);
    }

    // O(n*log n) algorithm
    private static void nlognAlgorithm(int[] arr){
        int[] tempArr = new int[arr.length];
        int currentIndex = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < tempArr[0]) tempArr[0] = arr[i];
            else if(arr[i] > tempArr[(currentIndex == 0 ? 0 : currentIndex-1)]) tempArr[currentIndex++] = arr[i];
            else insert(tempArr, currentIndex, arr[i]);
            //System.out.println("Array: " + Arrays.toString(tempArr));
        }

        System.out.println("Length of the longest increasing subsequence: " + currentIndex);
    }

    // inserts the new element into the given array
    private static void  insert(int[] arr, int currentIndex, int newElement){
        // binary search for the index to insert the new element
        int leftPtr = 0, rightPtr = currentIndex, mid = 0;
        while(leftPtr < rightPtr){
            mid = (leftPtr + rightPtr) / 2;
            if(newElement < arr[mid]) rightPtr = mid;
            else leftPtr = mid + 1;
        }
        arr[rightPtr] = newElement;
    }

    public static void main(String[] args){
        int[] arr = {6,2,5,1,7,4,8,3};
        algorithm(arr);
        nlognAlgorithm(arr);
    }

}