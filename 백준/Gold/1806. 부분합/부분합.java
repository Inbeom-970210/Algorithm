import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 수열의 길이; 10 <= N <= 100,000
        // S는 부분합 기준; 0 <= S <= 100,000,000
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            // 1 <= arr[i] <= 10,000
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 부분만 구하기
        int res = 0;
        int sum = 0;
        for (int e = 0; e < N; ++e) {
            sum += arr[e];
            ++res;
            if (sum >= S) break;
        }

        if (res == 1) {
            System.out.print(1);
            return;
        } else if (res == N && sum < S) {
            System.out.print(0);
            return;
        }

        int s = 0;
        int e = res - 1;
        while(s < e && sum - arr[s] >= S) {
            --res;
            sum -= arr[s++];
        }
//        System.out.println("res: " + res + " // sum: " + sum + " // s:" + s + " // e:" + e);

        // 부분합과 선택한 행을 기준으로
        // 한칸씩 이동 -> 부분합 확인
        // 부분합이 작으면 조건을 충족할 때까지 끝 행을 추가
        // 부분합이 크면 조건을 충족하는 선에서 시작 행을 뺌
        int cnt = res;
        while (s < e && e < N - 1) {
            ++cnt;
            sum += arr[e++ + 1];

            while(s < e && sum - arr[s] >= S) {
                --cnt;
                sum -= arr[s++];
            }

            res = Math.min(res, cnt);
//            System.out.println("cnt: " + cnt + " // sum: " + sum + " // s:" + s + " // e:" + e);
        }

        System.out.print(res);

    }
}