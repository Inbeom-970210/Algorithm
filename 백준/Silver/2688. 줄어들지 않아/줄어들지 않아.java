import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][] DP = new long[n][10];
            for(int i = 0; i < 10; i++) {
                DP[0][i] = 1;
            }

            for(int i = 1; i < n; i++) {
                for(int j = 0; j < 10; j++) {
                    for(int k = j; k < 10; k++) {
                        DP[i][j] += DP[i - 1][k];
                    }
                }
            }

            long total = 0;
            for(int i = 0; i < 10; i++) {
                total += DP[n - 1][i];
            }
            sb.append(total).append("\n");
        }

        System.out.print(sb);
    }
}
//1   10  55  220
//1   9   45  165
//1   8   36  120
//1   7   28  84
//1   6   21  56
//1   5   15  35
//1   4   10  20
//1   3   6   10
//1   2   3   4
//1   1   1   1

