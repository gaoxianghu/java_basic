package leetcode;

import dataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution0201 {
    /**
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode iterator = head;
        set.add(iterator.val);
        while (iterator != null && iterator.next != null) {
            if (set.contains(iterator.next.val)) {
                iterator.next = iterator.next.next;
            } else {
                set.add(iterator.next.val);
                iterator = iterator.next;
            }
        }

        return head;
    }
}
