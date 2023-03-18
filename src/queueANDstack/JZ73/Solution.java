/*
翻转单词序列
 */
package queueANDstack.JZ73;

import java.util.*;

public class Solution {
    public String ReverseSentence(String str) {
        String[] strs = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals(" ")) continue;
            sb.append(strs[i] + " ");
        }
        return sb.toString().trim();
    }
}

