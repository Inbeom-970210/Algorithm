import java.util.*;

class Solution {
    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int[] solution(String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        String[][] map = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int r = 0; r < maps.length; ++r) {
            String[] row = maps[r].split("");
            for(int c = 0; c < maps[r].length(); ++c) {
                String cur = row[c];
                map[r][c] = cur;
                if(cur.equals("X")) visited[r][c] = true;
            }
        }
        
        for(int r = 0; r < maps.length; ++r) {
            for(int c = 0; c < maps[r].length(); ++c) {
                if(visited[r][c]) continue;
                int val = Integer.parseInt(map[r][c]);
                visited[r][c] = true;
                queue.offer(new int[]{r, c});
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    
                    for(int dir = 0; dir < 4; ++dir) {
                        int nextR = cur[0] + move[dir][0];
                        int nextC = cur[1] + move[dir][1];
                        
                        if(nextR < 0 || nextR >= maps.length) continue;
                        if(nextC < 0 || nextC >= maps[r].length()) continue;
                        if(visited[nextR][nextC]) continue;
                        
                        val += Integer.parseInt(map[nextR][nextC]);
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
                list.add(val);
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        for(int i = list.size() - 1; i >= 0; --i) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}