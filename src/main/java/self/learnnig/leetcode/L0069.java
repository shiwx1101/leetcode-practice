package self.learnnig.leetcode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *
 */
public class L0069 {


    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int left = 0;
        int right = x;
        int mid = 0;
        int ans = -1;
        while (right >= left) {
            mid = (left + right) / 2;
            long y = (long) mid * mid;
            if (x >= y) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(new L0069().mySqrt(8));

    }
}
