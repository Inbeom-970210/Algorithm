import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            pq.offer(work);
        }
        
        for(int i = 0; i < n; ++i) {
            int curr = pq.poll();
            if(curr == 0) return 0;
            
            pq.offer(curr - 1);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += (work * work);
        }
        
        return answer;
    }
}