import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] function = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
            int[] values = new int[3];
            values[1] = n - 1;

            if (calcul(function, values)) {
                int start = values[0];
                int end = values[1];
                int state = values[2];

                sb.append("[");
                if (state == 0 && start <= end) {
                    for (int i = start; i <= end; i++) {
                        sb.append(arr[i]).append(",");
                    }
                } else if (state == 1) {
                    for (int i = end; i >= start; i--) {
                        sb.append(arr[i]).append(",");
                    }
                }

                if(sb.charAt(sb.length() - 1) != '[') sb.deleteCharAt(sb.length() - 1);
                sb.append("]").append("\n");
            } else {
                sb.append("error").append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean calcul(char[] function, int[] values) {
        int start = values[0];
        int end = values[1];
        int state = values[2];

        for (char c : function) {
            switch (c) {
                case 'R':
                    state = 1 - state;
                    break;
                case 'D':
                    if (state == 0) {
                        start++;
                    } else {
                        end--;
                    }
            }

            if (start > end + 1) return false;
        }

        values[0] = start;
        values[1] = end;
        values[2] = state;
        return true;
    }
}