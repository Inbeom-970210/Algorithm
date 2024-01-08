import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N은 출전한 학생의 수이자, 깃발 개수; 1 <= N <= 2,100,000,000
        // 문제 해결: 약수의 개수가 홀수면 백기
        // N은 math.sqrt(N)을 기준으로 약수 개수가 대칭임
        // 따라서 제곱근을 약수고 가져야 약수가 홀수개 -> 이를 구해서 카운트
        long N = Long.parseLong(br.readLine());
        long res = 0;

        for(int i = 1; i <= Math.sqrt(N); i++) {
            if(Math.pow(i, 2) <= N) res++;
        }

        System.out.print(res);
    }
}