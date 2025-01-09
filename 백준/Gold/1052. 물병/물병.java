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
        int answer = 0;

        while (N > K) {
            int cnt = -1;
            while ((int) Math.pow(2, cnt + 1) < N) {
                cnt++;
            }

            if(K == 1) {
                answer += (int) Math.pow(2, cnt + 1) - N;
                break;
            }

            N -= (int) Math.pow(2, cnt);
            K--;
        }

        System.out.print(answer);
    }
}