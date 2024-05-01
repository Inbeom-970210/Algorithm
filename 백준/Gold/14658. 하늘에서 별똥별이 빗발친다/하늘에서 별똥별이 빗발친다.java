import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] star = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            star[i][0] = r;
            star[i][1] = c;
        }

        int max = 0;
        for (int r = 0; r < K; r++) {
            for (int c = 0; c < K; c++) {
                int cnt = 0;
                for (int[] location : star) {
                    if (location[0] < star[r][0] || location[0] > star[r][0] + L) continue;
                    if (location[1] < star[c][1] || location[1] > star[c][1] + L) continue;
                    cnt++;
                }
                max = Math.max(max, cnt);
            }

        }

        System.out.print(K - max);
    }
}