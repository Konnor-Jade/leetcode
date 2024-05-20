package No0242;

import java.util.HashMap;

/**
 * @project: leetcode
 * @author: Konnor https://github.com/Konnor-Jade
 * @date: 2024/5/19 23:10
 * @desciption: https://leetcode.cn/studyplan/selected-coding-interview/
 */
// https://leetcode.cn/studyplan/selected-coding-interview/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (int val : map.values()) {
            if (val != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.isAnagram("anagram", "nagaram")); // true

        System.out.println(solution.isAnagram("rat", "car")); // false

        System.out.println(solution.isAnagram("aacc", "ccac")); // false

        System.out.println(solution.isAnagram("abc", "bac"));  // true
    }
}
