import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = new int[N];

        for (int i = 1; i <= N; i++) {
            int val = 0;
            for (int j = 0; j < N; j++) {
                if (val == nums[i - 1] && 0 == ans[j]) {
                    ans[j] = i;
                    break;
                }
                if (0 == ans[j]) val++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int one : ans) {
            sb.append(one).append(" ");
        }

        System.out.print(sb);
    }
}
