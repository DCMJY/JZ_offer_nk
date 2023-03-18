/*
删除链表节点

时间复杂度 O(N) ：N 为链表长度，平均 N/2，最差 N
空间复杂度 O(1) ：双指针额外空间。
 */

package Linked_List.JZ18;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param val int整型
     * @return ListNode类
     */
    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        ListNode pre = head,cur = head.next;
        if(head.val == val) return cur;
        while(cur != null && cur.val != val ){
            pre = pre.next;
            cur = cur.next;
        }
        if(cur != null)pre.next = cur.next;
        return head;
    }
}