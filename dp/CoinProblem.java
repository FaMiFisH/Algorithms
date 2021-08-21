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

    // part-2
    /**
     * Counts the number of ways the solution can be reached
     * @param coins set of coins used to create the target sum
     * @param n target sum
     */
    public static void count(int[] coins, int n){
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int c : coins){
                if(i-c >= 0) ways[i] += ways[i-c];
            }
        }

        System.out.println("Ans: " + ways[n]);
    }

    // test
    public static void main(String[] args){
        int[] set = {1,2,5,10,20,50,100,200};
        int target = 5;
        CoinProblem.algorithm(set, target);
        CoinProblem.count(set, target);
    }
}