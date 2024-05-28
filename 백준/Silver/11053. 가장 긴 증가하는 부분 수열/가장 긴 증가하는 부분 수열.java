import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 1,000
        // 1 <= arr[i] <= 1,000
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DP = new int[N + 1][1001];
        for (int[] items : DP) {
            Arrays.fill(items, -1);
        }

        int res = getMaxLen(0, 0);
        System.out.print(res);

    }

    private static int getMaxLen(int depth, int max) {
        if (depth == N) return 0;

        if (DP[depth][max] == -1) {
            if (arr[depth] <= max) DP[depth][max] = getMaxLen(depth + 1, max);
            else DP[depth][max] = Math.max(getMaxLen(depth + 1, arr[depth]) + 1, getMaxLen(depth + 1, max));
        }
        return DP[depth][max];
    }

}