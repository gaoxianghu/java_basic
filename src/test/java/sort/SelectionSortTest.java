package sort;

import org.junit.Test;
import tools.SortTool;

public class SelectionSortTest {

    @Test
    public void test() {
        int[] nums = {6,1,3,4,2,5};
        SortTool.show(SelectionSort.sort(nums));
        SortTool.show(SelectionSort.sort(nums));
    }

}
