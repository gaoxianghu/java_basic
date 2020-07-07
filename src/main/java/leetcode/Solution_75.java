package leetcode;

import tools.SortTool;

public class Solution_75 {

    /**
     * 排序：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 输入: [1,0,2,2,1,0]
     * 输出: [0,0,1,1,2,2]
     *
     * 运行时间 内存消耗 语言
     * 0 ms	  38.1 MB Java
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 数0 1 的个数，再填回去，有多的填2
        /*int count0 = 0, count1 = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                count0++;
            }
            if (nums[k] == 1) {
                count1++;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (k < count0) {
                nums[k] = 0;
                continue;
            }
            if (k < count1 + count0) {
                nums[k] = 1;
                continue;
            }
            nums[k] = 2;
        }*/
        /**
         * 用三个指针（p0, p2 和curr）来分别追踪0的最右边界，2的最左边界和当前考虑的元素。
         */
        int pointer0 = 0, pointer1 = nums.length - 1, curr = 0;
        while (curr <= pointer1) {
            if (nums[curr] == 0) {
                SortTool.swap(nums, pointer0++, curr++);
                continue;
            }
            if (nums[curr] == 2) {
                SortTool.swap(nums, pointer1--, curr);
            } else {
                curr++;
            }
        }

    }

}
