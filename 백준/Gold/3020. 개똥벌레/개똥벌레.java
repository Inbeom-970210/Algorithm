import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 동굴의 길이; 2 <= N <= 200,000
        // H는 동굴의 높이; 2 <= H <= 500,000
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[H + 1];
        int[] up = new int[H + 1];
        for(int i = 1; i <= N / 2; ++i) {
            ++down[Integer.parseInt(br.readLine())];
            ++up[H - Integer.parseInt(br.readLine()) + 1];
        }

        for(int i = H - 1; i >= 1; --i) {
            down[i] += down[i + 1];
        }

        for(int i = 2; i <= H; ++i) {
            up[i] += up[i - 1];
        }

        int min = N;
        int cnt = 1;
        for(int i = 1; i <= H; ++i) {
            if(min > down[i] + up[i]) {
                min = down[i] + up[i];
                cnt = 1;
            } else if (min == down[i] + up[i]) ++cnt;
        }
        
        System.out.print(min + " " + cnt);

    }
}