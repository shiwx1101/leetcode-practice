package self.learnnig.leetcode;

import self.learnnig.App;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 思路1 应该按照首字母来排序,首字母排序一样再看第二个字母。然后按照从大到小依次连接起来.
 * <p>
 * 问题1： 3 和 30 会把30排在前面 。
 * 解决1 自定义比较策略
 * 1》 如果位数相同，直接比较
 * 2〉 如果位数不同，比较第一位，一直往后比较，直到一方大 或者结束，那一方就排在前面。
 * 问题2： 34 和3  32 把34放在前面3放在后面，32 放在最后
 * 解决2: 还需要判断是否大于前一位
 * <p>
 * 问题3 3432 和 34323 按照前面的规则 应该吧 34323 放在前面 3432 （因为34323的最后一位3 要大于3432 的最后1位2）放在后面 但是结果是
 * <p>
 * 343233432  这个显然是不对的 3432 34323 要更大一些，以上思路是有问题的。 不止最后一位 还有考虑整体组合 较为复杂
 * <p>
 * 所以以上思路可能有点问题。
 * 我门需要换一个思路。
 * 思路2:
 * 从结果的角度出发，把两个数字直接组合起来看看谁大来决定先后
 * 问题 [0,0] 全是0 会有问题
 * 解决 如果全是0的话直接返回0；
 * <p>
 * 思路3:
 *
 *
 *
 */

public class L0179 {

    public String largestNumber(int[] nums) {
        Integer[] numsWrapper = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsWrapper, (a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            return (s1 + s2).compareTo(s2 + s1);
        });
        List<String> stringList = new ArrayList<>();
        if (stringList.get(stringList.size() - 1).equals("0")) {
            return "0";
        }
        for (int i = numsWrapper.length - 1; i >= 0; i--) {
            stringList.add(String.valueOf(numsWrapper[i]));
        }
        return String.join("", stringList);
    }

    public static void main(String[] args) {
        int[] nums = {34323, 3432};
        System.out.println(new L0179().largestNumber(nums));
    }
}
