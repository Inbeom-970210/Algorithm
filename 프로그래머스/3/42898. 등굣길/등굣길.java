class Solution {
    private Integer[][] DP;
    
    public int solution(int m, int n, int[][] puddles) {
        
        DP = new Integer[n + 1][m + 1];
        DP[1][1] = 1;
        for(int[] puddle : puddles) {
            int row = puddle[1];
            int col = puddle[0];
            DP[row][col] = 0;
        }
        
        int answer = function(n, m);
        return answer;
    }
    
    public int function(int row, int col) {
        if(row == 0 || col == 0) return 0;
        
        if(DP[row][col] == null) {
            DP[row][col] = (function(row - 1, col) + function(row, col - 1)) % 1000000007;
        }
        return DP[row][col];
    }
    
}