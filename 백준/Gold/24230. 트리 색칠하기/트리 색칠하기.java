import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] colors = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        visited[1] = true;
        answer = colors[1] == 0 ? 0 : 1;
        dfs(1, colors[1], colors, visited, graph);

        System.out.print(answer);
    }

    private static void dfs(int node, int color, int[] colors, boolean[] visited, List<Integer>[] graph) {
        for (int next : graph[node]) {
            if (visited[next]) continue;
            else if (color != colors[next]) answer++;
            visited[next] = true;
            dfs(next, colors[next], colors, visited, graph);
        }
    }
}