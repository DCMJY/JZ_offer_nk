/*
在二叉树中找到两个节点的最近公共祖先

时间复杂度 O(N) ： 其中 N 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
空间复杂度 O(N) ： 最差情况下，递归深度达到 N ，系统使用 O(N) 大小的额外空间。

作者：jyd
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
package Tree.JZ86_mid;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        return recur(root,o1,o2).val;
    }

    public TreeNode recur(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            //只要当前根节点是p和q中的任意一个，就返回（如果在同一侧，先找到的就是公共节点）
            return root;
        }
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode L = recur(root.left, o1, o2);
        TreeNode R = recur(root.right, o1, o2);

        //左子树没有o1也没有o2，说明都在右子树
        if (L == null) {
            return R;
        }
        //有子树没有o1也没有o2，说明都在左子树
        if (R == null) {
            return L;
        }
        //o1,o2在异侧，根节点就是公共节点
        return root;
    }
}
