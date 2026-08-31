/*You are given two strings S and T.

For each character in S, you can either:

keep the character unchanged, or
increment it by 1 cyclically (a → b, b → c, ..., y → z, z → a).

After making these changes, determine whether T can be formed as a subsequence of the resulting string.

A subsequence does not require characters to be continuous, but the order of characters must remain the same.*/
import java.util.*;

public class CyclicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int j = 0;
        for (int i = 0; i < S.length() && j < T.length(); i++) {
            char c = S.charAt(i);
            // Increment c by 1 cyclically
            char next = (c == 'z') ? 'a' : (char)(c + 1);
            if (c == T.charAt(j) || next == T.charAt(j)) {
                j++;
            }
        }
        if (j == T.length())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
