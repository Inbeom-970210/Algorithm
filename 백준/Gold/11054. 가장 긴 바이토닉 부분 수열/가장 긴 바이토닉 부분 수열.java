import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 1,000
        // 1 <= A[i] <= 1,000
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[][] DP = new int[N][3];
        for (int[] arr : DP) {
            Arrays.fill(arr, 1);
        }

        int res = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (A[j] < A[i] && DP[j][0] >= DP[i][0]) DP[i][0] = DP[j][0] + 1;
                if (A[N - 1 - j] < A[N - 1 - i] && DP[N - 1 - j][1] >= DP[N - 1 - i][1])
                    DP[N - 1 - i][1] = DP[N - 1 - j][1] + 1;
            }
        }

        for (int i = 0; i < N; ++i) {
            DP[i][2] = DP[i][0] + DP[i][1] - 1;

            res = Math.max(res, DP[i][0]);
            res = Math.max(res, DP[i][1]);
            res = Math.max(res, DP[i][2]);
        }

        System.out.print(res);
    }
}