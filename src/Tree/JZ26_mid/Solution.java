/*
树的子结构

时间复杂度 O(MN) ： 其中 M,N 分别为树 A 和 树 B 的节点数量；
                    先序遍历树 A 占用 O(M) ，每次调用 recur(A, B) 判断占用 O(N) 。
空间复杂度 O(M) ： 当树 A 和树 B 都退化为链表时，递归调用深度最大。
                    当 M≤N 时，遍历树 A 与递归判断的总递归深度为 M ；
                    当 M>N 时，最差情况为遍历至树 A 叶子节点，此时总递归深度为 M。

作者：jyd
https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Tree.JZ26_mid;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        //判断头节点
        else {
            return recur(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
    }

    //递归判断子树，注意要先判断root2==null
    public boolean recur(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        } else {
            return recur(root1.left, root2.left) && recur(root1.right, root2.right);
        }
    }
}

//改进
//class Solution {
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
//    }
//    boolean recur(TreeNode A, TreeNode B) {
//        if(B == null) return true;
//        if(A == null || A.val != B.val) return false;
//        return recur(A.left, B.left) && recur(A.right, B.right);
//    }
//}
