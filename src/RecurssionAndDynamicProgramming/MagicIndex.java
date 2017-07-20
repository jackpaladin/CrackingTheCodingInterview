package RecurssionAndDynamicProgramming;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
/**
 * Created by jackpaladin on 7/16/17.
 */
public class MagicIndex {

    /*
    Takes advantage of the fact that the array is sorted and there
    are no duplicates. As this is the case we can use binary search,
    if the value is greater than the index, a magic index must be to
    its left and visa versa.
    Time Complexity: O(logn)
     */
    public static int findIndex(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        return findIndexHelperNoDups(arr, 0);
    }

    public static int findIndexHelper(int[] arr, int startIndex) {
        if(arr.length == 1) {
            if(arr[0] == startIndex) return startIndex;
            return -1;
        }
        int midIndex = arr.length/2;
        if(arr[midIndex] == midIndex+startIndex) {
            return midIndex + startIndex;
        } else if(arr[midIndex] < midIndex) {
            return findIndexHelper(Arrays.copyOfRange(arr, midIndex + 1, arr.length), midIndex+1);
        } else {
            return findIndexHelper(Arrays.copyOfRange(arr, 0, midIndex), startIndex);
        }
    }

    public static int findIndexHelperNoDups(int[] arr, int startIndex) {
        if(arr.length == 0) return -1;
        if(arr.length == 1) {
            if(arr[0] == startIndex) return startIndex;
            return -1;
        }
        int midIndex = arr.length/2;
        if(arr[midIndex] == midIndex+startIndex) {
            return midIndex + startIndex;
        } else if(arr[midIndex] < midIndex) {
            int next = midIndex;
            while(midIndex < arr.length && arr[next] == arr[midIndex]) {
                next++;
            }
            return findIndexHelper(Arrays.copyOfRange(arr, next, arr.length), next);
        } else {
            int next = midIndex;
            while(midIndex >= 0 && arr[next] == arr[midIndex]) {
                next--;
            }
            return findIndexHelper(Arrays.copyOfRange(arr, 0, next), 0);
        }
    }

    @Test
    public void nullTest() {
        assertEquals(-1, findIndex(null));
    }

    @Test
    public void empytTest() {
        int[] emptyArr = {};
        assertEquals(-1, findIndex(emptyArr));
    }

    @Test
    public void trueUniqueTest() {
        int[] trueArr1 = {-2, -1, 0, 3, 8};
        int[] trueArr2 = {-1, 1, 4, 5, 7, 12, 45};
        assertEquals(3, findIndex(trueArr1));
        assertEquals(1, findIndex(trueArr2));
    }

    @Test
    public void trueDupsTest() {
        int[] trueArr1 = {-2,-2,-2,-2,-2,5};
        assertEquals(5, findIndex(trueArr1));
    }



    @Test
    public void falseTest() {
        int[] falseArr = {2,3,4,5,6,7};
        assertEquals(-1, findIndex(falseArr));
    }
}
