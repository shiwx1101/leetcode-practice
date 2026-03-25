package self.learnnig.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 示例 3：
 * <p>
 * 输入：intervals = [[4,7],[1,4]]
 * 输出：[[1,7]]
 * 解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
 * <p>
 * <p>
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * <p>
 * 思路1: 划线-> 想象一个坐标轴，区间画上直线.再遍历就好了。可以用一个坐标轴。我看到最大值，
 * 问题1: 点标记无法区分 [1,4] 和 [5,6] 是否真正连续。
 * 问题2: 需要弄一个很大的区间来存这些点
 * idea1:   是否可以用位来表示
 * idea2:   在位中增加点点位，奇数数位存0.5 这样可以判断连续了
 *
 *
 *
 *
 *
 */
public class L0056 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int index = 0;
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.get(index)[1] ) {
             result.get(index)[1] = Math.max(intervals[i][1],result.get(index)[1]);
            }else {
                result.add(intervals[i]);
                index++;
            }

        }
        int[][] ints = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints ;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new L0056().merge(nums);
        String string = Arrays.deepToString(merge);
        System.out.println(string);
    }


}
