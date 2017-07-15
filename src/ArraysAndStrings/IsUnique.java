package ArraysAndStrings;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by jackpaladin on 7/15/17.
 */
public class IsUnique {

    /*
    Naive brute force isUnique algorithm
    Run Complexity: O(n^2)
    Space Complexity: O(1)
     */
    boolean isUniqueBruteForce(String s) {
        if(s == null || s.length() <= 1) return true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = i+1; j < s.length(); j++) {
                if (c == s.charAt(j)) return false;
            }
        }
        return true;
    }

    /*
    Solution using set to keep track of chars
    Assumes extended ASCII characters, use set
    if assumption is incorrect;
    Run Complexity: O(n)
    Space Complexity: O(n)
     */
    boolean isUnique(String s) {
        if(s == null || s.length() <= 1) return true;
        boolean[] characters = new boolean[256];
        //Set<Character> characters = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(characters[s.charAt(i)]) {
                return false;
            }
            characters[s.charAt(i)] = true;
        }
        return true;

    }

    @Test
    public void nullTest() {
        assertEquals(true, isUnique(null));
        assertEquals(true, isUniqueBruteForce(null));
    }

    @Test
    public void emptyStringTest() {
        assertEquals(true, isUnique(""));
        assertEquals(true, isUniqueBruteForce(""));
    }

    @Test
    public void singleCharTest() {
        assertEquals(true, isUnique("a"));
        assertEquals(true, isUniqueBruteForce("a"));
    }

    @Test
    public void trueTest() {
        assertEquals(true, isUnique("abcdefg"));
        assertEquals(true, isUniqueBruteForce("abcdefg"));
    }

    @Test
    public void falseTest() {
        assertEquals(false, isUnique("aba"));
        assertEquals(false, isUniqueBruteForce("aba"));
    }

}
