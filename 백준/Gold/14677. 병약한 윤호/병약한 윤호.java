import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] pills;
    static Integer[][][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 500
        N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        pills = new int[N * 3];
        for (int i = 0; i < N * 3; ++i) {
            switch (arr[i]) {
                case 'B':
                    pills[i] = 0;
                    break;
                case 'L':
                    pills[i] = 1;
                    break;
                case 'D':
                    pills[i] = 2;
                    break;
            }
        }
        DP = new Integer[N * 3][N * 3][3];

        int res = findMax(0, N * 3 - 1, 0);

        System.out.print(res);

    }

    private static int findMax(int start, int end, int time) {
        if (pills[start] != time && pills[end] != time) return 0;
        if (start == end && pills[start] == time) return 1;

        if (DP[start][end][time] == null) {
            if (pills[start] == time && pills[end] == time)
                DP[start][end][time] = Math.max(findMax(start + 1, end, (time + 1) % 3), findMax(start, end - 1, (time + 1) % 3));
            else if (pills[start] == time) DP[start][end][time] = findMax(start + 1, end, (time + 1) % 3);
            else DP[start][end][time] = findMax(start, end - 1, (time + 1) % 3);
            ++DP[start][end][time];
        }
        return DP[start][end][time];
    }

}