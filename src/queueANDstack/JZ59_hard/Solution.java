package queueANDstack.JZ59_hard;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> integers = maxInWindows(num, 3);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if (num.length == 0 || size == 0 || num.length < size) return res;

        // 未形成窗口
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && deque.peekLast() < num[i])
                deque.removeLast();
            deque.addLast(num[i]);
        }
        res.add(deque.peekFirst());
        // 形成窗口后
        for (int i = size; i < num.length; i++) {
            //[2,3,4,2,6,2,5,1],3 如果不加会输出[4,4,6,6,6,6]
            //而需要[4,4,6,6,6,5],所以要在滑窗外判断下
            if (deque.peekFirst() == num[i - size])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < num[i])
                deque.removeLast();
            deque.addLast(num[i]);
            res.add(deque.peekFirst());
        }
        return res;
    }
}

