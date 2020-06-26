package sort;

public class ShellSort {
    // 目前希尔排序的时间复杂度是：O（nlogn）～O（n2）
    // 是直接插入排序算法的一种更高效的改进版本

    public static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int N = nums.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1) {
            // 插入排序
            for (int i = h; i < nums.length; i++) {
                int target = nums[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (nums[j] > target) {
                        nums[j + 1] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + 1] = target;
            }
            h /= 3;
        }

        return nums;
    }
}
