class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int N = board.length;
        int M = board[0].length;
        
        // 풀이: 누적합 -> 시간복잡도를 O(N * M * skill.length)에서 O(N * M)으로 줄일 수 있다.
        // 1. skill 정보를 누적합 배열 sum에 반영
        // 2. sum을 좌 -> 우, 상 -> 하 누적합 진행
        // 3. board에 sum을 합쳐서 answer를 구함
        int[][] sum = new int[N + 1][M + 1];
        for(int[] each : skill) {
            int type = each[0];
            int r1 = each[1];
            int c1 = each[2];
            int r2 = each[3];
            int c2 = each[4];
            int degree = each[5];
            if(type == 1) degree *= -1;
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        for(int r = 0; r < N; r++) {
            for(int c = 1; c < M; c++) {
                sum[r][c] += sum[r][c - 1];
            }
        }
        
        for(int c = 0; c < M; c++) {
            for(int r = 1; r < N; r++) {
                sum[r][c] += sum[r - 1][c];
            }
        }
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(board[r][c] + sum[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
}