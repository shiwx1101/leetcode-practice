package self.learnnig.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class L0054 {

    //多个指针运用,注意结束条件
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        List<Integer> result = new ArrayList<>();
        while (true) {
            //move right
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }

            //move down
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            //move left
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down --;
            if (down < up){
                break;
            }
            for (int i = down; i >= up ; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new L0054().spiralOrder(matrix));
    }
}
