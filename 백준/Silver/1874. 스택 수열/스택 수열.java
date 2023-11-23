import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());    // 1 <= n <= 100,000
        int idx = 0;    // 스택 수열의 인데스
        int[] stackArr = new int[n];
        for (int i = 0; i < n; i++) {
            stackArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (i > stackArr[idx]) {
                System.out.println("NO");
                return;
            } else if (i == stackArr[idx]) {
                sb.append("+\n");
                stack.push(i);
                while (!stack.empty()) {
                    if (stack.peek() > stackArr[idx]) {
                        System.out.println("NO");
                        return;
                    } else if (stack.peek() == stackArr[idx]) {
                        sb.append("-\n");
                        stack.pop();
                        idx++;
                    } else {
                        break;
                    }
                }
            } else {
                sb.append("+\n");
                stack.push(i);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(stack.size() == 0 ? sb : "NO");
    }
}