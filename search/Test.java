import search.LinearSearch;
import java.util.Arrays;
import java.util.Random;

public class Test{
    public static void main(String args[]){

        // generating an array of random numbers
        int size = 100;
        int maxNumber = 100000;
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        for(int i = 0; i < size; i++) arr[i] = Integer.valueOf(rand.nextInt(maxNumber));

        // find a random target
        Integer target = Integer.valueOf(arr[rand.nextInt(size)]);
        System.out.println("Value to find: " + target);

        // search for the target
        LinearSearch linearSearch = new LinearSearch();
        int linearSearchIndex = linearSearch.search(arr, target);
        System.out.println("Linear search: Index " + linearSearchIndex + " -> " + arr[linearSearchIndex]);
        // sort the array first
    }
}