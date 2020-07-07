package sort;

import dataStructure.ListNode;
import leetcode.Solution_19;
import org.junit.Test;
import tools.ListNodeTool;

public class Solution_19Test {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNodeTool.show(Solution_19.removeNthFromEnd(head, 2));
    }


}