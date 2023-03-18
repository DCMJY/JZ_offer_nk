/*
矩形覆盖
 */
package Dynamic_Programming.JZ70;

public class Solution {
    public int rectCover(int target) {
        if(target==0) return 0;
        else if(target == 1) return 1;
        else if (target == 2) return 2;
        else return rectCover(target-1) + rectCover(target-2);
    }
}

