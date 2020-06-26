package sort;

public class InsertionSort {
    // 当前元素插入到前面元素适当位置，使得有序
    // 1 3 4 2 5
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
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
        return nums;
    }

}
