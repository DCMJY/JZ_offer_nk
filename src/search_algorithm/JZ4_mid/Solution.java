/*
二维数组中的查找
时间复杂度 O(M+N) ：其中，N 和 M 分别为矩阵行数和列数，此算法最多循环 M+N 次。
空间复杂度 O(1) : i, j 指针使用常数大小额外空间。

作者：jyd
https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package search_algorithm.JZ4_mid;

public class Solution {
    public boolean Find(int target, int [][] array) {
        int i = array.length - 1, j = 0;
        while (i >= 0 && j <= array[0].length - 1) {
            if (target < array[i][j]) i--;
            else if (target > array[i][j]) j++;
            else return true;
        }
        return false;
    }
}
