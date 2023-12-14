import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int res;
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        res = 0;
        N = Integer.parseInt(st.nextToken());   // 4 <= N <= 500
        M = Integer.parseInt(st.nextToken());   // 4 <= M <= 500
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());   // 1 <= 요소 값 <= 1,000
            }
        }

        // 브루트포스
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tetroI(i, j);
                tetroO(i, j);
                tetroL(i, j);
                tetroS(i, j);
                tetroT(i, j);
            }
        }

        System.out.print(res);
    }

    private static void tetroT(int i, int j) {
        if(i + 1 < N && j + 2 < M) {
            int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
            res = Math.max(res, sum);
        }

        if(i + 2 < N && j + 1 < M) {
            int sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
            res = Math.max(res, sum);
        }
    }

    private static void tetroS(int i, int j) {
        if(i + 2 < N && j + 1 < M) {
            int sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
            res = Math.max(res, sum);
        }

        if(i + 1 < N && j + 2 < M) {
            int sum = map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
            res = Math.max(res, sum);
        }
    }

    private static void tetroL(int i, int j) {
        if(i + 2 < N && j + 1 < M) {
            int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j] + map[i + 2][j + 1];
            res = Math.max(res, sum);

            sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
            res = Math.max(res, sum);
        }

        if(i + 1 < N && j + 2 < M) {
            int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
            res = Math.max(res, sum);

            sum = map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
            res = Math.max(res, sum);

            sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
            res = Math.max(res, sum);

            sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
            res = Math.max(res, sum);
        }
    }

    private static void tetroO(int i, int j) {
        if(i + 1 < N && j + 1 < M) {
            int sum = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1];
            res = Math.max(res, sum);
        }
    }

    private static void tetroI(int i, int j) {
        if(i + 3 < N) {
            int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
            res = Math.max(res, sum);
        }

        if(j + 3 < M) {
            int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
            res = Math.max(res, sum);
        }
    }
}