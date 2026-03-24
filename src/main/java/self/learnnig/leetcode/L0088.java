package self.learnnig.leetcode;

public class L0088 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        if (i >= 0) {
            for (int l = i; l >= 0; l--) {
                nums1[k--] = nums1[l];
            }
        }
        if (j >= 0) {
            for (int l = j; l >=0; l++) {
                nums1[k--] = nums2[l];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] num3 = new int[m];
        for (int i = 0; i < m; i++) {
            num3[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i != m && j != n) {
            if (num3[i] < nums2[j]) {
                nums1[k++] = num3[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        if (i < m) {
            for (int l = i; l < m; l++) {
                nums1[k++] = num3[l];
            }
        }
        if (j < n) {
            for (int l = j; l < n; l++) {
                nums1[k++] = nums2[l];
            }
        }
    }

    //    [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new L0088().merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
