/*
和JZ55有点区别，即本题需将 每一层打印到一行 。可一起学习
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/

 */


package Tree.JZ77_mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null) queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--){ //这里不能从0到size，因为poll会改变size
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
