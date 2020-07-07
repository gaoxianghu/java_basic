package leetcode;

import dataStructure.ListNode;

public class Solution_21 {

    /**
     * 合并两个有序链表
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        /**
         * 方法一：l1指向长的链表，遍历l2节点，插入到l1链表合适位置
         */
//        int l1Len = getListLength(l1);
//        int l2Len = getListLength(l2);
//        ListNode tmp;
//        if (l2Len > l1Len) {
//            tmp = l1;
//            l1 = l2;
//            l2 = tmp;
//        }
//        ListNode l1_iterator = l1;
//        ListNode l2_iterator = l2;
//        while (l2_iterator != null) {
//            tmp = l2_iterator.next;
//            if (l2_iterator.val >= l1_iterator.val) {
//                while (l1_iterator.next != null && l1_iterator.next.val <= l2_iterator.val) {
//                    l1_iterator = l1_iterator.next;
//                }
//                l2_iterator.next = l1_iterator.next;
//                l1_iterator.next = l2_iterator;
//                l1_iterator = l1_iterator.next;
//            } else {
//                l2_iterator.next = l1;
//                l1 = l2_iterator;
//                l1_iterator = l1;
//            }
//            l2_iterator = tmp;
//        }
        /**
         * 方法二：引入哑节点，指针pre是完整链表的遍历指针
         */
//        ListNode pre = new ListNode(-1), res = pre;
//        while (l1 != null && l2 != null) {
//            if (l2.val < l1.val) {
//                pre.next = l2;
//                l2 = l2.next;
//            } else {
//                pre.next = l1;
//                l1 = l1.next;
//            }
//            pre = pre.next;
//        }
//        if (l1 != null) pre.next = l1;
//        if (l2 != null) pre.next = l2;
//        return res.next;
        /**
         * 方法三：两个链表头部值较小的一个节点与剩下元素的 merge 操作结果合并
         */
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    private int getListLength(ListNode l1) {
        int res = 0;
        ListNode tmp = l1;
        while (tmp != null) {
            res++;
            tmp = tmp.next;
        }
        return res;
    }


}
