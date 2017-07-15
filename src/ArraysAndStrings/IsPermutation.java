package ArraysAndStrings;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by jackpaladin on 7/15/17.
 */
public class IsPermutation {

    /*
    Uses a int array to compare characters in s1
    and s2, assumes ASCII values. Use HashMap if
    assumption is incorrect
    Time Complexity: O(n); Checks at start if different lengths
    Space Complexity: O(n)
     */
    boolean isPermutation(String s1, String s2) {
        if(s1 == null && s2 == null) return true;
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        int[] characters = new int[256];
        for(int i = 0; i < s1.length(); i++) {
            characters[s1.charAt(i)]++;
        }
        for(int i = 0; i < s2.length(); i++) {
            characters[s2.charAt(i)]--;
            if(characters[s2.charAt(i)] < 0) return false;
        }
        return true;

    }

    @Test
    public void bothNullTest() {
        assertEquals(true, isPermutation(null, null));
    }

    @Test
    public void oneNullTest() {
        assertEquals(false, isPermutation(null, "notNull"));
        assertEquals(false, isPermutation("notNull", null));
    }

    @Test
    public void emptyStringsTest() {
        assertEquals(true, isPermutation("", ""));
    }

    @Test
    public void differentLengthTest() {
        assertEquals(false, isPermutation("", "abc"));
        assertEquals(false, isPermutation("abc", ""));
        assertEquals(false, isPermutation("abc", "ab"));
    }

    @Test
    public void trueTest() {
        assertEquals(true, isPermutation("abcd", "dcba"));
        assertEquals(true, isPermutation("abcd", "acbd"));
    }

    @Test
    public void falseTest() {
        assertEquals(false, isPermutation("abcd", "abce"));
        assertEquals(false, isPermutation("abcdefgh", "cdghfeab"));
    }
}
