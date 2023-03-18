/*
二叉搜索树的最近公共祖先，和 JZ86一起看
时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N （退化为链表）。
空间复杂度 O(1) ： 使用常数大小的额外空间

作者：jyd
链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Tree.JZ68;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

//public class Solution {
//    public int lowestCommonAncestor(TreeNode root, int p, int q) {
//        // write code here
//        while (root != null) {
//            //都在右子树
//            if (root.val < p && root.val < q) {
//                root = root.right;
//            }
//            //都在左子树
//            if (root.val > p && root.val > q) {
//                root = root.left;
//            }
//            break;
//        }
//        return root.val;
//    }
//}
