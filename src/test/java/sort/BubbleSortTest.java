package sort;

import org.junit.Test;
import tools.SortTool;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void test() {
        int[] nums = {6, 4, 7, 3, 1, 0, 5, 2, 8, 12, -1, 14};
        // int[] nums = {1, 7, 3, 6, 1, 5, 2, 8};
        SortTool.show(BubbleSort.sort(nums));
    }

}