package greedy;
import java.util.Arrays;
/**
 * Problem   :  Given a set of coins, find the minimum number of coins needed to form the sum n.
 * Algorithm :  A simple greedy algorithm will always select the largest possible coin until the required sum is constucted.
 * Evaluation:  The greedy algorithm does not always produce the optimal solution. For example, given the set {1,3,4} with target sum 6,
 *              the greey algorithms will produce the solution 4+1+1 when the optimal solution is 3+3. However, it does find the optimal solution for 
 *              paticular sets. For example the set constaining coins of UK currency.
 */
public class CoinProblem{

    public static void algorithm(int[] arr, int target){
        // indexes will refer to the indexes of the given array 
        int[] solution = new int[arr.length];
        // the value of each index will refer to the number of times that index is used in the given array to produce the solution
        for(int i = 0; i < solution.length; i++) solution[i] = 0;

        // sort the set in order
        Arrays.sort(arr);

        //display coins + target
        System.out.print("Coins: ");
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println("");
        System.out.println("Target: " + target);

        // algorithm
        for(int i = arr.length - 1; i >= 0; i--){
            while (target - arr[i] >= 0) {
                solution[i]++;
                target -= arr[i];
            }
        }

        // display solution
        if(target == 0) {
            System.out.print("Solution: ");
            for(int i = solution.length - 1; i >= 0; i--){
                if(solution[i] > 0){
                    int coin = arr[i];
                    int times = solution[i];
                    for(int j = 0; j < times; j++) System.out.print(coin + " ");
                }
            }
            System.out.println(" ");
        }else{
            System.out.println("Solution does not exist!");
        }
    }
    public static void main(String[] args){
        int[] set = {1,2,5,10,20,50,100,200};
        int target = 520;
        CoinProblem.algorithm(set, target);
    }

}