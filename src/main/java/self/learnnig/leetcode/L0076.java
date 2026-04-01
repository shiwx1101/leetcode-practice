package self.learnnig.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 最小覆盖子串
 * 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）
 * 。如果没有这样的子串，返回空字符串 ""。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 测试用例保证答案唯一。
 */
public class L0076 {

    Map<Character, Integer> base = new HashMap<>();
    Map<Character, Integer> check = new HashMap<>();

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < m; i++) {
            char tmp = t.charAt(i);
            base.put(tmp, base.getOrDefault(tmp, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int ss = -1;
        int ee = -1;
        int startLeft = 0;
        int startRight = startLeft - 1;
        while (startRight < n) {
            startRight++;

            if (startRight < n && base.containsKey(s.charAt(startRight))) {
                char sca = s.charAt(startRight);
                check.put(sca, check.getOrDefault(sca, 0) + 1);
            }
            while (check() && startLeft <= startRight) {
                int currentValue = startRight - startLeft + 1;
                if (currentValue < min) {
                    min = currentValue;
                    ss = startLeft;
                    ee = startRight;
                }
                char tmp = s.charAt(startLeft);
                if (check.containsKey(tmp)) {
                    check.put(tmp, check.get(tmp) - 1);
                }
                startLeft++;
            }

        }
        if (ss == -1) {
            return "";
        } else {
            return s.substring(ss, ee + 1);
        }


    }

    private boolean check() {
        for (Character c : base.keySet()) {
            if (!check.containsKey(c) || (check.containsKey(c) && check.get(c) < base.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L0076().minWindow("ADOBECODEBANC", "ABC"));
    }
}
