package leetcode;

import java.util.*;

public class Solution_347 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        topKFrequent(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // PriorityQueue<Integer> queue = new PriorityQueue<>(k, (v1, v2) -> map.get(v1) - map.get(v2));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int j : map.keySet()) {
            queue.add(j);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int m = 0;
        while (!queue.isEmpty()) {
            res[m++] = queue.poll();
        }

        return res;
    }

}
