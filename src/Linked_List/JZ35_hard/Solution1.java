/*
复杂链表的复制

时间复杂度 O(N) ：两轮遍历链表，使用 O(N) 时间
空间复杂度 O(N) ：哈希表 dic 使用线性大小的额外空间

解析
https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
 */

package Linked_List.JZ35_hard;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution1 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode cur = pHead;
        //1.复制链表并结合
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;//保存下个节点位置
            cur.next = temp;
            cur = temp.next;
        }

        //2.将复制的节点赋予random
        cur = pHead;
        while (cur != null) {         //while的判断条件注意
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //3.拆分成两条链表
        cur = pHead;
        RandomListNode tempB = pHead.next,res = pHead.next;
        while (cur.next.next != null) {
            cur.next = cur.next.next;
            tempB.next = tempB.next.next;
            cur = cur.next;
            tempB = tempB.next;
        }
        cur.next = null;
        return res;




    }
}
