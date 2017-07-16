package RecurssionAndDynamicProgramming;

import java.util.Arrays;

/**
 * Created by jackpaladin on 7/15/17.
 */
public class RobotInAGrid {


    /*
    Recursive solution to RobotInAGrid problem. Input is a
    two-dimensional boolean array in which all spots not
    available are represented as false. The function calls
    the countPaths helper function to keep track of current
    position
     */
    public static int countPaths(boolean[][] grid) {
        return countPathsHelper(grid, grid.length, grid[0].length);
    }

    public static int countPathsHelper(boolean[][] grid, int m, int n) {
        if(m < 1 || n < 1) return 0;
        if(!grid[grid.length - m][grid[0].length-n]) return 0;
        if(m == 1 && n == 1) return 1;
        return countPathsHelper(grid, m-1, n) + countPathsHelper(grid, m, n-1);
    }

    /*
    Recursive solution to RobotInAGrid similar to countPahts
    however this solution uses memoization to improve runtime
     */
    public static int countPathsMemo(boolean[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        return countPathsMemoHelper(grid, grid.length, grid[0].length, memo);
    }

    public static int countPathsMemoHelper(boolean[][] grid, int m, int n, int[][] memo) {
        if(m < 1 || n < 1) return 0;
        if(!grid[grid.length - m][grid[0].length-n]) return 0;
        if(m == 1 && n == 1) return 1;
        if(memo[memo.length -m][memo[0].length-n] == -1) {
            int val = countPathsMemoHelper(grid, m-1, n, memo) + countPathsMemoHelper(grid, m, n-1, memo);
            memo[memo.length -m][memo[0].length-n] = val;
            return val;
        } else {
            return memo[memo.length -m][memo[0].length-n];
        }
    }

    /*
    Dynamic Programming solution using iteration. Work through
    array backwards as it will always be the the case that
    we know both the solution to the right and down.
     */
    public static int countPathsDP(boolean[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int row = grid.length - 1; row >= 0; row--) {
            for(int col = grid[0].length - 1; col >= 0; col--) {
                if(row == grid.length -1 && col == grid[0].length -1) {
                    memo[row][col] = (grid[row][col]) ? 1 : 0;
                } else {
                    if(!grid[row][col]) {
                        memo[row][col] = 0;
                    } else {
                        int right = (col < grid[row].length - 1) ? memo[row][col+1] : 0;
                        int down = (row < grid.length -1) ? memo[row+1][col] : 0;
                        memo[row][col] = right + down;
                    }
                }
            }
        }
        return memo[0][0];
    }
}
