package sort;

import org.junit.Test;
import tools.SortTool;

public class QuickSortTest {

    @Test
    public void test() {
         int[] nums = {6, 4, 7, 3, 1, 0, 5, 2, 8, 12, -1, 14};
         //int[] nums = {5, 2, 3, 1};
        // int[] nums = {1, 7, 3, 6, 1, 5, 2, 8};
        SortTool.show(QuickSort.sort(nums));
        // QuickSort.partition(nums, 0, nums.length - 1);
    }

}