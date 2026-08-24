import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length())
            return result;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int len = p.length();

        for (int i = 0; i < s.length(); i++) {

            window[s.charAt(i) - 'a']++;

            if (i >= len) {
                window[s.charAt(i - len) - 'a']--;
            }

            if (Arrays.equals(need, window)) {
                result.add(i - len + 1);
            }
        }

        return result;
    }
}
Input
s = "cbaebabacd"
p = "abc"

Output
[0, 6]