import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        // node의 타입을 판별하기 위해 Map 사용
        // gate(false), summit(true), general(null)
        Map<Integer, Boolean> typeMap = new HashMap<>();
        for(int gate : gates) {
            typeMap.put(gate, false);
        }
        for(int summit : summits) {
            typeMap.put(summit, true);
        }
        
        // 간선의 정보로 graph 초기화
        List<int[]>[] graph = new List[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < paths.length; i++) {
            int stt = paths[i][0];
            int end = paths[i][1];
            int val = paths[i][2];
            
            graph[stt].add(new int[]{end, val});
            graph[end].add(new int[]{stt, val});
        }
        
        // 시작 지점마다 bfs를 통해 res(산봉우리의 번호, intensity의 최솟값)를 구함
        // res와 answer를 비교하여 모든 경우의 수에서 산봉우리의 번호, intensity의 최솟값를 구함
        int[] visited = new int[n + 1];
        for(int gate : gates) {
            int[] res = bfs(n, gate, graph, typeMap, visited);
            if(res[1] < answer[1]) {
                answer[0] = res[0];
                answer[1] = res[1];
            } else if(res[1] == answer[1] && res[0] < answer[0]) {
                answer[0] = res[0];
            }
        }
        
        return answer;
    }
    
    public int[] bfs(int n, int gate, List<int[]>[] graph, Map<Integer, Boolean> typeMap, int[] visited) {
        Queue<int[]> q = new LinkedList<>();
        int summit = Integer.MAX_VALUE;
        int intensity = Integer.MAX_VALUE;
        
        q.offer(new int[] {gate, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int[] next : graph[cur[0]]) {
                int nextIntensity = Math.max(cur[1], next[1]);
                if(visited[next[0]] > 0 && visited[next[0]] <= nextIntensity) continue;
                
                if(typeMap.get(next[0]) == null) {
                    q.offer(new int[]{next[0], nextIntensity});
                    visited[next[0]] = nextIntensity;    
                } else if(typeMap.get(next[0])) {
                    if(nextIntensity < intensity) {
                        summit = next[0];
                        intensity = nextIntensity;
                    } else if(nextIntensity == intensity && next[0] < summit) {
                        summit = next[0];
                    }
                }
            }
        }
        
        int[] res = {summit, intensity};
        return res;
    }
}