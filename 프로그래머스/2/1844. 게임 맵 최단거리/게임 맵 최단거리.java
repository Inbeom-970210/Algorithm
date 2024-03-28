import java.util.*;

class Solution {
    static int[] moveR = {0, 1, 0, -1};
    static int[] moveC = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] checked = new boolean[maps.length][maps[0].length];
        
        checked[0][0] = true;
        queue.offer(new int[] {0, 0, 1});
        if(checked[maps.length - 1][maps[0].length - 1]) return 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int i = 0; i < 4; ++i) {
                int nextR = cur[0] + moveR[i];
                int nextC = cur[1] + moveC[i];
                
                if(nextR < 0 || nextR >= maps.length) continue;
                if(nextC < 0 || nextC >= maps[0].length) continue;
                if(checked[nextR][nextC]) continue;
                if(maps[nextR][nextC] == 0) continue;
                
                checked[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC, cur[2] + 1});
            }
            
            if(checked[maps.length - 1][maps[0].length - 1]) return cur[2] + 1; 
        }
        
        return -1;
    }
}