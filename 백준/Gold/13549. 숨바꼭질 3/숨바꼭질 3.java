import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K + 1];

        for (int i = 0; i <= K; i++) {
            if (i <= N) {
                arr[i] = N - i;
            } else {
                if (i % 2 == 0) {
                    arr[i] = Math.min(arr[i / 2], arr[i - 1] + 1);
                } else {
                    arr[i] = Math.min(arr[(i + 1) / 2] + 1, arr[i - 1] + 1);
                }
            }
        }

        System.out.print(arr[K]);
    }
}