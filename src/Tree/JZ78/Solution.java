/*
把二叉树打印成多行

时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，
                   使用 O(N) 大小的额外空间。

作者：jyd
链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/mian-shi-ti-32-ii-cong-shang-dao-xia-da-yin-er-c-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Tree.JZ78;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<ArrayList<Integer> > res = new ArrayList<>();

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        if (pRoot == null) return res;

        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode root = queue.poll();
                tempList.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            res.add(new ArrayList(tempList));
        }
        return res;
    }
}
