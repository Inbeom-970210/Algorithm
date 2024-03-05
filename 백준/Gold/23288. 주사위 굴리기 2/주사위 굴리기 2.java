import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2 <= N, M <= 20; 1 <= K <= 1,000
        // 1 <= map[r][c] < 10
        // dir: 0(북), 1(동), 2(남), 3(서)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        Dice dice = new Dice();
        int dir = 1;
        int res = 0;

        // K번 이동
        while (K-- > 0) {
            // 1. 주사위가 이동 방향으로 한 칸 굴러간다. 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
            dir = oper1(dice, map, dir);
            // 2. 주사위가 도착한 칸(r, c)에 대한 점수를 획득한다.
            res += oper2(dice, map);
            // 3. 주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸(r, c)에 있는 정수 B를 비교해 이동 방향을 결정한다.
            dir = oper3(dice, map, dir);
        }

        System.out.print(res);
    }

    private static int oper3(Dice dice, int[][] map, int dir) {
        int A = dice.body[3];
        int B = map[dice.r][dice.c];
        if (A > B) dir = (dir + 1) % 4;
        else if (A < B) dir = (dir + 3) % 4;

        return dir;
    }

    private static int oper2(Dice dice, int[][] map) {
        boolean[][] checked = new boolean[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int score = 0;
        queue.offer(new int[]{dice.r, dice.c});
        checked[dice.r][dice.c] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            score += map[curr[0]][curr[1]];

            for (int dir = 0; dir < 4; ++dir) {
                int nextR = curr[0] + D[dir][0];
                int nextC = curr[1] + D[dir][1];
                if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) continue;
                if (checked[nextR][nextC]) continue;
                if (map[nextR][nextC] != map[curr[0]][curr[1]]) continue;

                queue.offer(new int[]{nextR, nextC});
                checked[nextR][nextC] = true;
            }
        }

        return score;
    }

    private static int oper1(Dice dice, int[][] map, int dir) {
        int nextR = dice.r + D[dir][0];
        int nextC = dice.c + D[dir][1];
        if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) dir = (dir + 2) % 4;
        dice.move(dir);

        return dir;
    }

}

class Dice {
    int r;
    int c;
    int left;
    int right;
    int[] body;

    public Dice() {
        r = 0;
        c = 0;
        left = 4;
        right = 3;
        body = new int[]{2, 1, 5, 6};
    }

    public void move(int dir) {
        int tmp;
        switch (dir) {
            case 0:
                --r;
                tmp = body[0];
                body[0] = body[1];
                body[1] = body[2];
                body[2] = body[3];
                body[3] = tmp;
                break;
            case 1:
                ++c;
                tmp = right;
                right = body[1];
                body[1] = left;
                left = body[3];
                body[3] = tmp;
                break;
            case 2:
                ++r;
                tmp = body[3];
                body[3] = body[2];
                body[2] = body[1];
                body[1] = body[0];
                body[0] = tmp;
                break;
            case 3:
                --c;
                tmp = left;
                left = body[1];
                body[1] = right;
                right = body[3];
                body[3] = tmp;
                break;
        }
    }
}