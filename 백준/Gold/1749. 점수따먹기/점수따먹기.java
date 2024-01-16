import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 행; 1 < N < 200
        // M은 열; 1 < M < 200
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cmltvSum = new int[N + 1][M + 1];
        for (int r = 1; r <= N; ++r) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= M; ++c) {
                cmltvSum[r][c] = Integer.parseInt(st.nextToken()) + cmltvSum[r - 1][c] + cmltvSum[r][c - 1] - cmltvSum[r - 1][c - 1];
            }
        }

        int res = Integer.MIN_VALUE;
        for (int sr = 1; sr <= N; ++sr) {
            for (int sc = 1; sc <= M; ++sc) {
                for (int er = sr; er <= N; ++er) {
                    for (int ec = sc; ec <= M; ++ec) {
                        res = Math.max(res, cmltvSum[er][ec] - cmltvSum[sr - 1][ec] - cmltvSum[er][sc - 1] + cmltvSum[sr - 1][sc - 1]);
                    }
                }
            }
        }

        System.out.print(res);

    }
}