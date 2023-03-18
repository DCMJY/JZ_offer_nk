package Linked_List.JZ35_hard;

import java.util.HashMap;

public class Solution2 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode cur = pHead;
        //这里的泛型要注意，不加的话map.get默认返回的是Object需要强转
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        // 重构next和random
        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}
