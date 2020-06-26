package sort;

import java.util.Stack;

public class QuickSortII {

    public static int[] sort(int[] nums) {
        // Collections.shuffle(list);
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 非递归
     */
    public static void sort(int[] a, int low, int high) {
        int pivot;
        if (low >= high) return;
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        /**
         * 6 4 7 3 1 5 2 8
         * 6 4 2 3 1 5 7 8
         * 5 4 2 3 1 6 7 8
         * 栈最开始元素是0，3 第二次循环元素是0，4，6，7，第五个元素的位置定好了
         * partition(a, low, high)的low high元素来自栈的pop()
         */
        while (!stack.empty()) {
            // 先弹出high, 再弹出low
            high = stack.pop();
            low = stack.pop();
            pivot = QuickSort.partition(a, low, high);
            // 先压low, 再压high
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

}
