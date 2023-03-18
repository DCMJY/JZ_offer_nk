/*
二叉搜索树与双向链表

空间复杂度O(1)（即在原树上操作），
时间复杂度O(n)

https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
 */

package Tree.JZ36;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {
    TreeNode pre, head;

    public TreeNode Convert(TreeNode pRootOfTree) {
        dfs(pRootOfTree);
        return head;
    }

    private void dfs(TreeNode root) {
        //遍历到左子树
        if (root == null) return;
        dfs(root.left);
        //初始化
        if (pre == null) {
            pre = root;
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        dfs(root.right);
    }
}
