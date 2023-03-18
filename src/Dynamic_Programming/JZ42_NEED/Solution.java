/*
连续子数组的最大和

时间复杂度 O(N) ： 线性遍历数组 nums 即可获得结果，使用 O(N) 时间。
空间复杂度 O(1) ： 使用常数大小的额外空间

以某个数作为结尾，意思就是这个数一定会加上去，
那么要看的就是这个数前面的部分要不要加上去。大于零就加，小于零就舍弃。
****理解好状态定义****

作者：jyd
https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Dynamic_Programming.JZ42_NEED;

class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
