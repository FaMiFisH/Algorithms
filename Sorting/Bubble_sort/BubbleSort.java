public class BubbleSort<T extends Comparable<? super T>>{
    
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