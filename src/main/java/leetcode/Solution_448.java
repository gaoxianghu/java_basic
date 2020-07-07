package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class Solution_448 {

    /**
     * 输入: [4,3,2,7,8,2,3,1]
     * 输出: [5,6]
     *
     * 方法一，特殊数组，元素值转换为新建过渡数组元素下标 时间空间都是O(n)
     * 方法二，官方解法：置数 nums[∣nums[i]∣−1]×−1 在方法一的基础上改进，使用±解决将空间复杂度降低为O(1)
     *
     * [4,3,2,7,8,2,3,1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     * [0,1,2,3,4,5,6,7]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 超出时间限制
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] resTMP = new int[nums.length];
//        for (int i = 1; i<= nums.length; i++) {
//            res.add(i);
//        }
//        for (int i = 0; i< nums.length; i++) {
//            if (res.contains(nums[i])) {
//                res.remove((Integer) nums[i]);
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            resTMP[nums[i] - 1] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (resTMP[i] != 1) {
                res.add(i + 1);
            }
        }

        return res;
    }

}
