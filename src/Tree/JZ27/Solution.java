/*
二叉树的镜像

时间复杂度 O(n):遍历 N的节点数量
空间复杂度 O(n):最差情况下（当二叉树退化为链表），递归时系统需使用 O(N) 大小的栈空间。

https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/solution/mian-shi-ti-27-er-cha-shu-de-jing-xiang-di-gui-fu-/
 */

package Tree.JZ27;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot== null) return null;
        TreeNode leftNode = Mirror(pRoot.right);
        TreeNode rightNode = Mirror(pRoot.left);
        pRoot.left = leftNode;
        pRoot.right = rightNode;

        return pRoot;
    }
}
