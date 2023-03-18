/*
二叉树中和为某一值的路径(二)
时间复杂度 O(N) ： N 为二叉树的节点数，先序遍历需要遍历所有节点。
空间复杂度 O(N) ： 最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N) 额外空间。

作者：jyd
链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Tree.JZ34_mid;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //全局变量
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int tempSum = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int expectNumber) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root != null){
            recur(root,expectNumber,list);
        }
        return new ArrayList(res);
    }

    private void recur(TreeNode root,int expectNumber,LinkedList<Integer> list){
        list.add(root.val);
        tempSum += root.val;

        // 当前节点为叶子节点
        if (root.left == null && root.right == null){
            if (expectNumber == tempSum){
                res.add(new ArrayList(list));
            }
            return;
        }

        if (root.left != null){
            recur(root.left,expectNumber,list);
            // 回溯，去除 root.left
            list.removeLast();
            tempSum -= root.left.val;
        }
        if (root.right != null){
            recur(root.right,expectNumber,list);
            // 回溯，去除 root.right
            list.removeLast();
            tempSum -= root.right.val;
        }
    }
}
