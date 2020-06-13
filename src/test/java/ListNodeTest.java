import dataStructure.LinkNode;
import org.junit.Test;

public class ListNodeTest {

    @Test
    public void testPath() throws Exception {
        String path = this.getClass().getResource("").getPath();
        System.out.println("result is:" + path);
        System.out.println("user.dir"+System.getProperty("user.dir"));
//      System.out.println( System.getProperty("java.class.path"));
    }

    @Test
    public void testLinkNode() throws Exception {
        //头节点和尾节点都为空 链表为空
        LinkNode<String> head = null;
        LinkNode<String> tail = null;
        //创建一个新的节点 并让head指向此节点
        head = new LinkNode<>("LinkNode data1");
        LinkNode<String> listNode2 = new LinkNode<>("LinkNode data2");
        head.next= listNode2;
        LinkNode<String> listNode3 = new LinkNode<>("LinkNode data3");
        listNode2.next= listNode3;
        listNode3.next=null;

        System.out.println("顺序遍历链表:");
        LinkNode<String> current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("倒序遍历链表:");
        printListRev(head);

        System.out.println(2^3);
    }

    void printListRev(LinkNode<String> head) {
        //倒序遍历链表主要用了递归的思想
        if (head != null) {
            printListRev(head.next);
            System.out.println(head.item);
        }
    }

}