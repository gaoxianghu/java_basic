package leetcode;

import dataStructure.ListNode;
import org.junit.Test;
import tools.ListNodeTool;

import static org.junit.Assert.*;

public class Solution0201Test {
    /**
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     *
     */
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = null;
        ListNodeTool.show(head);
        ListNodeTool.show(Solution0201.removeDuplicateNodes(head));
    }

}