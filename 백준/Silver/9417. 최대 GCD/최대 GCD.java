import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] selected;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 1 < N < 100

        for(int test = 0; test < N; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = st.countTokens();   // 1 < M < 100
            int[] arr = new int[M];
            selected = new int[2];
            res = 0;
            for(int i = 0; i < M; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int fir = 0; fir < M; fir++) {
                selected[0] = Math.abs(arr[fir]);
                for(int sec = fir + 1; sec < M; sec++) {
                    selected[1] = Math.abs(arr[sec]);
                    funtion(1);
                    selected[0] = Math.abs(arr[fir]);
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }

    private static void funtion(int GCD) {
        if(selected[0] == 0 || selected[1] == 0) return;
        if(selected[0] == 1 || selected[1] == 1) {
            res = Math.max(res, GCD);
            return;
        }

        int min = Math.min(selected[0], selected[1]);
        for(int i = 2; i <= min; i++) {
            if(selected[0] % i == 0 && selected[1] % i == 0) {
                selected[0] /= i;
                selected[1] /= i;
                funtion(GCD * i);
                break;
            }
        }

        res = Math.max(res, GCD);
    }
}