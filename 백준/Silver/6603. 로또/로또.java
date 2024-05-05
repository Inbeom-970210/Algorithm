import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int k;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int[] res = new int[6];
            selectNum(0, 0, res);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void selectNum(int depth, int at, int[] res) {
        if (depth == 6) {
            for (int num : res) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i < k; i++) {
            res[depth] = nums[i];
            selectNum(depth + 1, i + 1, res);
        }

    }
}