import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        PriorityQueue<Long> pq = new PriorityQueue<>();
                
        for(String ban : bans) {
            getNum(pq, ban);
        }
        
        while(!pq.isEmpty()) {
            if(pq.poll() <= n)
                n++;
            else 
                break;
        }
        
        Stack<String> stack = new Stack<>();
        while(n > 26) {
            long cur = n % 26;
            if(0 == cur) {
                n = n / 26 - 1;
                stack.push("z");
            } else {
                n /= 26;
                stack.push("" + (char) ('a' + cur - 1));
            }
        }
        stack.push("" + (char) ('a' + n - 1));
        
        
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
                
        return answer;
    }
    
    private void getNum(PriorityQueue pq, String ban) {
        long total = 0;
        long base = 1;
        for(int i = ban.length() - 1; i >= 0; i--) {
            int num = ban.charAt(i) - 'a' + 1;
            total += num * base;
            base *= 26;
        }
        
        pq.offer(total);
    }
}