import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int base;
    static int total;
    static boolean[] checkedPerson;
    static boolean[] checkedPosition;
    static int[][] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            base = 0;
            total = Integer.MIN_VALUE;
            checkedPerson = new boolean[11];
            checkedPosition = new boolean[11];
            scores = new int[11][11];
            for (int r = 0; r < 11; r++) {
                st = new StringTokenizer(br.readLine());
                int cnt = 0;
                int position = 0;
                for (int c = 0; c < 11; c++) {
                    scores[r][c] = Integer.parseInt(st.nextToken());
                    if (scores[r][c] > 0) {
                        cnt++;
                        position = c;
                    }
                }

                if (cnt == 1) {
                    checkedPerson[r] = true;
                    checkedPosition[position] = true;
                    base += scores[r][position];
                }
            }

            getMaxTotal(0, base);
            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }

    private static void getMaxTotal(int person, int tempTotal) {
        if (person == 11) {
            total = Math.max(total, tempTotal);
        } else if (checkedPerson[person]) {
            getMaxTotal(person + 1, tempTotal);
        } else {
            for (int position = 0; position < 11; position++) {
                if (scores[person][position] == 0 || checkedPosition[position])
                    continue;
                checkedPosition[position] = true;
                getMaxTotal(person + 1, tempTotal + scores[person][position]);
                checkedPosition[position] = false;
            }
        }
    }


}
