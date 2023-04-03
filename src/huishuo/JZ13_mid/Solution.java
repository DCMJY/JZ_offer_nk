/*
机器人的运动范围

时间复杂度： O(MN)
空间复杂度： O(MN)
 */
package huishuo.JZ13_mid;

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return dfs(threshold, rows, cols, 0, 0, visited);
    }

    int dfs (int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= rows || j >= cols ||
                (i % 10 + i / 10 + j % 10 + j / 10) > threshold ||
                visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res = dfs(threshold, rows, cols, i + 1, j, visited) +
                dfs(threshold, rows, cols, i - 1, j, visited) +
                dfs(threshold, rows, cols, i, j + 1, visited) +
                dfs(threshold, rows, cols, i, j - 1, visited) + 1;

        return res;
    }
}