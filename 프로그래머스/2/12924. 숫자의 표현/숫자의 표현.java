class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 1; i < n; i++) {
            int sum = 0;
            for(int next = i; next < n; next++) {
                sum += next;
                if(sum >= n) break;
            }
            if(sum == n) answer++;
        }
        
        return answer;
    }
}