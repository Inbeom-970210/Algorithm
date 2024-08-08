import java.util.*;

class Solution {
    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[] maps) {
        String[][] map = new String[maps.length][];
        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }
        
        int answer = 0;
        int[] S = new int[2];
        int[] E = new int[2];
        int[] L = new int[2];
    
        for(int r = 0; r < map.length; r++) {
            for(int c = 0; c < map[0].length; c++) {
                if(map[r][c].equals("S")) {
                    S[0] = r;
                    S[1] = c;
                } else if(map[r][c].equals("E")) {
                    E[0] = r;
                    E[1] = c;
                } else if(map[r][c].equals("L")) {
                    L[0] = r;
                    L[1] = c;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        boolean flag  = false;
        
        q.offer(new int[]{S[0], S[1], 0});
        visited[S[0]][S[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == L[0] && cur[1] == L[1]) {
                flag = true;
                answer = cur[2];
                break;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nextR = cur[0] + move[dir][0];
                int nextC = cur[1] + move[dir][1];
                
                if(nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) continue;
                if(map[nextR][nextC].equals("X") || visited[nextR][nextC]) continue;
                
                q.offer(new int[]{nextR, nextC, cur[2] + 1});
                visited[nextR][nextC] = true;
            }
        }
        if(!flag) return -1;
        
        
        visited = new boolean[map.length][map[0].length];
        flag = false;
        
        q.clear();
        q.offer(new int[]{L[0], L[1], answer});
        visited[L[0]][L[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == E[0] && cur[1] == E[1]) {
                flag = true;
                answer = cur[2];
                break;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nextR = cur[0] + move[dir][0];
                int nextC = cur[1] + move[dir][1];
                
                if(nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) continue;
                if(map[nextR][nextC].equals("X") || visited[nextR][nextC]) continue;
                
                q.offer(new int[]{nextR, nextC, cur[2] + 1});
                visited[nextR][nextC] = true;
            }
        }
        if(!flag) return -1;
        
        return answer;
    }
}