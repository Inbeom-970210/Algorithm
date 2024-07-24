import java.util.*;

class Solution {
    private boolean[] visited;
    private Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(0, "", numbers);
        
        for(Integer num : set) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void dfs(int depth, String str, String numbers) {
        if(depth == numbers.length()) return;
        
        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            set.add(Integer.parseInt(str + numbers.charAt(i)));
            dfs(depth + 1, str + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int div = 2; div <= Math.sqrt(num); div++) {
            if(num % div == 0) return false; 
        }
        return true;
    }
    
}