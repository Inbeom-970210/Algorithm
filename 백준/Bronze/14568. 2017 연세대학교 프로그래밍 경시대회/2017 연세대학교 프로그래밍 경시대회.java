import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1 <= N(사탕의 총 개수) <= 100
        int res = 0;

        for(int A = 1; A <= N; A++) {
            for(int B = 1; B <= N; B++) {
                for(int C = 1; C <= N; C++) {
                    if(A + B + C != N) continue;
                    if(B + 2 > C) continue;
                    if(A % 2 == 1) continue;

                    res++;
                }
            }
        }

        System.out.print(res);
    }
}