/*
删除链表中重复的结点
 */

package Linked_List.JZ76_mid;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode res = new ListNode(0),cur=pHead,temp=res;
        if(pHead == null || pHead.next == null) return pHead;

        res.next = pHead;
        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                temp = temp.next;
                cur = cur.next;
            }else{
                while(cur.next!=null && cur.val == cur.next.val) cur = cur.next;
                temp.next = cur.next;
                cur = cur.next;
            }
        }
        return res.next;
    }
}

