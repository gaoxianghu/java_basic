package leetcode;

public class Solution_70 {
    // 爬楼梯
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
