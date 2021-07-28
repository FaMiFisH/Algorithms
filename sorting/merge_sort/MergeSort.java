public class MergeSort<T extends Comparable<? super T>>{

    public void mergeSort(T[] arr, int start, int end){
        if(start < end){
            int middle = (start + end)/2;

            mergeSort(arr, start, middle);  // sort the first half 
            mergeSort(arr, middle+1, end);  // sort the second half 

            merge(arr, start, middle, end); // merge the sorted halves 
        }
    }

    private void merge(T[] arr, int start, int middle, int end){

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
}