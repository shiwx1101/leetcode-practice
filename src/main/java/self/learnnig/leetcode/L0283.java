package self.learnnig.leetcode;

/**
 *
 * 代码
 * 测试用例
 * 测试用例
 * 测试结果
 * 283. 移动零
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 思路
 */
public class L0283 {

//    public void moveZeroes(int[] nums) {
//        int zeroIndex = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[++zeroIndex] = nums[i];
//            }
//        }
//        for (int i = zeroIndex + 1; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//
//    }


    public void moveZeroes(int[] nums) {

        int left = 0;
        int right = 0;

        while (right <= nums.length - 1) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        new L0283().moveZeroes(new int[]{0});

    }


}
