import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());   // 1 <= a(양 한 마리가 하루에 먹는 사료) <= 1,000
        int b = Integer.parseInt(st.nextToken());   // 1 <= b(염소 한 마리가 하루에 먹는 사료) <= 1,000
        int n = Integer.parseInt(st.nextToken());   // 2 <= n(양과 염소의 전체 수) <= 1,000
        int w = Integer.parseInt(st.nextToken());   // 2 <= w(하루 소비 사료) <= 1,000,000

        // 완전탐색으로 양의 수와 염소의 수 구하기
        int[] res = new int[2];
        int flag = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= n - i; j++) {
                if(i + j != n) continue;
                if((a * i + b * j) != w) continue;

                flag++;
                res[0] = i;
                res[1] = j;
            }
        }

        if(flag == 1) System.out.print(res[0] + " " + res[1]);
        else System.out.print(-1);
    }
}