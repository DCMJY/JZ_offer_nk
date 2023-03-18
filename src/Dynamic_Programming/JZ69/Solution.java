/*
跳台阶
时间复杂度 O(N) ： 计算 f(n) 需循环 n 次，每轮循环内计算操作使用 O(1) 。
空间复杂度 O(1) ： 几个标志变量使用常数大小的额外空间。

作者：jyd
https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

n=1时 ：1
n=2 时：(1,1) (2)
n=3时：(1,2) (1,1,1) (2,1)
 n=4时：(1,1,2) (2,2) (1,2,1) (1,1,1,1) (2,1,1)
发现规律了： n=4中的(1,1,2) (2,2)是从n=2中跳2台阶得到的，(1,2,1) (1,1,1,1) (2,1,1)是从n=3中跳1台阶得到的
所以 n的跳法 = n-1 的跳法都跳一个台阶 + n-2的跳法都跳两个台阶
所以f(n) =f(n-1)+f(n-2)
 */

package Dynamic_Programming.JZ69;

public class Solution {
    public int jumpFloor(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        return jumpFloor(target-1) + jumpFloor(target-2);
    }
}
