package sort;

import tools.SortTool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    /**
     * 快速排序
     * 选定一个标记元素，将比它小的放左边，比它大的放右边，递归
     */
    public static int[] sort(int[] nums) {
        // Collections.shuffle(list);
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0 , nums.length -1);
        return nums;
    }

    public static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = partition(nums, low, high);
        sort(nums, low, middle - 1);
        sort(nums, middle + 1, high);
    }

    /**
     * 6 4 7 3 1 5 2 8
     */
    public static int partition(int[] nums, int low, int high) {
        int i = low, j = high;
        while (i < j) {
            while (nums[j] >= nums[low] && i < j) j--;
            while (nums[i] <= nums[low] && i < j) i++;
            SortTool.swap(nums, i, j);
        }
        SortTool.swap(nums, i, low);
        return i;
    }

}
