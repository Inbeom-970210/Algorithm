import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] alcohols = new int[N];
        for (int i = 0; i < N; i++) {
            alcohols[i] = Integer.parseInt(br.readLine());
        }

        long left = 0;
        long right = Integer.MAX_VALUE - 1;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += alcohols[i] / mid;
                if(cnt >= K) break;
            }

            if (cnt >= K) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}