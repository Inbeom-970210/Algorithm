class Solution {
    private int answer;
    
    public int solution(int storey) {
        answer = storey;
        
        dfs(storey, 0);
        
        return answer;
    }
    
    public void dfs(int storey, int cnt) {
        if(cnt >= answer) return;
        if(storey == 0) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        int num = storey % 10;
        dfs(storey / 10, cnt + num);
        dfs(storey / 10 + 1, cnt + 10 - num);
    }
    
}