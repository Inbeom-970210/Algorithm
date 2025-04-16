import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            boolean[][] isSheep = new boolean[H][W];
            for (int r = 0; r < H; r++) {
                String[] list = br.readLine().split("");
                for (int c = 0; c < W; c++) {
                    if ("#".equals(list[c]))
                        isSheep[r][c] = true;
                }
            }

            int cnt = 0;
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (isSheep[r][c]) {
                        cnt++;
                        checkGroup(isSheep, r, c);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static void checkGroup(boolean[][] isSheep, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        isSheep[row][col] = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nextR = cur[0] + dr[d];
                int nextC = cur[1] + dc[d];

                if (nextR < 0 || nextR >= isSheep.length
                        || nextC < 0 || nextC >= isSheep[0].length
                        || !isSheep[nextR][nextC])
                    continue;

                queue.add(new int[]{nextR, nextC});
                isSheep[nextR][nextC] = false;
            }
        }
    }
}
