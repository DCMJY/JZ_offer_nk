/*
 旋转数组的最小数字

时间复杂度 O(log2N) ：在特例情况下（例如 [1,1,1,1]），会退化到 O(N)。
空间复杂度 O(1) ： m 变量使用常数大小的额外空间。

作者：jyd
https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package search_algorithm.JZ11_hard;


public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (array[mid] > array[j]) i = mid + 1;
            else if (array[mid] < array[j]) j = mid;
            else j--;
        }
        return array[i];
    }
}
