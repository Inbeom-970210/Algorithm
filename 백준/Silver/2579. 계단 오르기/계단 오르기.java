import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = arr[1];
        for (int i = 2; i <= N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];
        }

        System.out.print(Math.max(dp[N][1], dp[N][2]));
    }
}