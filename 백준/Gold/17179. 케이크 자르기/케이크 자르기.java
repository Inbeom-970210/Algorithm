import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] points = new int[M];
        for (int i = 0; i < M; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        while (N-- > 0) {
            int Q = Integer.parseInt(br.readLine());
            int answer = calculAnswer(points, Q, L);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    // 풀이: 이분탐색
    // 1. 조건 충족: 가장 작은 조각의 길이(mid)를 기준으로 가능한 지점의 수(cnt)가 Q이상일 때
    // => answer를 갱신하고 start = mid + 1;
    // 2. 조건 미충족 => start = mid - 1;
    // 3. while(start <= end)가 끝나면 answer는 조건을 충족하면서 가장 큰 수이다.
    private static int calculAnswer(int[] points, int Q, int L) {
        int start = 1;
        int end = L - 1;
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int pre = 0;
            int cnt = 0;
            for (int point : points) {
                if (point - pre >= mid) {
                    pre = point;
                    cnt++;
                }
                if (cnt == Q) break;
            }

            if (cnt == Q && L - pre >= mid) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}