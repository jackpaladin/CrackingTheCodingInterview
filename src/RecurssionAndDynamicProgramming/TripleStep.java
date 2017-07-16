package RecurssionAndDynamicProgramming;

import java.util.Arrays;

/**
 * Created by jackpaladin on 7/15/17.
 */
public class TripleStep {
    public static void main(String[] args) {
        System.out.println(possiblePaths(1));
        System.out.println(possiblePaths(2));
        System.out.println(possiblePaths(3));
        System.out.println(possiblePaths(30));
        System.out.println(possiblePathsMemo(1));
        System.out.println(possiblePathsMemo(2));
        System.out.println(possiblePathsMemo(3));
        System.out.println(possiblePathsMemo(30));
        System.out.println(possiblePathsDP(1));
        System.out.println(possiblePathsDP(2));
        System.out.println(possiblePathsDP(3));
        System.out.println(possiblePathsDP(30));

    }

    /*
    Calculate the number of possible paths to get up numSteps
    steps taking either 1, 2, or 3 steps. Use recursion, base
    cases if num steps is 0 return 1 if num steps is < 0 return 0.
    Otherwise sum the number of possible paths by taking 1, 2,
    or 3 steps
    Time Complexity: O(2^n)
    Space Complexity: O(n);
     */
    public static int possiblePaths(int numSteps) {
        if(numSteps < 0) return 0;
        if(numSteps == 0) return 1;
        return possiblePaths(numSteps-1) + possiblePaths(numSteps - 2) + possiblePaths(numSteps-3);
    }

    /*
    Memoized recursive solution
     */
    public static int possiblePathsMemo(int numSteps) {
        int[] memoized = new int[numSteps];
        Arrays.fill(memoized, -1);
        return possiblePathsHelper(numSteps, memoized);
    }

    public static int possiblePathsHelper(int numSteps, int[] memoized) {
        if(numSteps < 0) return 0;
        if(numSteps == 0) return 1;
        if(memoized[numSteps-1] == -1) {
            int ans = possiblePathsHelper(numSteps -1, memoized) + possiblePathsHelper(numSteps -2, memoized) + possiblePathsHelper(numSteps -3, memoized);
            memoized[numSteps-1] = ans;
            return ans;
        } else {
            return memoized[numSteps-1];
        }
    }


    /*
    Solution using Dynamic programming approach working
    backwards
     */
    public static int possiblePathsDP(int numSteps) {
        if(numSteps == 1) return 1;
        if(numSteps == 2) return 2;
        if(numSteps == 3) return 4;
        int[] memoized = new int[numSteps];
        memoized[numSteps-1] = 1;
        memoized[numSteps-2] = 2;
        memoized[numSteps-3] = 4;
        for(int i = numSteps-4; i >= 0; i--) {
            memoized[i] = memoized[i+1] + memoized[i+2] + memoized[i+3];
        }
        return memoized[0];
    }
}
