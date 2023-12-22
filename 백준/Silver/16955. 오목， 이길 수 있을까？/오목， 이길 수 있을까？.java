import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        res = 0;
        char[][] map = new char[10][10];
        for(int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(map[i][j] != 'O' && i + 4 < 10) column(map, i, j);
                if(map[i][j] != 'O' && j + 4 < 10) row(map, i, j);
                if(map[i][j] != 'O' && i + 4 < 10 && j + 4 < 10) diagonalR(map, i, j);
                if(map[i][j] != 'O' && i + 4 < 10 && j - 4 >= 0) diagonalL(map, i, j);
            }
        }

        System.out.print(res);
    }

    private static void diagonalL(char[][] map, int i, int j) {
        int cnt = 0;
        for(int d = 0; d < 5; d++) {
            if(map[i + d][j - d] == 'X') cnt++;
            else if (map[i + d][j - d] == 'O') return;
        }
        if(cnt == 4) res = 1;
    }

    private static void row(char[][] map, int i, int j) {
        int cnt = 0;
        for(int r = 0; r < 5; r++) {
            if(map[i][j + r] == 'X') cnt++;
            else if (map[i][j + r] == 'O') return;
        }
        if(cnt == 4) res = 1;
    }

    private static void column(char[][] map, int i, int j) {
        int cnt = 0;
        for(int c = 0; c < 5; c++) {
            if(map[i + c][j] == 'X') cnt++;
            else if (map[i + c][j] == 'O') return;
        }
        if(cnt == 4) res = 1;
    }

    private static void diagonalR(char[][] map, int i, int j) {
        int cnt = 0;
        for(int d = 0; d < 5; d++) {
            if(map[i + d][j + d] == 'X') cnt++;
            else if (map[i + d][j + d] == 'O') return;
        }
        if(cnt == 4) res = 1;
    }
}