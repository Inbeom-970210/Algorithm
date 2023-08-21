import java.util.*;

public class Main {
    static int N, M, counter;
    static int[] res;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();                // 정점의 개수
        M = sc.nextInt();                // 간선의 개수
        counter = 1;                     // 방문 순서
        int R = sc.nextInt();            // 시작 정점
        res = new int[N + 1];            // 결과
        visited = new boolean[N + 1];    // 정점 방문 처리
        graph = new ArrayList[N + 1];       // 정점의 간선 정보
        for(int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            res[i] = 0;
        }
        
        // 정점의 간선 정보 입력
        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 정점의 간선 오름차순 정렬
        for(int i = 1; i < N + 1; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }
        
        visited[R] = true;
        res[R] = counter++;
        dfs(1, R);    // 깊이, 시작번호
        
        for(int i = 1; i < N + 1; i++) {
            sb.append(res[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void dfs(int depth, int start) {
        int len = graph[start].size();
        for(int i = 0; i < len; i++) {
            int next = graph[start].get(i);
            
            if(!visited[next]) {
                visited[next] = true;
                res[next] = counter++;
                dfs(depth + 1, next);
            }
        }
    }
}