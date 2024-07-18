import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풀이: 점화식을 사용한 DP
        // 1. 좌표를 정사각형의 우측 하단 모서리로 인식
        // 2. DP는 해당 좌표에서 만들 수 있는 가장 큰 정사각형 목장
        // 3. 좌표 기준 대각선, 좌, 상의 최소 대각선 + 1이 해당 좌표의 값
        int answer = 0;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] DP = new int[M + 1][N + 1];

        for (int r = 1; r <= M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                if (Integer.parseInt(st.nextToken()) > 0) continue;

                DP[r][c] = Math.min(DP[r - 1][c - 1], Math.min(DP[r - 1][c], DP[r][c - 1])) + 1;
                answer = Math.max(answer, DP[r][c]);
            }
        }

        System.out.print(answer);
    }
}