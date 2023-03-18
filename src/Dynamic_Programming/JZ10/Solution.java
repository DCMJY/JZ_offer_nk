/*
斐波那契数列
 */

package Dynamic_Programming.JZ10;

public class Solution {
    public int Fibonacci(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}

//优化 空间 0(n)->O(1)
//class Solution {
//    public int fib(int n) {
//        if(n == 0) return 0;
//        int fn0 = 0;
//        int fn1 = 1;
//        int temp;
//        for(int i = 2; i <= n; i++){
//            temp = fn0 + fn1;
//            fn0 = fn1;
//            fn1 = temp% 1000000007; // 每次运算都取模 避免越界
//        }
//        return fn1;
//    }
//}

