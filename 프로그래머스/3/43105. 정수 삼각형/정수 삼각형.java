import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] DP = new int[len][];
        for(int i = 0; i < len; i++) {
            int[] arr = new int[triangle[i].length];
            Arrays.fill(arr, -1);
            DP[i] = arr;
        }
        
        for(int i = 0; i < len; i++) {
            DP[len - 1][i] = triangle[len - 1][i];
        }
        
        return calculMaxSum(0, 0, DP, triangle);
    }
    
    public int calculMaxSum(int row, int col, int[][] DP, int[][] triangle) {
        if(-1 == DP[row][col]) {
            DP[row][col] = Math.max(
                calculMaxSum(row + 1, col, DP, triangle),
                calculMaxSum(row + 1, col + 1, DP, triangle)
            ) + triangle[row][col];
        }
        
        return DP[row][col];
    }
}