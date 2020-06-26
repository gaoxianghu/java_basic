package tools;

import dataStructure.ListNode;

public class ListNodeTool {

    public static void show(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

}
