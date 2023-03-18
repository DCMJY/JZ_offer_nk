
/*
Linked_List.JZ6 从尾到头打印链表
*/

/*
注意：用递归思想，或者栈
判断head ，递归add

递归时间复杂度 O(n) 其中n为链表长度，递归遍历一次链表
    空间复杂度 O(n) 递归栈的最大空间为链表长度
 */

package Linked_List.JZ6;
import java.util.ArrayList;


public class Solution1{
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        method1 s = new method1();
        ArrayList<Integer> l = s.printListFromTailToHead(listNode1);
        System.out.println(l);
    }
}


class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}

 class method1 {
    //递归函数
    public void recursion(ListNode head, ArrayList<Integer> res){
        if(head != null){
            //先往链表深处遍历
            recursion(head.next, res);
            //再填充到数组就是逆序
            res.add(head.val);
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //递归函数解决
        recursion(listNode, res);
        return res;
    }
}

