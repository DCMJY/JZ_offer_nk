/*
二叉树中和为某一值的路径(三)

时间复杂度：O(n2)，其中 n为二叉树的结点数，两层 dfs嵌套递归
空间复杂度：O(n)，每层 dfs最深递归栈都只有 n
 */

package Tree.JZ84;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    int count = 0;
    public int FindPath (TreeNode root, int sum) {
        // write code here
        if(root == null) return count;
        preorder(root,sum);
        FindPath(root.left, sum );
        FindPath(root.right, sum );
        return count;
    }

    public void preorder(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) count++;
        preorder(root.left, sum - root.val);
        preorder(root.right, sum - root.val);
    }
}
