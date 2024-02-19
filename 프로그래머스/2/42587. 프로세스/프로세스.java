import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        int[] arr = new int[10];
        int idx = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < len; ++i) {
            q.offer(new int[] {priorities[i], i});
            ++arr[priorities[i]];
            idx = Math.max(idx, priorities[i]);
        }
        
        int order = 1;
        while(true) {
            int[] curr = q.poll();
            while(idx >= 0 && arr[idx] == 0) {
                --idx;
            }
            
            if(curr[0] == idx && curr[1] == location) return order;
            
            if(curr[0] < idx) q.offer(curr);
            else {
                ++order;
                --arr[idx];
            }
        }
        
    }
}