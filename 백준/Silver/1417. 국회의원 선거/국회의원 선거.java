import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1 <= N <= 50
        int[] arr = new int[N];
        int maxIdx = 0;
        int res = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 1 <= arr[i] <= 100
            if(arr[i] >= arr[maxIdx]) maxIdx = i;
        }

        while (maxIdx != 0) {
            arr[0]++;
            arr[maxIdx]--;
            res++;

            for(int i = 0; i < N; i++) {
                if(arr[i] >= arr[maxIdx]) maxIdx = i;
            }
        }

        System.out.print(res);
    }
}