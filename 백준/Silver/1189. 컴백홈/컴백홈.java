import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int answer = 0, R, C, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[][] graph = new char[R][C];

        for (int r = 0; r < R; r++) {
            graph[r] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[R][C];
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 0, visited, graph);

        System.out.print(answer);
    }

    private static void dfs(int row, int col, int depth, boolean[][] visited, char[][] graph) {
        if (depth == K) return;
        if (depth == K - 1 && row == 0 && col == C - 1) {
            answer++;
            return;
        }

        for (int[] move : moves) {
            int nextR = row + move[0];
            int nextC = col + move[1];

            if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && !visited[nextR][nextC] && graph[nextR][nextC] == '.') {
                visited[nextR][nextC] = true;
                dfs(nextR, nextC, depth + 1, visited, graph);
                visited[nextR][nextC] = false;
            }
        }
    }
}