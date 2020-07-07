package leetcode;

public class Solution_88 {

    /**
     * 两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     *
     * 从后往前填，防止移动元素，降低时间复杂度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0 && j >= 0; k--) {
            if (i >= 0 && nums1[i] > nums2[j]) nums1[k] = nums1[i--];
            else nums1[k] = nums2[j--];
        }

    }

}
