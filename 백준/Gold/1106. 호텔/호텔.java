import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] DP = new int[2][100001];

        int answer = Integer.MAX_VALUE;
        int cur = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // 풀이: DP에 도시를 하나씩 추가하며 최솟값을 구함
            // 추가한 도시만으로 투자 대비 고객의 수를 구함
            // 이를 도시를 추가하기 전과 비교하여 돈의 최솟값을 구함
            for (int j = 1; j <= 100000; j++) {
                // 비용이 현재 최솟값 이상이면 종료
                if (j >= answer) break;

                // 도시를 추가하여 DP값을 갱신함
                if (j < cost) {
                    DP[cur][j] = DP[1 - cur][j];
                } else {
                    DP[cur][j] = Math.max(DP[1 - cur][j], DP[cur][j - cost] + value);
                }

                // 투자 대비 고객 수가 기준(C) 이상이면 최솟값을 갱신 후 종료
                if (DP[cur][j] >= C) {
                    answer = Math.min(answer, j);
                    break;
                }
            }

            // 비교 배열의 열을 바꿔줌
            cur = 1 - cur;
        }

        System.out.print(answer);
    }
}