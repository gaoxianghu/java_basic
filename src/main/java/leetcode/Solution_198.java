package leetcode;

import java.util.Arrays;

/**
 * 打家劫舍
 */
public class Solution_198 {

    public int rob(int[] nums) {

        /**
         * 相邻元素不能累加，求最大和
         *
         * [1,2,3,1] 4
         * [2,7,9,3,1] 12
         *
         * 简单动规，递推式：An = max(An-2 + an, An-1)，注意边界和初始值计算
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }
        return res[nums.length - 1];
    }
}
