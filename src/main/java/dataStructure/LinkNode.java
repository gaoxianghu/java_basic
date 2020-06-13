package dataStructure;

public class LinkNode<E> {
    public LinkNode<E> next;
    public int val;
    public E item;

    //构造函数
    public LinkNode(E element) {
        this.item = element;
        this.next = null;
    }

}


    