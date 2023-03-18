/*
二叉搜索树的第k个节点

时间复杂度 O(N)
空间复杂度 O(N)

二叉查找树，也称二叉搜索树，或二叉排序树。其定义也比较简单，要么是一颗空树，要么就是具有如下性质的二叉树：
（1）若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
（2） 若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
（3） 任意节点的左、右子树也分别为二叉查找树；
（4） 没有键值相等的节点。
（5） 中序遍历为递增序列
 */

package Tree.JZ54_mid;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int KthNode(TreeNode proot, int k) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if (proot == null || k <= 0) return -1;
        recur(proot, list, k);
        return list.size() >= k ? list.get(k - 1) : -1;
    }

    public void recur(TreeNode root, ArrayList<Integer> list, int k) {
        if (root == null || list.size() == k) return;
        if (root.left != null) recur(root.left, list, k);
        list.add(root.val);
        k++;
        if (root.right != null) recur(root.right, list, k);
    }
}
