import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, res;
    static int[][] C;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                C[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MIN_VALUE;
        function(0);

        System.out.print(res);
    }

    private static void function(int depth) {
        if (depth == K) {
            int sum = 0;
            for (int r = 1; r <= N; r++) {
                if (!visited[r]) continue;
                for (int c = 1; c <= N; c++) {
                    if (visited[c]) sum += C[r][c];
                }
            }
            sum /= 2;
            res = Math.max(res, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            function(depth + 1);
            visited[i] = false;
        }
    }

}