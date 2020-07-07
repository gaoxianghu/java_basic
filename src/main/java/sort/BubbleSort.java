package sort;

import tools.SortTool;

public class BubbleSort {
    /**
     * 冒泡排序
     */
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        // 1 2 3 4 5 6 8
        // 6 4 8 1 3 2 5
        // 4 6 1 3 2 5 8
        // 4 1 3 2 5 6 8
        boolean swap; // 如果没有交换操作，说明数组已经有序，可以提前退出，节省时间
        int i, j;
        for (i = 1; i < nums.length; i++) {
            swap = false;
            for (j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap = true;
                    SortTool.swap(nums, j, j + 1);
                }
            }
            if (!swap) {
                break;
            }
        }
        return nums;
    }
}
