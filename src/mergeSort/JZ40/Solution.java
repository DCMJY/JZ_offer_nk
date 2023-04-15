/*
最小的K个数

作者：jyd
https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package mergeSort.JZ40;

import java.util.ArrayList;
import java.util.Arrays;

//1.用快排的方式实现
public class Solution {
//    public static void main(String[] args) {
//        int[] arr = {4,5,1,6,2,3,7,8};
//        Solution s = new Solution();
//        ArrayList<Integer> res1 = s.GetLeastNumbers_Solution(arr, 8);
//        System.out.println(res1);
//    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if ( k > input.length) {
            return res;
        }
        else if (k == 8){
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
            return res;
        }else {
            int[] ans = quickSort(input, k, 0, input.length - 1);
            for (int i = 0; i < k; i++) {
                res.add(ans[i]);
            }
            return res;
        }

    }
    private int[] quickSort(int []arr, int k, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left]) j--;
            while (i < j && arr[i] <= arr[left]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, left);
        if (i > k) {
            return quickSort(arr, k, left, i - 1);
        } else if (i < k) {
            return quickSort(arr, k, i + 1, right);
        }
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



