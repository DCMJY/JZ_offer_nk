/*
二叉搜索树的后序遍历序列

时间复杂度 O(N2) ： 每次调用 recur(i,j) 减去一个根节点，因此递归占用 O(N) ；
                    最差情况下（即当树退化为链表），每轮递归都需遍历树所有节点，占用 O(N) 。
空间复杂度 O(N) ： 最差情况下（即当树退化为链表），递归深度将达到 N

作者：jyd
链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
package Tree.JZ33_mid;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return recur(sequence, 0, sequence.length - 1);
    }

    public boolean recur(int[] sequence, int i, int j) {
        if (i >= j) return true;
        //f为第一大于根节点的位置
        int f = i;
        while (sequence[f] < sequence[j]) f++;
        int l = f;
        while (sequence[f] > sequence[j]) f++;
        return f == j && recur(sequence, i, l - 1) && recur(sequence, l, j - 1);
    }
}