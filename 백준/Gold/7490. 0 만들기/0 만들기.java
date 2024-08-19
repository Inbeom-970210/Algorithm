import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int N;
    static String sign;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            make0(1, 0, 0, "+", "");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void make0(int depth, int sum, int temp, String preSign, String expression) {
        int intPreSign = signToInt(preSign);
        int intSign = signToInt(sign);

        if (depth == N) {
            if (intPreSign == 0) {
                temp += depth;
                sum += temp * intSign;
            } else {
                sum += depth * intPreSign;
            }

            if (sum == 0) sb.append(expression.replace("+1", "1")).append(preSign).append(depth).append("\n");
            return;
        }

        if (intPreSign == 0) {
            make0(depth + 1, sum, (temp + depth) * 10, " ", expression + preSign + depth);
            make0(depth + 1, sum + (temp + depth) * intSign, 0, "+", expression + preSign + depth);
            make0(depth + 1, sum + (temp + depth) * intSign, 0, "-", expression + preSign + depth);
        } else {
            sign = preSign;
            make0(depth + 1, sum, depth * 10, " ", expression + preSign + depth);
            make0(depth + 1, sum + (depth * intPreSign), temp, "+", expression + preSign + depth);
            make0(depth + 1, sum + (depth * intPreSign), temp, "-", expression + preSign + depth);
        }
    }

    private static int signToInt(String sign) {
        if ("+".equals(sign)) return 1;
        else if ("-".equals(sign)) return -1;
        else return 0;
    }

}