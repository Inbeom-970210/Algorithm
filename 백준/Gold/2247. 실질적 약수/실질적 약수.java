import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n은 주어진 정수; 1 <= n <= 200,000,000
        
        // 나누려는 수의 배수의 갯수를 구해서 문제 해결
        // n/2까지만 자기 자신을 제외한 약수가 있으니까 n/2까지만 반복
        long n = Long.parseLong(br.readLine());
        long res = 0;

        for(int div = 2; div <= n / 2; div++) {
            res += div * ((n / div) - 1);
        }

        System.out.print(res % 1000000);
    }
}