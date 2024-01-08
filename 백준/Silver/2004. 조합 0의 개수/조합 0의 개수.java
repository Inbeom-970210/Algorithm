import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // nCm; 0 <= m <= n <= 2,000,000,000, n != 0
        // 2 * 5는 10으로 끝에 0이 생긴다.
        // 따라서 2의 승수와 5의 승수 중 작은 값이 0의 개수이다.
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pow2 = 0;
        int pow5 = 0;

        pow2 += pow(n, 2);
        pow5 += pow(n, 5);

        pow2 -= pow(m, 2);
        pow5 -= pow(m, 5);

        pow2 -= pow(n - m, 2);
        pow5 -= pow(n - m, 5);

        System.out.print(Math.min(pow2, pow5));
    }

    // num!에서 divisor의 승수를 구함
    static int pow(int num, int divisor) {
        int cnt = 0;

        while(num >= divisor) {
            cnt += num / divisor;
            num /= divisor;
        }

        return cnt;
    }
}