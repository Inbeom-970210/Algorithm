import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int row, col, res;
    static char[][] map;
    static boolean[][] checked;
    static Queue<int[]> queue;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 <= row <= 50; 1 <= col <= 50
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        for (int i = 0; i < row; ++i) {
            map[i] = br.readLine().toCharArray();
        }
        queue = new LinkedList<>();

        res = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (map[r][c] == 'W') continue;
                bfs(r, c);
            }
        }

        System.out.print(res);

    }

    private static void bfs(int r, int c) {
        int max = 0;
        checked = new boolean[row][col];

        // 현재 위치
        queue.offer(new int[]{r, c, 0});
        checked[r][c] = true;

        // 이동
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            max = curr[2];
            for (int move = 0; move < 4; ++move) {
                int nextR = curr[0] + dir[move][0];
                int nextC = curr[1] + dir[move][1];

                if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= col) continue;
                if (checked[nextR][nextC]) continue;
                if (map[nextR][nextC] == 'W') continue;

                queue.offer(new int[]{nextR, nextC, curr[2] + 1});
                checked[nextR][nextC] = true;
            }
        }

        res = Math.max(res, max);
    }
}