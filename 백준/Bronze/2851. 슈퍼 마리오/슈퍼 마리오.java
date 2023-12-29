import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[10];
        for(int i = 0; i < 10; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int close = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i <= 10; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += score[j];
            }

            // 이전 결과와 비슷하면 점수의 합이 큰 수를 정답으로 한다.
            // 이전 결과보다 100에 가까운 수면 이를 close에 할당하고, 정달을 점수의 합을 정답으로 한다.
            if(close == Math.abs(100 - sum)) {
                res = Math.max(res, sum);
            }
            else if(close > Math.abs(100 - sum)) {
                close = Math.min(close, Math.abs(100 - sum));
                res = sum;
            }
        }

        System.out.print(res);

    }
}