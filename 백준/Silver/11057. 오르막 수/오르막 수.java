import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            DP[0][i] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    DP[i][j] += DP[i - 1][k];
                }
                DP[i][j] %= 10007;
            }
        }

        System.out.print(DP[N][0]);
    }
}