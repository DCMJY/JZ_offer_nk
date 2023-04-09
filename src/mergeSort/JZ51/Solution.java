/*
数组中的逆序对

在递归过程中，每次将一个数组拆分成两个数组，因此递归树的深度为logn。而每层递归中的归并操作的时间复杂度为O(n)，因为需要遍历每个元素。
时间复杂度 logO(NlogN) ： 其中 N 为数组长度；归并排序使用 O(NlogN) 时间；
空间复杂度 O(N) ： 辅助数组 tmp 占用 O(N) 大小的额外空间；

作者：jyd
https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package mergeSort.JZ51;

public class Solution {
    int count;
    public int InversePairs(int[] array) {
        this.count = 0;
        merge(array, 0, array.length - 1);
        return count;
    }

    public void merge(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            merge(array, left, mid);
            merge(array, mid + 1, right);
            mergeSort(array, left, mid, right);
        }
    }

    public void mergeSort(int []array, int left, int mid, int right) {
        int[] tmparr = new int[right - left + 1];
        int index = 0;
        int tmp1 = left, tmp2 = mid + 1;

        while (tmp1 <= mid && tmp2 <= right) {
            if (array[tmp1] <= array[tmp2]) {
                tmparr[index++] = array[tmp1++];
            } else {
                //用来统计逆序对的个数
                //mid - tmp1 + 1不能写成tmp2-tmp1+1，这样写重复计算之前的
                count += mid - tmp1 + 1 ;
                count %= 1000000007;
                tmparr[index++] = array[tmp2++];
            }
        }

        //把剩余的数加进去
        while (tmp1 <= mid) {
            tmparr[index++] = array[tmp1++];
        }
        while (tmp2 <= right) {
            tmparr[index++] = array[tmp2++];
        }

        //把新数组中的数覆盖 array数组
        for (int k = 0; k < tmparr.length; k++) {
            array[k + left] = tmparr[k];
        }
    }
}
