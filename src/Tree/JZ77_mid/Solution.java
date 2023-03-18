/*
按之字形顺序打印二叉树

时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次，占用 O(N) ；
                双端队列的队首和队尾的添加和删除操作的时间复杂度均为 O(1) 。
空间复杂度 O(N) ： 最差情况下，即当树为满二叉树时，最多有N/2 个树节点
                   同时 在 deque 中，使用 O(N) 大小的额外空间。

作者：jyd
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package Tree.JZ77_mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null) queue.add(pRoot);
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();//双向队列
            for (int i = queue.size(); i > 0; i--){ //这里不能从0到size，因为poll会改变size
                TreeNode node = queue.poll();
                if (res.size() % 2==0) temp.addLast(node.val); //奇数层，按照正常队列放
                else temp.addFirst(node.val); //偶数层
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            res.add(new ArrayList(temp));
        }
        return res;
    }
}
