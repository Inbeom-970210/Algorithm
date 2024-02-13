import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, res;
    static int[][] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1 <= N <= 15
        N = Integer.parseInt(br.readLine());
        schedule = new int[N + 1][2];
        for (int day = 1; day <= N; ++day) {
            st = new StringTokenizer(br.readLine());
            schedule[day][0] = Integer.parseInt(st.nextToken());
            schedule[day][1] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        recursion(1, 0);

        System.out.print(res);

    }

    private static void recursion(int day, int sum) {
        if (day >= N + 1) {
            res = Math.max(res, sum);
            return;
        }

        int next = day + schedule[day][0];
        if (next <= N + 1) recursion(day + schedule[day][0], sum + schedule[day][1]);
        recursion(day + 1, sum);
    }

}