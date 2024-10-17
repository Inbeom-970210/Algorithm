import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] B = new int[H + X][W + Y];
        for (int r = 0; r < H + X; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W + Y; c++) {
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 겹치지 않는 부분은 B값을 그대로 사용
        // 2. 겹치는 부분은 X, Y값을 고려해 B값에서 A[r - X][c - Y]을 빼서 구함
        int[][] A = new int[H][W];
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (r < X || c < Y) A[r][c] = B[r][c];
                else {
                    A[r][c] = B[r][c] - A[r - X][c - Y];
                }
            }
        }

        for (int[] row : A) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}