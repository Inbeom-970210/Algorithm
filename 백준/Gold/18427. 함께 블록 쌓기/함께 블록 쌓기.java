import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        List<Integer>[] blocks = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            blocks[i] = new ArrayList();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] DP = new int[N + 1][H + 1];
        DP[0][0] = 1;
        Set<Integer> nums = new HashSet<>();
        nums.add(0);
        for (int i = 1; i <= N; i++) {

            for (int j = 0; j <= H; j++) {
                DP[i][j] = DP[i - 1][j];
            }

            HashSet<Integer> temp = new HashSet<>(nums);
            for (int num : temp) {
                for (int block : blocks[i]) {
                    if (block + num > H) continue;
                    DP[i][block + num] += DP[i - 1][num];
                    DP[i][block + num] %= 10007;
                    nums.add(block + num);
                }
            }

//            for (int val : DP[i]) {
//                System.out.print(val + " ");
//            }
//            System.out.println();
        }

        System.out.print(DP[N][H]);
    }
}