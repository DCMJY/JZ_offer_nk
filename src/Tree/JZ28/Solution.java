/*
对称的二叉树

时间复杂度 O(N) ： 其中 N 为二叉树的节点数量，每次执行 recur()
                    可以判断一对节点是否对称，因此最多调用 /2N/2 次 recur() 方法。
空间复杂度 O(N) ： 最差情况下（见下图），二叉树退化为链表，系统使用 O(N)大小的栈空间。


作者：jyd
链接：https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Tree.JZ28;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null ? true : recur(pRoot.left, pRoot.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);

    }
}

