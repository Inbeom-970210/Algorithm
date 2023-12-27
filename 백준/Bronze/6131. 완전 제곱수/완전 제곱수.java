import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1 <= N <= 1,000

        // A의 제곱은 B의 제곱보다 N만큰 크다를 만족하면 이를 카운트함
        int res = 0;
        for(int A = 1; A <= 500; A++) {
            for(int B = 1; B <= A; B++) {
                if(Math.pow(A, 2) == Math.pow(B, 2) + N) res++;
            }
        }

        System.out.print(res);
    }
}