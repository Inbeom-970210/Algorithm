import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] cleaner, D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 6 <= R, C <= 50; 1 <= T <= 1,000
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[][] room = new int[R][C];
        cleaner = new int[2][2];
        int idx = 0;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                room[r][c] = Integer.parseInt(st.nextToken());
                if (room[r][c] == -1) {
                    cleaner[idx][0] = r;
                    cleaner[idx++][1] = c;
                }
            }
        }

        // T초가 지남
        for (int time = 1; time <= T; ++time) {
            simulation(room);
        }

        int res = 2;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                res += room[r][c];
            }
        }

        System.out.print(res);

    }

    private static void simulation(int[][] room) {
        // 1. 미세먼지가 확산된다.
        dustSpread(room);
        // 2. 공기청정기가 작동한다.
        cleanerOperate(room);
    }

    private static void cleanerOperate(int[][] room) {
        int curR = cleaner[0][0] - 1;
        int curC = cleaner[0][1];

        while (curR > 0) {
            room[curR][curC] = room[curR - 1][curC];
            curR--;
        }
        while (curC < C - 1) {
            room[curR][curC] = room[curR][curC + 1];
            curC++;
        }
        while (curR < cleaner[0][0]) {
            room[curR][curC] = room[curR + 1][curC];
            curR++;
        }
        while (curC > 1) {
            room[curR][curC] = room[curR][curC - 1];
            curC--;
        }
        room[curR][curC] = 0;

        curR = cleaner[1][0] + 1;
        curC = cleaner[1][1];

        while (curR < R - 1) {
            room[curR][curC] = room[curR + 1][curC];
            curR++;
        }
        while (curC < C - 1) {
            room[curR][curC] = room[curR][curC + 1];
            curC++;
        }
        while (curR > cleaner[1][0]) {
            room[curR][curC] = room[curR - 1][curC];
            curR--;
        }
        while (curC > 1) {
            room[curR][curC] = room[curR][curC - 1];
            curC--;
        }
        room[curR][curC] = 0;
    }

    private static void dustSpread(int[][] room) {
        int[][] initRoom = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                initRoom[r][c] = room[r][c];
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (initRoom[r][c] <= 0) continue;

                int val = initRoom[r][c] / 5;
                int cnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = r + D[dir][0];
                    int nextC = c + D[dir][1];
                    if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) continue;
                    if ((nextR == cleaner[0][0] && nextC == cleaner[0][1]) || (nextR == cleaner[1][0] && nextC == cleaner[1][1]))
                        continue;

                    room[nextR][nextC] += val;
                    cnt++;
                }
                room[r][c] -= val * cnt;
            }
        }
    }

}