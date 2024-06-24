import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());            
        }
        
        for(int[] arr : edge) {
            int start = arr[0];
            int end = arr[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        boolean[] checked = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        int max = 0;
        
        q.offer(new int[]{1, 0});
        checked[1] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int vertex = cur[0];
            int depth = cur[1];
            
            if(max == depth) answer++;
            else if(max < depth) {
                answer = 1;
                max = depth;
            }
            
            for(int val : graph.get(vertex)) {
                if(checked[val]) continue;
                q.offer(new int[]{val, depth + 1});
                checked[val] = true;
            }
        }
        
        return answer;
    }
}