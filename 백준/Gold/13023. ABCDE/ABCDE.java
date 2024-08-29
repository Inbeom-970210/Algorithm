import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer;
    static boolean flag = false;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;
        }

        System.out.print(answer);
    }

    private static void dfs(int depth, int cur) {
        if (flag) return;
        if (depth == 5) {
            answer = 1;
            flag = true;
            return;
        }

        for (int next : graph[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(depth + 1, next);
            visited[next] = false;
        }
    }
}