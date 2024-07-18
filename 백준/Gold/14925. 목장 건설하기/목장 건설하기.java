import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                search(r, c, map);
            }
        }

        System.out.print(answer);
    }

    private static void search(int row, int col, int[][] map) {
        int len = answer;
        loof:
        while (row + len < M && col + len < N) {
            for (int r = row; r <= row + len; r++) {
                for (int c = col; c <= col + len; c++) {
                    if (map[r][c] > 0) {
                        break loof;
                    }
                }
            }
            len++;
        }
        answer = len;
    }

}