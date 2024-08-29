import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] rectangle = new int[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            char[] charArray = br.readLine().toCharArray();
            for (int c = 1; c <= M; c++) {
                rectangle[r][c] = charArray[c - 1] - '0';
            }
        }

        // DP: (1, 1)부터 (r, c)까지의 누적합
        long[][] DP = new long[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                DP[r][c] = DP[r - 1][c] + DP[r][c - 1] - DP[r - 1][c - 1] + rectangle[r][c];
            }
        }

        System.out.print(calculMax(N, M, rectangle, DP));
    }

    // 6가지 모양을 고려하여 직사각형의 합의 곱의 최댓값을 반환
    private static long calculMax(int N, int M, int[][] rectangle, long[][] DP) {
        long answer = 0;

        // case1
        for (int c1 = 1; c1 <= M - 2; c1++) {
            for (int c2 = c1 + 1; c2 <= M - 1; c2++) {
                long rec1 = sumRec(1, 1, N, c1, DP);
                long rec2 = sumRec(1, c1 + 1, N, c2, DP);
                long rec3 = sumRec(1, c2 + 1, N, M, DP);
                answer = Math.max(answer, rec1 * rec2 * rec3);
            }
        }

        // case2
        for (int r1 = 1; r1 <= N - 2; r1++) {
            for (int r2 = r1 + 1; r2 <= N - 1; r2++) {
                long rec1 = sumRec(1, 1, r1, M, DP);
                long rec2 = sumRec(r1 + 1, 1, r2, M, DP);
                long rec3 = sumRec(r2 + 1, 1, N, M, DP);
                answer = Math.max(answer, rec1 * rec2 * rec3);
            }
        }

        // case3
        for (int r = 1; r <= N - 1; r++) {
            for (int c = 1; c <= M - 1; c++) {
                long rec1 = sumRec(1, 1, N, c, DP);
                long rec2 = sumRec(1, c + 1, r, M, DP);
                long rec3 = sumRec(r + 1, c + 1, N, M, DP);
                answer = Math.max(answer, rec1 * rec2 * rec3);
            }
        }

        // case4
        for (int r = 1; r <= N - 1; r++) {
            for (int c = 1; c <= M - 1; c++) {
                long rec1 = sumRec(1, 1, r, c, DP);
                long rec2 = sumRec(r + 1, 1, N, c, DP);
                long rec3 = sumRec(1, c + 1, N, M, DP);
                answer = Math.max(answer, rec1 * rec2 * rec3);
            }
        }

        // case5
        for (int r = 1; r <= N - 1; r++) {
            for (int c = 1; c <= M - 1; c++) {
                long rec1 = sumRec(1, 1, r, M, DP);
                long rec2 = sumRec(r + 1, 1, N, c, DP);
                long rec3 = sumRec(r + 1, c + 1, N, M, DP);
                answer = Math.max(answer, rec1 * rec2 * rec3);
            }
        }

        // case6
        for (int r = 1; r <= N - 1; r++) {
            for (int c = 1; c <= M - 1; c++) {
                long rec1 = sumRec(1, 1, r, c, DP);
                long rec2 = sumRec(1, c + 1, r, M, DP);
                long rec3 = sumRec(r + 1, 1, N, M, DP);
                answer = Math.max(answer, rec1 * rec2 * rec3);
            }
        }

        return answer;
    }

    // (r1, c1)부터 (r2, c2)까지의 누적합
    private static long sumRec(int r1, int c1, int r2, int c2, long[][] DP) {
        return DP[r2][c2] - DP[r2][c1 - 1] - DP[r1 - 1][c2] + DP[r1 - 1][c1 - 1];
    }
}