package leetcode;

public class Solution_70 {

    /**
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶-n阶
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /**
         * A1 = 1;
         * A2 = 2;
         * A3 = A2 + A1= 3;
         * A4 = A3 + A2;
         * ...
         * An = An-1 + An-2;
         */
        int[] A = new int[n + 1];
        A[1] = 1;
        A[2] = 2;
        for (int i = 1; i <= n; i++) {
            A[i] = A[i -1] + A[i -2];
        }
        return A[n];
    }
}
