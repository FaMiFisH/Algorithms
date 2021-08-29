package dp;

/**
 * Problem:     Find a path from the upper-left corner to the lower-right corner of an n × n grid, such that we only move down and right. Each square 
 *              contains a positive integer, and the path should be constructed so that the sum of the values along the path is as large as possible.
 * Algorithm:   The recursive algorithm starts from the square we want to find the path to and works backwards. The dp algorithm works forward towards the target square
 *              only looking back at the 2 adjacent squares behind it.
 * Evaluation:  The dp algorithm runs in O(n^2) as it utilises a nested loop. Similary for the recursive algorithm, the time complexity is also O(n^2) as it uses 2 
 *              recursive calls 
 */
public class GridPaths{

    // recursive algorithm
    private static int algorithm(int[][] grid, int x, int y){
        if(x < 0 || y < 0) return 0;
        return max(algorithm(grid, x-1, y), algorithm(grid, x, y-1)) + grid[x][y];
    }

    // dp algorithm
    private static int dpAlgorithm(int[][] grid, int x, int y, int n){
        int[][] sum = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            sum[0][i] = 0;
            sum[i][0] = 0;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                sum[i][j] = max(sum[i-1][j], sum[i][j-1]) + grid[i-1][j-1];
            }
        }
        return sum[x+1][y+1];
    }

    // max function
    private static int max(int a, int b){
        return (a > b ? a : b);
    }

    public static void main(String[] args){
        int[][] grid = {{3,7,9,2,7}, {9,8,3,5,5},{1,7,9,8,5},{3,8,6,4,10},{6,3,9,7,8}}; 
        int x = 4, y = 4, n = 5;
        int pathLength = algorithm(grid, x, y);
        System.out.println("Recursive: " + pathLength);
        pathLength = dpAlgorithm(grid, x, y, n);
        System.out.println("Dynamic programming: " + pathLength);
    }
}