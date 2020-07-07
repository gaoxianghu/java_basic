package leetcode;

import java.util.PriorityQueue;

public class Solution_215 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     */
    public int findKthLargest(int[] nums, int k) {
        /**
         * 最小堆解法 时间复杂度：O(nlogk) ， 空间复杂度：O(k)
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v1 - v2);
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            res = Math.min(res, queue.poll());
        }

        return res;
    }

    /**
     * 快排的划分思想
     */

}
