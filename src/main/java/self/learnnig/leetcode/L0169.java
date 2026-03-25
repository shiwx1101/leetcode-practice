package self.learnnig.leetcode;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 思路1 哈希表 key 是值，value 是数量，当value > n/2 结束, 但是要额外的空间
 * <p>
 * 思路2 找出第 n/2 + 1 大的数字 可能的复杂读是o(n) 空间复杂度是o(1)
 * <p>
 * 思路3 投票
 *
 *
 */
public class L0169 {


    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = count + 1;
            }else {
                count = count + (num == candidate ? 1 : -1);
            }

        }
        return candidate;
    }

    private int findKthLargest(int[] nums, int k) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (endIndex >= startIndex) {
            int mid = findPivotPlace(nums, startIndex, endIndex);
            int sortOrder = nums.length - mid;
            if (k == sortOrder) {
                return nums[mid];
            } else if (sortOrder > k) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }

        }
        return -1;


    }

    private int findPivotPlace(int[] nums, int startIndex, int endIndex) {
        int pivotIndex = startIndex - 1;
        int pivot = nums[endIndex];
        for (int i = startIndex; i < endIndex; i++) {
            if (nums[i] < pivot) {
                pivotIndex++;
                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[i];
                nums[i] = temp;
            }
        }
        int t = nums[pivotIndex + 1];
        nums[pivotIndex + 1] = nums[endIndex];
        nums[endIndex] = t;
        return pivotIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,5};
        int i = new L0169().majorityElement(nums);
        System.out.println(i);
    }

}
