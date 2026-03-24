package self.learnnig.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 解释：数组排序后，某些数字的位置没有改变（例如，2 和 3），而其他数字的位置发生了改变（例如，1 和 5）。
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 解释：请注意，nums 的值不一定唯一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class L0912 {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int startIndex, int endIndex, int[] holders) {
        if (endIndex <= startIndex) return;
        int mid = (startIndex + endIndex) / 2;
        mergeSort(nums, startIndex, mid, holders);
        mergeSort(nums, mid + 1, endIndex, holders);
        mergeList(nums, startIndex, mid, endIndex, holders);

    }

    private void mergeList(int[] nums, int startIndex, int mid, int endIndex, int[] holders) {
        for (int i = startIndex; i <= endIndex; i++) {
            holders[i] = nums[i];
        }
        int i = startIndex;
        int j = mid + 1;
        int k = startIndex;
        while (true) {
            if (holders[i] <= holders[j]) {
                nums[k] = holders[i];
                k++;
                i++;
            } else {
                nums[k] = holders[j];
                k++;
                j++;
            }
            if (i > mid || j > endIndex) {
                break;
            }
        }
        if (i <= mid) {
            for (int l = i; l <=mid ; l++) {
                nums[k]=holders[l];
                k++;
            }
        }

        if (j <= endIndex){
            for (int l = j; l <=endIndex ; l++) {
                nums[k]=holders[l];
                k++;
            }
        }
    }

    private void quickSort(int[] nums, int startIndex, int endIndex) {

        int midIndex = findPivotPlace(nums, startIndex, endIndex);
        if (midIndex > startIndex) {
            quickSort(nums, startIndex, midIndex - 1);
        }
        if (midIndex < endIndex) {
            quickSort(nums, midIndex + 1, endIndex);
        }


    }

    private int findPivotPlace(int[] nums, int startIndex, int endIndex) {
        // 随机选一个，换到末尾
        int randomIndex = startIndex + (int) (Math.random() * (endIndex - startIndex + 1));
        int tp = nums[randomIndex];
        nums[randomIndex] = nums[endIndex];
        nums[endIndex] = tp;

        // 下面才是标准 partition
        int pivot = nums[endIndex];
        int pivotIndex = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {
            if (nums[i] < pivot) {  // 用 <= 而不是 <
                pivotIndex++;
                int t = nums[pivotIndex];
                nums[pivotIndex] = nums[i];
                nums[i] = t;
            }
        }
        int temp = nums[pivotIndex + 1];
        nums[pivotIndex + 1] = pivot;
        nums[endIndex] = temp;
        return pivotIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {110, 100, 0};
        int[] holders = new int[nums.length];
         new L0912().mergeSort(nums,0,nums.length -1,holders);
        for (int anInt : nums) {
            System.out.print(anInt + " ");
        }
    }


}
