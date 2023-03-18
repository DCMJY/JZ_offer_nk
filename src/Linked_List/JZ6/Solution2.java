package Linked_List.JZ6;/*
时间复杂度：O(n)，遍历链表是一个O(n)，弹空一个栈需要O(n)
空间复杂度：O(n)，栈空间最大长度是链表的长度n
 */


import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        method2 s = new method2();
        ArrayList<Integer> l = s.printListFromTailToHead(listNode1);
        System.out.println(l);
    }
}

class method2{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()){
            res.add(stack.pop());
        }

        return res;
    }
}

