/*
正则表达式匹配

时间复杂度 O(MN) ： 其中 M,N 分别为 s 和 p 的长度，状态转移需遍历整个 dp 矩阵。
空间复杂度 O(MN) ： 状态矩阵 dp 使用 O(MN) 的额外空间

作者：jyd
https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/jian-zhi-offer-19-zheng-ze-biao-da-shi-pi-pei-dong/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package Dynamic_Programming.JZ19_HARD;

public class Solution {

    // 最直观版
    public boolean match(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();
        // dp[i][j]表示s前i-1个字符,p前j-1个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0] :s前0个字符和p的前0个字符默认是空串=匹配
        // 注意：由于多了[0][0],所以dp[i][j],定位到的是s[i-1]和p[j-1]的字符
        dp[0][0] = true;
        //当s为空时，p必须满足a*b*.*这样的结构才能匹配成空串
        //当s不为空，p为空为false
        for (int j = 2; j < n + 1; j += 2) {
            dp[0][j] = dp[0][j - 2] && pattern.charAt(j - 1) == '*';
        }
        // 状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 当p[j-1]=*时,有三种情况
                if (pattern.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) {// p[j-2]出现0次,i和j指向字符的长度均相同
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && str.charAt(i - 1) == pattern.charAt(j - 2)) {// p[j-2]出现1次 且 当前i-1和j-2指向的字符相同
                        dp[i][j] = true;
                    } else if (dp[i - 1][j] && pattern.charAt(j - 2) == '.') {// 最特殊情况:p[j-2]=. p[j-1]=*时 是万能匹配
                        dp[i][j] = true;
                    }
                } else {// 当p[j-1]!=*时,有两种情况
                    if (dp[i - 1][j - 1] && str.charAt(i - 1) == pattern.charAt(j - 1)) {// 前面元素之前都匹配 且 当前元素也相容
                        dp[i][j] = true;
                    } else if (dp[i - 1][j - 1] && pattern.charAt(j - 1) == '.') { //  前面元素之前都匹配 且 p的当期元素是.
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
