class Solution {
    static boolean[] check;
    static int[] chess;
    static int len;
    static int res;
        
    public int solution(int n) {
        check = new boolean[n];
        chess = new int[n];   // 퀸을 놓은 체스판
        len = n;
        res = 0;
        
        dfs(0);
        
        return(res);
    }
    
    static void dfs(int depth) {
        if(depth == len) {
            // 결과 카운트
            res++;
            return;
        }
        
        value: for(int i = 0; i < len; i++) {
            // 열에 퀸이 있으면 다음
            if(check[i]) continue;
            
            // 대각선에 퀸이 있으면 다음
            for(int j = 0; j < depth; j++) {
                if(Math.abs(depth - j) == Math.abs(i - chess[j])) continue value;
            }
            
            check[i] = true;
            chess[depth] = i;
            dfs(depth + 1);
            check[i] = false;
        }
    }
    
}