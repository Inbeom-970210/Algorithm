import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1};
    static int[] dc = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            DP[i][i] = 1;
        }

        // 팰린드롬이면 S, E 이내 대칭 역시 팰린드롬이다
        // 팰린드롬이 아니면 S, E를 포함하여 대칭이면 이 역시 팰린드롬이 아님
        // DP[start][end]: 팰린드롬 여부. 0(검사 필요), 1(팰린드롬), 2(팰린드롬 아님)
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (DP[S][E] == 0) {
                DP[S][E] = validatePalindrom(S, E, nums);
                int start = S;
                int end = E;
                if (DP[S][E] == 1) {
                    while (++start < --end) {
                        DP[start][end] = 1;
                    }
                } else {
                    while (--start >= 1 && ++end <= N) {
                        DP[start][end] = 2;
                    }
                }
            }

            sb.append(DP[S][E] == 2 ? 0 : DP[S][E]).append("\n");
        }

        System.out.println(sb);
    }

    // 팰린드롬 검사
    // 팰린드롬이면 1반환 아니면 2반환
    private static int validatePalindrom(int start, int end, int[] nums) {
        boolean flag = true;
        do {
            if (nums[start] != nums[end]) {
                flag = false;
                break;
            }
        } while (++start < --end);

        return flag ? 1 : 2;
    }
}