/*
矩阵中的路径

时间复杂度 O(3^K MN) ：最差情况下，需要遍历矩阵中长度为 K 字符串的所有方案，时间复杂度为 O(3^K)；矩阵中共有 MN 个起点，时间复杂度为 O(MN) 。
                    方案数计算： 设字符串长度为 K ，搜索中每个字符有上、下、左、右四个方向可以选择，舍弃回头（上个字符）的方向，
                    剩下  3 种选择，因此方案数的复杂度为 O(3^K)。
空间复杂度 O(K) ： 搜索过程中的递归深度不超过 K ，因此系统因函数调用累计使用的栈空间占用 O(K)
                 （因为函数返回后，系统调用的栈空间会释放）。最坏情况下 K=MN ，
                  递归深度为 MN ，此时系统栈使用 O(MN) 的额外空间。

作者：jyd
https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

package huishuo.JZ12_mid;

public class Solution {
    public boolean hasPath (char[][] matrix, String word) {
        char[] words = word.toCharArray();
        //不一定是从左上角开始，所以需要遍历整个矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                if (dfs(matrix, words, i, j, 0)) {
                    return true;
                }
        }
        return false;
    }

    boolean dfs(char[][] matrix, char[] words, int i, int j, int k) {
        //越界
        if(i<0 || j<0 || i>=matrix.length || j>= matrix[0].length || matrix[i][j] != words[k]){
            return false;
        }
        //最后一位
        if(k == words.length -1){
            return true;
        }

        matrix[i][j] = '\0';
        boolean res = dfs(matrix, words, i + 1, j, k + 1) ||
                dfs(matrix, words, i - 1, j, k + 1) ||
                dfs(matrix, words, i, j+1, k + 1) ||
                dfs(matrix, words, i, j-1, k + 1);
        //重置回原来的数值，因为后面的路径不一定正确，需要回溯
        matrix[i][j] = words[k];
        return res;
    }
}
