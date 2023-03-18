/*
链表中环的入口结点
 */

/*
解题思路：见力扣 k神
此类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第 k 个节点、
寻找环入口、寻找公共尾部入口等。
 */

package Linked_List.JZ23_mid;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}