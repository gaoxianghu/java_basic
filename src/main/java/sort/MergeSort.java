package sort;

public class MergeSort {

    public static int[] sort(int[] nums) {
        // Collections.shuffle(list);
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0 , nums.length -1);
        return nums;
    }

    /**
     * 归并排序
     * 左半部分排序，右半部分排序，归并结果
     */
    public static void mergeSort(int[] nums, int left, int right) {
        // 需要左右边界确定排序范围
        if (left >= right) return;
        int mid = (left + right) >> 1;

        // 先对左右子数组进行排序
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        mergeArray(nums, left, right, mid);
    }

    private static void mergeArray(int[] nums, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        // 临时数组存放合并结果
        int cur = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            // 开始合并数组
            if (nums[i] <= nums[j]) temp[cur++] = nums[i++];
            else temp[cur++] = nums[j++];
        }
        while (i <= mid) temp[cur++] = nums[i++];
        while (j <= right) temp[cur++] = nums[j++];

        for (int k = 0; k < temp.length; k++) {
            // 合并数组完成，拷贝到原来的数组中
            nums[left + k] = temp[k];
        }
    }
}
