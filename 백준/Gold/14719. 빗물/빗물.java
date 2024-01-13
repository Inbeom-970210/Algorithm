import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // H는 높이; 1 <= H <= 500
        // W는 너비; 1 <= W <= 500
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[H][W];

        st = new StringTokenizer(br.readLine());
        for(int c = 0; c < W; ++c) {
            int block = Integer.parseInt(st.nextToken());
            for(int r = 0; r < block; ++r) {
                map[r][c] = true;
            }
        }

        int res = 0;
        for(int r = 0; r < H; ++r) {
            boolean left = false;
            int sum = 0;

            for(int c = 0; c < W; ++c) {
                if(!map[r][c] && !left) continue;

                if (!map[r][c] && left) ++sum;
                else if (map[r][c] && !left) left = true;
                else {
                    res += sum;
                    sum = 0;
                }
            }
        }

        System.out.print(res);

    }
}