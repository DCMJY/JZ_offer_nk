/*
用两个栈实现队列
时间复杂度：O(1) ； 函数在 N 次队首元素删除操作中总共需完成 N 个元素的倒序。
空间复杂度 O(N) ： 最差情况下，栈 A 和 B 共保存 N 个元素。

作者：jyd
https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package queueANDstack.JZ9;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}