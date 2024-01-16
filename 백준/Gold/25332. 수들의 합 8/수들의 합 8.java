import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N은 정수의 개수; 1 <= N <= 2 * 10^5
        // A, B는 수열; 1 <= A[i], B[i] <= 10,000
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 두 수열의 차를 사용해서 누적합 gabs을 구함
        // gabs의 부분 누적합이 0이면 조건을 충족하므로 카운트
        // => 두 수열의 동일한 구간 누적합이 같음을 의미
        long res = 0;
        HashMap<Long, Long> map = new HashMap<>();
        long[] gaps = new long[N + 1];

        for(int i = 1; i <= N; ++i) {
            gaps[i] = (A[i] - B[i]) + gaps[i - 1];
            if(gaps[i] == 0) ++res;
            if(map.get(gaps[i]) != null) res += map.get(gaps[i]);

            if(map.get(gaps[i]) == null) map.put(gaps[i], 1L);
            else map.replace(gaps[i], map.get(gaps[i]) + 1);
        }

        System.out.print(res);

    }
}