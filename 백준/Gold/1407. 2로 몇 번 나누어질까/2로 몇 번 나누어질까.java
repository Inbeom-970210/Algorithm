import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A와 B는 자연수; 1 <= A <= B <= 10^15
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = function(B) - function(A -1);

        System.out.print(res);
    }

    // 2로 나누었을 때 나누어 떨어지지 않으면
    // 거듭제곡 꼴이면서 가장 큰 약수와 숫자의 수를 곱해 합에 추가
    private static long function(long num) {
        long sum = 0;
        long divisor = 1;

        while(num > 0) {
            sum += divisor * (num - (num / 2));
            num /= 2;
            divisor *= 2;
        }

        return sum;
    }

}