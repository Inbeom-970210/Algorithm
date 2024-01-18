import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N의 횡단보도 개수; 1 <= N <= 100,000
        // K는 연속된 횡단보도 개수의 조건; 1 <= K <= N
        // B는 고장난 횡단보도 개수; 1 <= B <= N
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] brks = new boolean[N];

        for (int i = 0; i < B; ++i) {
            brks[Integer.parseInt(br.readLine()) - 1] = true;
        }

        int cnt = 0;
        for(int i = 0; i < K; ++i) {
            if(brks[i]) ++cnt;
        }
        int res = cnt;

        for(int i = 0; i < N - K; ++i) {
            if(brks[i]) --cnt;
            if(brks[i + K]) ++cnt;
            res = Math.min(res, cnt);
        }

        System.out.print(res);
    }
}