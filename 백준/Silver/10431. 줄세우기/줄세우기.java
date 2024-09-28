import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken() + " ");
            int[] students = new int[20];
            for (int i = 0; i < 20; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(lineUp(students)).append("\n");
        }

        System.out.println(sb);
    }

    private static int lineUp(int[] students) {
        int total = 0;
        int idx = 0;

        while (idx < 20) {
            boolean flag = false;
            for (int i = 0; i < idx; i++) {
                if (students[i] > students[idx]) {
                    total += swap(idx, i, students);
                    flag = true;
                    break;
                }
            }
            idx++;
        }

        return total;
    }

    private static int swap(int idx, int A, int[] students) {
        int cnt = 0;
        int tmp = students[idx];
        for (int i = idx - 1; i >= A; i--) {
            students[i + 1] = students[i];
            cnt++;
        }
        students[A] = tmp;

        return cnt;
    }
}