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
 */
public class Solution_1481 {

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
        /*
         * 4 1
         * 2 1
         * 1 2
         * 3 3
         * 元素个数排序 1 1 2 3
         */
        int size = res.size();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) <= k) {
                k = k - res.get(i);
                size--;
            } else {
                break;
            }
        }

        return size;
    }

}
