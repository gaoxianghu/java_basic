package leetcode;

import org.junit.Test;

public class MinStack155Test {

    @Test
    public void test() {
        leetcode.MinStack_155 minStack155 = new leetcode.MinStack_155();
        minStack155.push(-2);
        minStack155.push(0);
        minStack155.push(-3);
        int a = minStack155.getMin();
        minStack155.pop();
        int b = minStack155.top();
        int c = minStack155.getMin();
    }

}