package leetcode;

public class Solution_152 {

    /**
     * 给你一个整数数组 nums ，
     * 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 输入: [-2,3,-4]
     * 输出: 3
     *
     * dp，遍历数组对i处，求出最大和最小值
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], tmpMax = nums[0], tmpMin = nums[0], tmp;
        for (int i = 1; i < nums.length; i++) {
            tmp = tmpMax;
            tmpMax = Math.max(Math.max(nums[i], tmpMax * nums[i]), tmpMin * nums[i]);
            tmpMin = Math.min(Math.min(nums[i], tmp * nums[i]), tmpMin * nums[i]);
            max = Math.max(max, tmpMax);
        }
        return max;
    }

}
