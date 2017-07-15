package ArraysAndStrings;

/**
 * Created by jackpaladin on 7/15/17.
 */
public class URLify {
    public static void main(String[] args) {
        String a = "Hello my name is jack        ";
        char[] s = a.toCharArray();
        urlify(s, 21);
        String st = new String(s);
        System.out.println(st);
    }

    /*
    Calculates the amount of space needed to add %20s then
    iterates backwards through the char[] to ensure that there
    is space.
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public static void urlify(char[] s, int size) {
        if(s == null) return;
        if(size == 0 || s.length == 0) return;
        int necessarySpace = 0;
        for(int i = 0; i < size; i++) {
            if(s[i] == ' ') {
                necessarySpace += 3;
            } else {
                necessarySpace++;
            }
        }
        int oldIndex = size-1;
        int newIndex = necessarySpace-1;
        while(oldIndex >= 0) {
            if(s[oldIndex] == ' ') {
                s[newIndex] = '0';
                s[newIndex-1] = '2';
                s[newIndex-2] = '%';
                newIndex -= 3;
                oldIndex--;
            } else {
                s[newIndex] = s[oldIndex];
                newIndex--;
                oldIndex--;
            }
        }
    }
}
