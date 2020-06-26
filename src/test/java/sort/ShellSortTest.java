package sort;

import org.junit.Test;
import tools.SortTool;

import static org.junit.Assert.*;

public class ShellSortTest {
    @Test
    public void test() {
        int[] nums = {141,3,1,2,5,12,4131,123,1234,124,57331,13};
        SortTool.show(ShellSort.sort(nums));
    }

}