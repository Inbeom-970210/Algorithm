import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[100001][2];
        int cur = 0;
        int pre;

        // 냅색 알고리즘을 사용한 풀이
        for (int i = 0; i < N; i++) {
            pre = 1 - cur;
            for (int time = 1; time <= 10000; time++) {
                // 1. 현재 단원을 공부할 수 없으면 이전 단원까지 고려한 값을 입력
                if (time < times[i]) DP[time][cur] = DP[time][pre];
                // 2. 현재 단원을 공부할 수 있으면 공부한 경우와 안한 경우를 비교하면 최대값을 입력
                else DP[time][cur] = Math.max(DP[time][pre], DP[time - times[i]][pre] + scores[i]);
            }

            cur = pre;
        }

        System.out.print(DP[T][1 - cur]);
    }
}