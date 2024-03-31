import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 2 <= N <= 100,000
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; ++i) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adj[node1].add(node2);
            adj[node2].add(node1);
        }

        int[] parent = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for(int node : adj[curr]) {
                if(parent[node] != 0) continue;

                parent[node] = curr;
                queue.offer(node);
            }
        }

        for(int i = 2; i <= N; ++i) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}