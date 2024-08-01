import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {
        int[] DP = new int[y + 1];

        for(int i = x; i <= y; i++) {
            // x보다 크고 연산 값보다 작으면 -1
            if(i > x && DP[i] == 0) {
                DP[i] = -1;
                continue;
            }
            
            // +n 연산
            if(i + n <= y) {
                if(DP[i + n] == 0) DP[i + n] = DP[i] + 1;
                else DP[i + n] = Math.min(DP[i] + 1, DP[i + n]);
            }
            
            // *2 연산
            if(i * 2 <= y) {
                if(DP[i * 2] == 0) DP[i * 2] = DP[i] + 1;
                else DP[i * 2] = Math.min(DP[i] + 1, DP[i * 2]);
            }
            
            // *3 연산
            if(i * 3 <= y) {
                if(DP[i * 3] == 0) DP[i * 3] = DP[i] + 1;
                else DP[i * 3] = Math.min(DP[i] + 1, DP[i * 3]);  
            }
        }
        
        return DP[y];
    }
}