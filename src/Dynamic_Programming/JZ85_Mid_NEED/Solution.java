package Dynamic_Programming.JZ85_Mid_NEED;

import java.util.*;
public class Solution {public static void main(String[] args) {
    System.out.println(Arrays.toString(Solution.FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5})));
}
    public static int[] FindGreatestSumOfSubArray (int[] array) {
        int x = array[0];
        int y = 0;
        int maxsum = x;
        //滑动区间
        int left = 0, right = 0;
        //记录最长的区间
        int resl = 0, resr = 0;
        for(int i = 1; i < array.length; i++){
            right++;
            //状态转移：连续子数组和最大值
            y = Math.max(x + array[i], array[i]);
            //区间新起点
            if(x + array[i] < array[i])
                left = right;
            //更新最大值
            if(y > maxsum || y == maxsum && (right - left + 1) > (resr - resl + 1)){
                maxsum = y;
                resl = left;
                resr = right;
            }
            //更新x的状态
            x = y;
        }
        //取数组
        int[] res = new int[resr - resl + 1];
        for(int i = resl; i <= resr; i++)
            res[i - resl] = array[i];
        return res;
    }
}

