/*
数组中重复的数字

作者：jyd
https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package shuzu.JZ3;

//时间复杂度 O(N) ： 遍历数组使用 O(N) ，每轮遍历的判断和交换操作使用 O(1) 。
//空间复杂度 O(N) ： HashSet表需要的空间
//public class Solution {
//    public int duplicate (int[] numbers) {
//        // write code here
//        Set<Integer> dic = new HashSet<Integer>();
//        for(int num : numbers){
//            if(!(dic.contains(num))){
//                dic.add(num);
//            }else{
//                return num;
//            }
//        }
//        return -1;
//    }
//}


//时间复杂度 O(N) ： 遍历数组使用 O(N) ，每轮遍历的判断和交换操作使用 O(1) 。
//空间复杂度 O(1) ： 使用常数复杂度的额外空间。
//记num[ i ] =a，num[num[ i ] ]=num[ a ]=b,那么 交换后，num[ i ]=b,
// num[num[i]]=num[a]=a，这时候下标 a 对应的元素也是a，达到目的
public class Solution {
    public int duplicate (int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            if(numbers[i]==i){
                i++;
                continue;
            }
            if(numbers[numbers[i]] == numbers[i]){
                return numbers[i];
            }
            int temp = numbers[i];
            numbers[i] = numbers[temp];
            numbers[temp] = temp;
        }
        return -1;
    }
}



