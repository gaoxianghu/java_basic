package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 arr 和一个整数 k 。
 * 现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *
 */
public class Solution_5437 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        List<Integer> res = map.values().stream().sorted().collect(Collectors.toList());

        int[] resSum = new int[res.size()];
        resSum[0] = res.get(0);

        for (int i = 1; i < res.size(); i++) {
            resSum[i] += resSum[i - 1] + res.get(i);
        }
        if (k < resSum[0]) {
            return resSum.length;
        }
        if (k == resSum[0]) {
            return resSum.length - 1;
        }

        for (int i = 1; i < resSum.length; i++) {
           if (resSum[i] == k) {
               return resSum.length - i - 1;
           }
           if (k < resSum[i] && k > resSum[i-1]) {
               return resSum.length - i;
           }
        }
        return 0;
    }
}
