package No0387;

import java.util.HashMap;

/**
 * @project: leetcode
 * @author: Konnor https://github.com/Konnor-Jade
 * @date: 2024/5/19 23:20
 * @desciption: https://leetcode.cn/problems/first-unique-character-in-a-string/description/?envType=study-plan-v2&envId=selected-coding-interview
 */
// https://leetcode.cn/problems/first-unique-character-in-a-string/description/?envType=study-plan-v2&envId=selected-coding-interview

// 请记住，在Java中，HashMap的key和value可以是任何类型，包括自定义类。

public class Solution {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            // 如果map中已经存在该key，则将其对应的value设置为false
            map.put(c, !map.containsKey(c));
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.firstUniqChar("leetcode")); // 输出0

        System.out.println(solution.firstUniqChar("loveleetcode")); // 输出2

        System.out.println(solution.firstUniqChar("aabb")); // 输出-1

        System.out.println(solution.firstUniqChar("aab")); // 输出2

        System.out.println(solution.firstUniqChar("aabcc")); // 输出2
    }
}
