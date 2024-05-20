package No0205;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: leetcode
 * @author: Konnor https://github.com/Konnor-Jade
 * @date: 2024/5/20 22:32
 * @desciption: https://leetcode.cn/problems/isomorphic-strings/?envType=study-plan-v2&envId=selected-coding-interview
 */
// https://leetcode.cn/problems/isomorphic-strings/?envType=study-plan-v2&envId=selected-coding-interview
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (s2t.containsKey(a) && s2t.get(a) != b ||
                t2s.containsKey(b) && t2s.get(b) != a) {
                return false;
            }
            s2t.put(a,b);
            t2s.put(b,a);
        }
        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.isIsomorphic("egg", "add")); // true

        System.out.println(solution.isIsomorphic("foo", "bar")); // false

        System.out.println(solution.isIsomorphic("paper", "title")); // true

        System.out.println(solution.isIsomorphic("ab", "aa")); // false

        System.out.println(solution.isIsomorphic("ab", "ab")); // true

        System.out.println(solution.isIsomorphic("ab", "ba")); // true

        System.out.println(solution.isIsomorphic("abc", "abc")); // true

        System.out.println(solution.isIsomorphic("abc", "abcd")); // false

        System.out.println(solution.isIsomorphic("abc", "abca")); // false

    }
}
