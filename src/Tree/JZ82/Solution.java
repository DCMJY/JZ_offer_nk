/*
二叉树中和为某一值的路径(一)

时间复杂度：O(n)，其中n为二叉树所有节点，前序遍历二叉树所有节点
空间复杂度：O(n)，最坏情况二叉树化为链表，递归栈空间最大为n
 */

package Tree.JZ82;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //这里不用判断sum<0，因为有可能是-2+2这种情况
        if (root == null) {
            return false;
        }
        //sum - root.val==0 这个条件不能单独一行写出来，会有错误
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);

    }
}
