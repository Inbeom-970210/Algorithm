import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, res;
    static int[][] A, D = {{0, -1, 1}, {1, 0, 1}, {0, 1, 2}, {-1, 0, 2}};
    static int[][] spread = {{2, 0, 0, 0, 5}, {1, 1, 0, 0, 10}, {1, 0, 0, 1, 10}, {0, 2, 0, 0, 2}, {0, 1, 0, 0, 7}, {0, 0, 0, 2, 2}, {0, 0, 0, 1, 7}, {0, 1, 1, 0, 1}, {0, 0, 1, 1, 1}, {1, 0, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 3 <= N <= 499, N은 홀수
        // 0 <= A[r][c] <= 1,000
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; ++c) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        move(N / 2, N / 2, 0);

        System.out.print(res);
    }

    private static void move(int row, int col, int dir) {
        int nextR = row;
        int nextC = col;
        for (int i = 0; i < D[dir][2]; ++i) {
            if (dir == 0 && nextR == 0 && nextC == 0) return;
            nextR += D[dir][0];
            nextC += D[dir][1];
            int sand = A[nextR][nextC];
            int alpha = sand;
            for (int j = 0; j < 10; ++j) {
                int spreadR = nextR;
                int spreadC = nextC;
                for (int spreadDir = 0; spreadDir < 4; ++spreadDir) {
                    spreadR += D[dir][0] * spread[j][spreadDir];
                    spreadC += D[dir][1] * spread[j][spreadDir];
                    dir = (dir + 1) % 4;
                }

                int amount = 0;
                if (j == 9) amount = alpha;
                else amount = sand * spread[j][4] / 100;
                alpha -= amount;

                if (spreadR < 0 || spreadR >= N || spreadC < 0 || spreadC >= N) {
                    res += amount;
                    continue;
                }
                A[spreadR][spreadC] += amount;
            }

        }
        D[dir][2] += 2;
        move(nextR, nextC, (dir + 1) % 4);
    }
}