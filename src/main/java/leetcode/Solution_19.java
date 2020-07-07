package leetcode;

import dataStructure.ListNode;

public class Solution_19 {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 给定一个链表: 0->1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 0->1->2->3->5.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        /**
         * 要有头结点，否则若倒数第n个节点刚好是head会出错
         */
        ListNode tmpNode = new ListNode(0);
        tmpNode.next = head;
        ListNode fastNode = tmpNode, slowNode = tmpNode;
        while (n > 0 && fastNode != null) {
            fastNode = fastNode.next;
            n--;
        }
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;

        return tmpNode.next;
    }
}
