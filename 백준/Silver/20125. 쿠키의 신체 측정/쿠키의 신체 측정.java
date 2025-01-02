import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] chest = new int[2];
        loof:
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if ('*' == map[r][c]) {
                    chest[0] = r + 1;
                    chest[1] = c;
                    sb.append((chest[0] + 1) + " " + (chest[1] + 1)).append("\n");
                    break loof;
                }
            }
        }

        int len, cur;
        int[] dc = {-1, 1};
        for (int dir : dc) {
            len = 0;
            cur = chest[1];
            while (cur + dir >= 0 && cur + dir < N && '*' == map[chest[0]][cur + dir]) {
                len++;
                cur += dir;
            }
            sb.append(len + " ");
        }

        len = 0;
        cur = chest[0];
        while ('*' == map[cur + 1][chest[1]]) {
            len++;
            cur += 1;
        }
        sb.append(len + " ");
        chest[0] = cur;

        for (int dir : dc) {
            len = 0;
            cur = chest[0];
            while (cur + 1 < N && '*' == map[cur + 1][chest[1] + dir]) {
                len++;
                cur++;
            }
            sb.append(len + " ");
        }

        System.out.print(sb);
    }
}