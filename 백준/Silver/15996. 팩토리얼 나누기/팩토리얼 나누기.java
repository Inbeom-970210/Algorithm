import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 음이 아닌 정수, A는 N을 나눌 소수; 0 <= N < 2^31, 2 <= A <= 11, A는 소수
        // 팩토리얼을 소수로 나누었을 때 몫은 소수 배수의 개수를 의미함 
        long N = Long.parseLong(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int res = 0;

        while(N >= A) {
            res += N / A;
            N /= A;
        }

        System.out.print(res);
    }
}