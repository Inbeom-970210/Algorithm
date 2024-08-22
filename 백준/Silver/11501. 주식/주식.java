import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getBenefit(N, prices)).append("\n");
        }

        System.out.print(sb);
    }

    // 풀이: 역방향 탐색으로 max 값을 갱신하며 차이를 benefit에 더함.
    private static long getBenefit(int N, int[] prices) {
        long benefit = 0;
        int max = prices[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            if (prices[i] < max) {
                benefit += max - prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
            }
        }

        return benefit;
    }
}