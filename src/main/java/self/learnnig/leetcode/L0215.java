package self.learnnig.leetcode;

/**
 * 215. 数组中的第K个最大元素
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class L0215 {

    public int findKthLargest(int[] nums, int k) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int mid = findPivotPlace(nums, startIndex, endIndex);
        while (endIndex <= startIndex) {
            int sortOrder = nums.length - mid;
            if (sortOrder == k) {
                return nums[mid];
            } else if (sortOrder > k) {
                startIndex = mid + 1;
                mid = findPivotPlace(nums, startIndex, endIndex);
            } else {
                endIndex = mid - 1;
                mid = findPivotPlace(nums, startIndex, endIndex);
            }
        }
        return -1;
    }

    public int findPivotPlace(int[] nums, int startIndex, int endIndex) {

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
        int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = new L0215().findKthLargest(a, 2);
        System.out.println(kthLargest);
    }

}
