/*
二叉树的深度
主要用后序遍历和层序遍历两种方法
https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/
 */

package Tree.JZ55;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//按照dfs
public class Solution {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

//按照bfs
class Solution2 {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()){  //注意不能写成 !=null
            res ++;
            for (int i=0; i<queue.size();i++){
                TreeNode node = queue.poll();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return res;
    }
}