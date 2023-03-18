/*
把数字翻译成字符串

时间复杂度 O(N) ： N 为字符串 s 的长度（即数字 num 的位数 log(num)），其决定了循环次数。
空间复杂度 O(N) ： 字符串 s 使用O(N) 大小的额外空间

作者：jyd
https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Dynamic_Programming.JZ46_NEED;

public class Solution {

    public int solve (String nums) {
        //排除0
        if (nums.equals("0"))
            return 0;
        //排除只有一种可能的10 和 20
        if (nums.equals("10")  || nums.equals("20") )
            return 1;
        //当0的前面不是1或2时，无法译码，0种
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0')
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        int[] dp = new int[nums.length() + 1];
        //辅助数组初始化为1
        //dp[i]是以Xi为结尾翻译方案数量
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= nums.length(); i++) {
            //在11-19，21-26之间的情况
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') ||
                    (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' &&
                            nums.charAt(i - 1) < '7'))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[nums.length()];
    }
}

