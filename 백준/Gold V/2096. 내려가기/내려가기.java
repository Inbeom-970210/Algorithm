import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= N <= 100,000
        int N = Integer.parseInt(br.readLine());
        int[][] maxDP = new int[N][3];
        int[][] minDP = new int[N][3];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; ++c) {
                int num = Integer.parseInt(st.nextToken());
                maxDP[r][c] = num;
                minDP[r][c] = num;
            }
        }


        for (int r = 0; r < N - 1; ++r) {
            maxDP[r + 1][0] += Math.max(maxDP[r][0], maxDP[r][1]);
            maxDP[r + 1][1] += Math.max(maxDP[r][2], Math.max(maxDP[r][0], maxDP[r][1]));
            maxDP[r + 1][2] += Math.max(maxDP[r][1], maxDP[r][2]);

            minDP[r + 1][0] += Math.min(minDP[r][0], minDP[r][1]);
            minDP[r + 1][1] += Math.min(minDP[r][2], Math.min(minDP[r][0], minDP[r][1]));
            minDP[r + 1][2] += Math.min(minDP[r][1], minDP[r][2]);
        }

        int max = Math.max(Math.max(maxDP[N - 1][0], maxDP[N - 1][1]), maxDP[N - 1][2]);
        int min = Math.min(Math.min(minDP[N - 1][0], minDP[N - 1][1]), minDP[N - 1][2]);

        System.out.print(max + " " + min);
    }
}