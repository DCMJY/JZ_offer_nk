/*
两个链表的第一个公共结点

解法两个链表长度分别为L1+C、L2+C， C为公共部分的长度，按照楼主的做法：
第一个人走了L1+C步后，回到第二个人起点走L2步；第2个人走了L2+C步后，
回到第一个人起点走L1步。 当两个人走的步数都为L1+L2+C时就两个家伙就相爱了

注意：假如两个链表没有公共节点，就把NULL当作它们的公共节点，
      所以两个判断是X!=NULL而不是X.next!=NULL

时间复杂度 O(M+N) ： 最差情况下（即 ∣a−b∣=1 , c=0 ），此时需遍历 a+b 个节点。
空间复杂度 O(1) ：节点指针 A , B 使用常数大小的额外空间。
 */

package Linked_List.JZ52;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode A = pHead1, B = pHead2;
        while (A != B) {
            A = A != null ? A.next : pHead2;
            B = B != null ? B.next : pHead1;
        }
        return A;
    }
}