import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 은 정수 개수; 1 <= n <= 100,000
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = Integer.parseInt(st.nextToken());
        int[] sum = {0, 0};
        if(res > 0) {
            sum[0] = res;
            sum[1]++;
        }
        for(int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num >= 0) {
                sum[0] += num;
                sum[1] ++;
            }
            else if(num + sum[0] <= 0) {
                if(sum[1] < 1) res = Math.max(res, num);
                else res = Math.max(res, sum[0]);
                sum[0] = 0;
                sum[1] = 0;
            }
            else {
                res = Math.max(res, sum[0]);
                sum[0] += num;
                sum[1] ++;
            }
//            System.out.println("num: " + num);
//            System.out.println(i + ": " + res + "// sum: " + sum[0]);
        }

        if(sum[1] > 0) res = Math.max(res, sum[0]);
        System.out.print(res);
    }
}