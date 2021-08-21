package dp;

/**
 * Problem   :  Given a set of coins, find the minimum number of coins needed to form the sum n.
 * Algorithm :  Use memoization to calculate values for each target sum up to n.
 * Evaluation:  Will always out the optimum solution in comparison to the implementation using greedy algortihm.
 */

public class CoinProblem{

    public static void algorithm(int[] coins, int n){
        int[] firstCoins = new int[n+1];
        int[] numOfCoins = new int[n+1];
        
        // algorithm
        numOfCoins[0] = 0;
        for(int i = 1; i <= n; i++){
            numOfCoins[i] = 999999;
            for(int c : coins){
                if(i-c >= 0 && numOfCoins[i-c]+1 < numOfCoins[i]){
                    numOfCoins[i] = numOfCoins[i-c] + 1;
                    firstCoins[i] = c;
                }
            }
        }

        //output
        System.out.println("Ans: " + numOfCoins[n]);
        System.out.print("Solution: ");
        while(n > 0){
            System.out.print(firstCoins[n] + " ");
            n = n - firstCoins[n];
        }
        System.out.println("");
    }

    // test
    public static void main(String[] args){
        int[] set = {1,2,5,10,20,50,100,200};
        int target = 540;
        CoinProblem.algorithm(set, target);
    }
}