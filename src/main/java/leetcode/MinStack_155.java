package leetcode;

import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

// 155

/**
 * 方法1.用额外一个数组做排序
 * 方法2.用额外一个栈，栈顶保持最小元素
 */
public class MinStack_155 {
    private Stack<Integer> stack;
    private List<Integer> list = new ArrayList<>();
    /** initialize your data structure here. */
    public MinStack_155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
    }

    public void pop() {
        list.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Collections.sort(list);
        return list.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */