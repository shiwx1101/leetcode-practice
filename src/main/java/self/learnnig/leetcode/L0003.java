package self.learnnig.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 思路1 朴素算法 直接列出所有子串 算出不重复的
 *
 * 思路2 滑动窗口 + 哈希，精髓是利用前面的处理结果。
 */
public class L0003 {

    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int rt = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rt + 1 < s.length() && !set.contains(s.charAt(rt + 1))) {
                set.add(s.charAt(rt + 1));
                rt++;
            }
            maxSize = Math.max(rt - i + 1, maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(new L0003().lengthOfLongestSubstring(" "));
    }
}
