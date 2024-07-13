import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, R;
    static List<List<Integer>> graph;
    static int[] parent, subTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        parent = new int[N + 1];
        subTree = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        visited[R] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            boolean flag = true;
            for (int num : graph.get(cur)) {
                if (visited[num]) continue;

                flag = false;
                parent[num] = cur;
                q.offer(num);
                visited[num] = true;
            }
            if (flag) subTree[cur] = 1;
        }

        for (int i = 1; i <= Q; i++) {
            int vertex = Integer.parseInt(br.readLine());
            sb.append(dfs(vertex)).append("\n");
        }

        System.out.println(sb);
    }

    public static int dfs(int vertex) {
        if (vertex == R) return N;

        if (subTree[vertex] == 0) {
            int sum = 0;
            for (int nextV : graph.get(vertex)) {
                if (nextV == parent[vertex]) continue;
                sum += dfs(nextV);
            }
            subTree[vertex] = sum + 1;
        }
        return subTree[vertex];
    }
}