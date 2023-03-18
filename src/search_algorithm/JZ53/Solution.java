/*
数字在升序数组中出现的次数
 */

package search_algorithm.JZ53;

public class Solution {
    public int GetNumberOfK(int [] array, int k) {
        // 找到左边界
        int first = binarySearch(array, k);
        // 找到右边界（注意：k+1）
        int last = binarySearch(array, k + 1);
        // 若超出数组范围，则证明目标值出现的次数为0，否则，右边界减去左边界即能统计出目标出现的次数
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    public int binarySearch(int [] array, int k) {
        // 左右边界
        int left = 0, right = array.length;
        while (left < right) {
            // 二分求中点,注意这里的 mid
            int mid = left + (right - left) / 2;
            if (array[mid] >= k)
                right = mid;
            else
                left = mid + 1;
        }
        // 返回左边界
        return left;
    }
}
