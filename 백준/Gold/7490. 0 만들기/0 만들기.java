import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int N;
    static char[] str;
    static char[] ops = {' ', '+', '-'};

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            str = new char[N * 2 - 1];
            str[0] = '1';
            dfs(1, 0, 1, 1);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int num, int sum, int op, int depth) {
        if (depth == N) {
            sum += (num * op);
            if (sum == 0) sb.append(str).append("\n");
            return;
        }

        for (char c : ops) {
            str[depth * 2 - 1] = c;
            str[depth * 2] = Character.forDigit(depth + 1, 10);

            if (c == ' ') {
                dfs(num * 10 + (depth + 1), sum, op, depth + 1);
            } else if (c == '+') {
                dfs(depth + 1, sum + (num * op), 1, depth + 1);
            } else {
                dfs(depth + 1, sum + (num * op), -1, depth + 1);
            }
        }
    }
}