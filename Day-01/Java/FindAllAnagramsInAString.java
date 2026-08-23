import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        for (int i = 0; i <= n - m; i++) {
            String s1 = s.substring(i, i + m);
            if (isAnagram(s1, p)) {
                res.add(i);
            }
        }
        return res;
    }
  
    public static boolean isAnagram(String s, String p) {
        int[] s11 = new int[26];
        for (char x : s.toCharArray()) {
            s11[x - 'a']++;
        }
        for (char x : p.toCharArray()) {
            s11[x - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (s11[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
