package sort;

import org.junit.Test;
import tools.SortTool;

public class InsertionSortTest {

    @Test
    public void test() {
        int[] nums = {3,1,2,5};
        SortTool.show(InsertionSort.sort(nums));
    }

}