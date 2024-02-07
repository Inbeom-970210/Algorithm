import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static int[] test;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[10];
        test = new int[10];
        for (int i = 0; i < 10; ++i) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        // 모든 경우를 고려, 3개의 연속된 답이 없고 5개 이상 맞추면 카운트
        res = 0;
        recursion(0);

        System.out.print(res);
    }

    private static void recursion(int depth) {
        if (depth == 10) {
            if (!isAvailable()) return;
            int cnt = 0;
            for (int i = 0; i < 10; ++i) {
                if (test[i] == answer[i]) ++cnt;
            }

            if (cnt >= 5) ++res;
            return;
        }

        for (int i = 1; i <= 5; ++i) {
            test[depth] = i;
            recursion(depth + 1);
        }
    }

    private static boolean isAvailable() {
        for (int i = 2; i < 10; ++i) {
            if (test[i - 2] == test[i - 1] && test[i - 1] == test[i]) return false;
        }
        return true;
    }

}