/*
包含min函数的栈
时间复杂度 O(1) ： push(), pop(), top(), min() 四个函数的时间复杂度均为常数级别。
空间复杂度 O(N) ： 当共有 N 个待入栈元素时，辅助栈 B 最差情况下存储 N 个元素，使用 O(N) 额外空间。

作者：jyd
https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */

package queueANDstack.JZ30;

import java.util.Stack;

public class Solution {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public void push(int node) {
        A.push(node);
        if(B.empty() || B.peek() >= node){
            B.push(node);
        }
    }

    public void pop() {
        // ==将会无法通过 Integer的equals重写过，比较的是内部value的值，
        // ==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
        if(A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
