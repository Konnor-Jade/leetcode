package No0349;

import java.util.LinkedList;

/**
 * @project: leetcode
 * @author: Konnor https://github.com/Konnor-Jade
 * @date: 2024/5/19 22:47
 * @desciption: https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=selected-coding-interview
 */
// https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=selected-coding-interview
public class Solution {

    public String decodeString(String s) {
        // 用于存储最终解码结果的StringBuilder
        StringBuilder res = new StringBuilder();
        // 当前的重复次数
        int multi = 0;
        // 栈，用于存储重复次数
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 栈，用于存储当前字符串
        LinkedList<String> stack_res = new LinkedList<>();

        // 遍历输入字符串的每个字符
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                // 遇到 '['，将当前的重复次数和当前字符串压入栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // 重置当前重复次数和当前字符串
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 遇到 ']'，从栈中弹出重复次数和之前的字符串
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                // 将当前字符串重复相应次数并拼接
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                // 将拼接结果与之前的字符串合并
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                // 如果是数字字符，需要解析为完整的数字
                // 乘以10是为了处理多位数的情况
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                // 如果是字母，追加到当前字符串
                res.append(c);
            }
        }
        // 返回最终的解码字符串
        return res.toString();
    }

    // 测试
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]")); // 输出 "aaabcbc"
        System.out.println(solution.decodeString("3[a2[c]]")); // 输出 "accaccacc"
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // 输出 "abcabccdcdcdef"
        System.out.println(solution.decodeString("abc3[cd]xyz")); // 输出 "abccdcdcdxyz"
    }
}
