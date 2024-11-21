import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] states = new String[N];
        int[] powers = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            states[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이 이분탐색
        // 1. 중간값이 캐릭터 전투력 미만이면 캐릭터 칭호를 중간값으로 갱신 후 중간값 보다 높은 값 탐색
        // 2. 중간값이 캐릭터 전투력 이상이면 중간값 보다 낮은 값 탐색
        // 3. 캐릭터 전투력 이하 값이 없으면 가장 낮은 칭호 할당
        while (M-- > 0) {
            int person = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N - 1;
            int idx = -1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (powers[mid] < person) {
                    if (idx < mid) idx = mid;
                    left = mid + 1;
                } else {
                    idx = mid;
                    right = mid - 1;
                }
            }
            if (idx == -1) idx = 0;

            sb.append(states[idx]).append("\n");
        }

        System.out.print(sb);
    }
}