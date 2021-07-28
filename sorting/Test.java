import java.util.Random;

public class Test{
    public static void main(String[] args){
        //generate an array of random integers
        int n = 20;
        Integer[] numbers = new Integer[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            numbers[i] = (Integer) rand.nextInt(100);
        }

        // Merge sort
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(java.util.Arrays.toString(numbers));
    }
}