package leetcode;

import dataStructure.ListNode;

public class Solution_147 {

    /**
     * 对链表进行插入排序
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode iterator = head;
        int max = iterator.val;
        while (iterator.next != null) {
            ListNode TMP = iterator.next;
            if (TMP.val >= max) {
                max = TMP.val;
                iterator = TMP;
            } else {
                iterator.next = TMP.next;
                head = insertListNode(head, TMP);
            }
        }
        return head;
    }

    private ListNode insertListNode(ListNode head, ListNode TMP) {
        if (TMP.val <= head.val) {
            TMP.next = head;
            return TMP;
        }
        ListNode iterator = head;
        while (iterator != TMP && iterator.next != TMP) {
            if (iterator.val < TMP.val && iterator.next.val >= TMP.val) {
                TMP.next = iterator.next;
                iterator.next = TMP;
                break;
            }
            iterator = iterator.next;
        }
        return head;
    }

}
