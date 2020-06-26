package sort;

import tools.SortTool;

public class SelectionSort {
    // 从当前元素的后面元素，选择出最小的一个，与之交换
    // 6 1 3 4 2 5
    public static int[] sortTwo(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int min;
        for (int i = 0; i < nums.length; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                SortTool.swap(nums, i, min);
            }
        }
        return nums;
    }

    public static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            int targetIndex = getMinIndex(nums, i);
            if (nums[targetIndex] < nums[i - 1]) {
                SortTool.swap(nums, i-1, targetIndex);
            }
        }
        return nums;
    }

    private static int getMinIndex(int[] nums, int i) {
        int minIndex = i;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j;
            }
        }
        return minIndex;
    }
}
