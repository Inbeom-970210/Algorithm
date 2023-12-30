import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N은 인명구조원의 수; 1 <= N <= 100
        // lgArr는 인명구조원의 근무시간; 0이상 1000이하
        int N = Integer.parseInt(br.readLine());
        int[][] lgArr = new int[N + 1][2];
        int[] time = new int[1001];
        int max = 0;
        int res = 0;

        for(int lg = 1; lg <= N; lg++) {
            st = new StringTokenizer(br.readLine());
            lgArr[lg][0] = Integer.parseInt(st.nextToken());
            lgArr[lg][1] = Integer.parseInt(st.nextToken());

            for(int i = lgArr[lg][0]; i < lgArr[lg][1]; i++) {
                time[i]++;
            }
        }

        for(int i = 0; i <= 1000; i++) {
            if(time[i] == 0) continue;
            max++;
        }

        for(int lg = 1; lg <= N; lg++) {
            int sum = 0;
            for(int i = lgArr[lg][0]; i < lgArr[lg][1]; i++) {
                if(time[i] != 1) continue;
                sum++;
            }
            res = Math.max(res, (max - sum));
        }

        System.out.print(res);

    }
}