import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, res;
    static int[][] colors;
    static int[] target, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        colors = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }
        target = new int[3];
        st = new StringTokenizer(br.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());
        target[2] = Integer.parseInt(st.nextToken());

        arr = new int[3];
        res = Integer.MAX_VALUE;
        function(0, 0);

        System.out.print(res);
    }

    private static void function(int depth, int cnt) {
        if (cnt > 7) return;
        if (depth == N) {
            if (cnt > 1) {
                int diff = 0;
                for (int i = 0; i < 3; i++) {
                    diff += Math.abs(target[i] - arr[i] / cnt);
                }
                res = Math.min(res, diff);
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            arr[i] += colors[depth][i];
        }
        function(depth + 1, cnt + 1);
        for (int i = 0; i < 3; i++) {
            arr[i] -= colors[depth][i];
        }
        function(depth + 1, cnt);
    }

}