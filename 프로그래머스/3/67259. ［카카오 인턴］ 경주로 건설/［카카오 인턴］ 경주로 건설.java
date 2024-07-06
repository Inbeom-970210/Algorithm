import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        int len = board.length;
        int[][][] DP = new int[len][len][4];
        
        // row(0), col(1), dir(2), total(3)
        q.offer(new int[]{0, 0, -1, 0});
        
        // BFS + DP를 사용한 최솟값 구하기
        // 1. 좌표에 진입하는 방향을 고려한 3차원 배열 DP
        // 2. 좌표에 처음 진입 or 최소 비용이면 DP 갱신
        // 3. 도착지의 DP에서 0이 아닌 최솟값을 구함 
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int dir = cur[2];
            int cost = cur[3];
            
            // 다음 좌표를 고려 
            for(int d = 0; d < 4; d++) {
                int nextR = row + move[d][0];
                int nextC = col + move[d][1];
                
                // 도면 내, 빈공간에서만 이동
                if(nextR < 0 || nextR >= len || nextC < 0 || nextC >= len) continue;
                if(board[nextR][nextC] == 1) continue;
                
                // 총비용 계산: 100(1.첫 이동 2. 동일 방향), 600(다른 방향)
                int total = cost;
                if(dir == -1 || d == dir) total += 100;
                else total += 600;
                
                // 첫방문 혹은 최소비용 방문이면 갱신
                if(DP[nextR][nextC][d] == 0 || DP[nextR][nextC][d] > total) {
                    q.offer(new int[]{nextR, nextC, d, total});
                    DP[nextR][nextC][d] = total;
                }
            }
            
        }
        
        // 도착지의 DP에서 0이 아닌 최솟값을 구함 
        for(int val : DP[len - 1][len - 1]) {
            System.out.println(val);
            if(val == 0) continue;
            answer = Math.min(answer, val);
        }
        return answer;
    }
}