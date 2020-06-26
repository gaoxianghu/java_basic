package sort;

import org.junit.Test;
import tools.SortTool;

public class MergeSortTest {

    @Test
    public void test() {
        int[] nums = {6, 4, 7, 3, 10, 0, 5, 2, 8, 9, 1};
        SortTool.show(MergeSort.sort(nums));
    }

}