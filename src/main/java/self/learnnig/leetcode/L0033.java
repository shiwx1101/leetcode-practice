package self.learnnig.leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 难☹️
 */
public class L0033 {


    public int search(int[] nums, int target) {

        int m = nums.length;
        int left = 0;
        int right = m - 1;
        if (nums[left] == target) return 0;
        if (nums[right] == target) return right;

        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[mid] > target && target > nums[0] ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target < nums[m - 1]) {

                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new L0033().search(new int[]{5,1,2,3,4}, 1));
    }
}
