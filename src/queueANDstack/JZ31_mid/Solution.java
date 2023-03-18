/*
栈的压入、弹出序列

时间复杂度 O(N) ： 其中N 为列表pushed 的长度；每个元素最多入栈与出栈一次，即最多共2N 次出入栈操作。
空间复杂度 O(N) ： 辅助栈stack 最多同时存储N 个元素。

作者：jyd
https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package queueANDstack.JZ31_mid;

import java.util.*;

public class Solution {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    public boolean IsPopOrder(int [] pushA, int [] popA) {
        for (int element : pushA) {
            stack.push(element);
            while (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}