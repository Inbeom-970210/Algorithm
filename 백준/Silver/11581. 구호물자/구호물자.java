import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int flag = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int nextNodeNum = Integer.parseInt(st.nextToken());
                nodes[i].add(nextNodeNum);
            }
        }

        Dfs(1, N, nodes, new boolean[N + 1]);
        System.out.print(flag == 2 ? "CYCLE" : "NO CYCLE");
    }

    private static void Dfs(int cur, int N, List<Integer>[] nodes, boolean[] visited) {
        if (flag == 2) return;
        if (cur == N) {
            flag = 1;
            return;
        }
        if (visited[cur]) {
            flag = 2;
            return;
        }
        visited[cur] = true;

        for (int next : nodes[cur]) {
            Dfs(next, N, nodes, visited);
        }

        visited[cur] = false;
    }
}