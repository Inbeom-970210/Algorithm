import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap();

        // c는 테스트 케이스 개수; 1 <= c <= 200
        int c = Integer.parseInt(br.readLine());

        for(int t = 1; t <= c; ++t) {
            st = new StringTokenizer(br.readLine());
            int res = 0;

            // d는 나누는 수; 1 <= d <= 1,000,000
            // n은 수열의 크기; 1 <= n <= 50,000
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n + 1];

            map.put(0L, 1);
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());

                if(map.get(arr[i] % d) != null) res += map.get(arr[i] % d);


                if(map.get(arr[i] % d) == null) map.put(arr[i] % d, 1);
                else map.replace(arr[i] % d, map.get(arr[i] % d) + 1);
            }

            map.clear();
            sb.append(res).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }
}