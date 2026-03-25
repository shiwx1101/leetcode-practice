package self.learnnig.leetcode;

import java.util.Arrays;

/**
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 思路 二分
 * 1.找到了一个数字之后 然后左右遍历。直到左右都找到不是的数字。 如果一个很长的数组全是一个数字 那么会退化成n 不考虑
 * 2.找打一个数字后，在左边的区间继续找，直到找到一个下标当前值是 前一个不是，右边同理。
 * <p>
 * 要写两个吗？ 写两个 先实现吧 屈服了。
 * <p>
 * =>
 */
public class L0034 {

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left,right};
    }

    private int searchLeft(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                if (mid == start) {
                    return mid;
                }
                if (nums[mid - 1] < target) {
                    return mid;
                }
            }
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    private int searchRight(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                if (mid == end) {
                    return mid;
                }
                if (nums[mid + 1] > target) {
                    return mid;
                }
            }
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new L0034().searchRange(nums, 8)));
    }

}
