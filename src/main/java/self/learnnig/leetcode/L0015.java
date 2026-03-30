package self.learnnig.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * <p>
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 思路1三重循环
 *
 * 思路2排序 放在Map 里面  然后便利ij 去找k
 *
 * 思路上排训三指针
 *
 *
 *
 *
 */
public class L0015 {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {

            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length - 1; second++) {

                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                int target = -nums[first];
                while (third > second && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (target == nums[third] + nums[second]) {
                    result.add(List.of(nums[first],nums[second],nums[third]));
                }

            }

        }
        return result;


    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new L0015().threeSum(new int[]{-1,0,1});
        System.out.println(Arrays.deepToString(lists.toArray(new List[0])));
    }
}
