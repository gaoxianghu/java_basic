package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int j = 0;j < nums.length; j++) {
            if (numToIndex.containsKey(target - nums[j])) {
                res[1] = j;
                res[0] = numToIndex.get(target - nums[j]);
                if (j != res[0]) {
                    return res;
                }

            }
            // 不需要遍历两遍数组
            numToIndex.put(nums[j], j);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}

