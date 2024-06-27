import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 간선 정보를 graph에 저장
        List<Integer>[] graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            int start = road[0];
            int end = road[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        // destination을 기준으로 bfs를 통해 각 지역에 대한 최단 거리 계산
        // 갈 수 없는 지역이면 -1
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dist, -1);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{destination, 0});
        visit[destination] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int location = cur[0];
            int value = cur[1];
            dist[location] = value;
            
            for(int next : graph[location]) {
                if(!visit[next]) {
                    q.offer(new int[]{next, value + 1});
                    visit[next] = true;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        int idx = -1;
        for(int source : sources) {
            answer[++idx] = dist[source];
        }
        
        return answer;
    }
}