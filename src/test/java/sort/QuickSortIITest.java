package sort;

import org.junit.Test;
import tools.SortTool;

import static org.junit.Assert.*;

public class QuickSortIITest {

    @Test
    public void test() {
        int[] nums = {6, 4, 7, 3, 1, 0, 5, 2, 8, 12, -1, 14};
        //int[] nums = {5, 2, 3, 1};
        // int[] nums = {1, 7, 3, 6, 1, 5, 2, 8};
        SortTool.show(QuickSortII.sort(nums));
        // QuickSort.partition(nums, 0, nums.length - 1);
    }

}