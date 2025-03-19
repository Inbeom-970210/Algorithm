import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int r = M - 1; r >= 0; r--) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        String ans = "No";
        int[][] next = {{0, 1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{M - 1, 0});
        visited[M - 1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 0 && cur[1] == N - 1) {
                ans = "Yes";
                break;
            }

            for (int d = 0; d < 2; d++) {
                int nextR = cur[0] + next[d][0];
                int nextC = cur[1] + next[d][1];

                 if (validate(nextR, nextC)) {
                    queue.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }

        System.out.print(ans);
    }

    private static boolean validate(int row, int col) {
        if (row < 0 || row >= M || col < 0 || col >= N || visited[row][col] || map[row][col] == 0)
            return false;
        return true;
    }
}
