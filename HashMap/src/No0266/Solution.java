package No0266;

import java.util.HashMap;

/**
 * @project: leetcode
 * @author: Konnor https://github.com/Konnor-Jade
 * @date: 2024/5/20 23:19
 * @desciption: https://leetcode.cn/problems/palindrome-permutation/solutions/2362067/266-hui-wen-pai-lie-ha-xi-biao-qing-xi-t-k86v/?envType=study-plan-v2&envId=selected-coding-interview
 */
// https://leetcode.cn/problems/palindrome-permutation/solutions/2362067/266-hui-wen-pai-lie-ha-xi-biao-qing-xi-t-k86v/?envType=study-plan-v2&envId=selected-coding-interview

public class Solution {

    public boolean canPermutePalindrome(String s) {
        // 创建一个HashMap用于统计每个字符出现的次数
        HashMap<Character, Integer> dic = new HashMap<>();

        // 遍历字符串的每个字符，统计每个字符的出现次数
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            dic.put(currentChar, dic.getOrDefault(currentChar, 0) + 1);
        }

        // 统计出现次数为奇数的字符的个数
        int odd = 0;
        for (int v : dic.values()) {
            if (v % 2 == 1) { // 如果字符出现次数为奇数
                odd++;
                // 如果超过一个字符的出现次数为奇数，则不能排列成回文
                if (odd > 1) {
                    return false;
                }
            }
        }

        // 如果最多只有一个字符的出现次数为奇数，则可以排列成回文
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().canPermutePalindrome("abc"));// false

        System.out.println(new Solution().canPermutePalindrome("aa"));// true

        System.out.println(new Solution().canPermutePalindrome("aaa"));// true

        System.out.println(new Solution().canPermutePalindrome("abcdefg"));// false

        System.out.println(new Solution().canPermutePalindrome("abcdefgc"));// false
    }
}
