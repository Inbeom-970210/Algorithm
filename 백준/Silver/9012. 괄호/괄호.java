import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] arr = br.readLine().toCharArray();
            int len = arr.length;

            for (int j = 0; j < len; j++) {
                switch (arr[j]) {
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if (!stack.empty() && stack.peek() == '(') stack.pop();
                        else stack.push(')');
                        break;
                }
            }
            sb.append(stack.empty() ? "YES" : "NO");
            stack.clear();

            if (i == T - 1) break;
            sb.append("\n");
        }

        System.out.print(sb);
    }
}