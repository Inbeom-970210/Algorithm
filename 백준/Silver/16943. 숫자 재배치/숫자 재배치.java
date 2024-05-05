import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] nums;
    static boolean[] checked;
    static int B;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = st.nextToken().split("");
        checked = new boolean[nums.length];
        B = Integer.parseInt(st.nextToken());
        res = -1;

        String[] arr = new String[nums.length];
        findMax(0, arr);

        System.out.print(res);
    }

    private static void findMax(int depth, String[] arr) {
        if (arr[0] != null && arr[0].equals("0")) return;
        if (depth == nums.length) {
            String num = "";
            for (String val : arr) {
                num += val;
            }
            int max = Integer.parseInt(num);
            if (max < B) res = Math.max(res, max);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (checked[i]) continue;
            checked[i] = true;
            arr[depth] = nums[i];
            findMax(depth + 1, arr);
            checked[i] = false;
        }
    }
}