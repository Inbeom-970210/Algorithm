import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N은 표의 크기; 1 <= N <= 1,024
        // M은 구해야 하는 횟수; 1<= M <= 100,000
        // cmltvSum은 표에서 행 누적합
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cmltvSum = new int[N + 1][N + 1];

        for (int r = 1; r <= N; ++r) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++) {
                cmltvSum[r][c] = cmltvSum[r - 1][c] + cmltvSum[r][c - 1] - cmltvSum[r - 1][c - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int test = 1; test <= M; ++test) {
            st = new StringTokenizer(br.readLine());
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int res = cmltvSum[end[0]][end[1]] - cmltvSum[end[0]][start[1] - 1]
                    - cmltvSum[start[0] - 1][end[1]] + cmltvSum[start[0] - 1][start[1] - 1];

            sb.append(res).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }
}