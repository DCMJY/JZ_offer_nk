/*
链表中倒数最后k个结点

时间复杂度 O(N) ：N 为链表长度；总体看， former 走了 N步， latter 走了 (N−k) 步。
空间复杂度 O(1) ：双指针额外空间。

https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/mian-shi-ti-22-lian-biao-zhong-dao-shu-di-kge-j-11/
*/

package Linked_List.JZ22;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead, slow = pHead;
        int size = 0;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null; //注意这个判断不能写成 pHead
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

        }

        return slow;

    }
}