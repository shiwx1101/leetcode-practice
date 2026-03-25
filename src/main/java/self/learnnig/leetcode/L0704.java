package self.learnnig.leetcode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * <p>
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * <p>
 * <p>
 * 思路 二分 为什么复杂度是logN
 *
 *初始: n 个元素
 * 第1次: n/2
 * 第2次: n/4
 * 第3次: n/8
 * ...
 * 第k次: n/2^k
 * 直到范围缩小到 1，停止搜索。
 *
 * 找 k：
 *
 * n/2^k = 1  →  2^k = n  →  k = log₂n
 *
 */
public class L0704 {


    public int search(int[] nums, int target) {

        int n = nums.length;

        int startIndex = 0;
        int endIndex = n - 1;
        int midIndex = (startIndex + endIndex) / 2;
        while (midIndex >= startIndex && midIndex <= endIndex) {
            if (nums[midIndex] == target) {
                return midIndex;
            } else if (nums[midIndex] > target) {
                endIndex = midIndex - 1;
                midIndex = (startIndex + endIndex) / 2;
            } else {
                startIndex = midIndex + 1;
                midIndex = (endIndex + startIndex) / 2;

            }
        }


        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(new L0704().search(nums, 9));
    }
}
