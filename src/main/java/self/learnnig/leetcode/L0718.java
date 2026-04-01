package self.learnnig.leetcode;

/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * todo 滑动窗口
 */
public class L0718 {

    public int findLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[][] k = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        k[i][j] = k[i - 1][j - 1] + 1;
                    } else {
                        k[i][j] = 1;
                    }
                    if(k[i][j] > max){
                        max = k[i][j];
                    }
                }
            }
        }
        return max;


    }


}
