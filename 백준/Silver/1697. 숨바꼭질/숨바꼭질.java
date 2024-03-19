import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0 <= N <= 100,000; 0 <= K <= 100,000
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int res = 0;
        boolean[] checked = new boolean[140001];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{N, 0});
        checked[N] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == K) {
                res = curr[1];
                break;
            }

            int next = curr[0] + 1;
            if (next <= K && !checked[next]) {
                queue.offer(new int[]{next, curr[1] + 1});
                checked[next] = true;
            }

            next = curr[0] - 1;
            if (next >= 0 && !checked[next]) {
                queue.offer(new int[]{next, curr[1] + 1});
                checked[next] = true;
            }

            next = curr[0] * 2;
            if (next <= 140000 && !checked[next]) {
                queue.offer(new int[]{next, curr[1] + 1});
                checked[next] = true;
            }
        }

        System.out.print(res);
    }
}