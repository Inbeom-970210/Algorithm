import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= N <= 100
        int N = Integer.parseInt(br.readLine());
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] DP = new int[N];
        Arrays.fill(DP, 1);
        int res = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (wires[j][1] < wires[i][1] && DP[j] >= DP[i]) DP[i] = DP[j] + 1;
            }
            res = Math.max(res, DP[i]);
        }

        System.out.print(N - res);
    }
}