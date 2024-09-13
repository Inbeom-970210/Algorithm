import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // map 정보
        // 0(빈칸), -1(사과), 1~4(뱀 몸, 방향: 상, 우, 하, 좌)
        int[][] map = new int[N + 1][N + 1];
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = -1;
        }
        int L = Integer.parseInt(br.readLine());
        List<Redirection> redirections = new ArrayList<Redirection>();
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            redirections.add(new Redirection(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        redirections.add(new Redirection(10100, "END"));

        int[] tail = {1, 1};
        int[] head = {1, 1};
        int answer = calcultimeOfEnd(N, tail, head, map, redirections);
        System.out.print(answer);
    }

    // 풀이: map에 뱀 몸의 방향과, 사과를 표현 후 구현
    // 1. 머리가 움직이는 방향과, 꼬리까 뒤따라가는 방향을 관리
    // 2. 방향 전환(redirection)까지 이동 후 방향 수정
    // 3. 마지막 방향 전환은 충분히 큰 수로 반드시 종료
    private static int calcultimeOfEnd(int N, int[] tail, int[] head, int[][] map, List<Redirection> redirections) {
        int time = 0;
        int headDirection = 1;
        map[1][1] = 2;
        for (Redirection redirection : redirections) {
            int to = redirection.X - time;
            for (int t = 0; t < to; t++) {
                time++;
                head[0] += dr[headDirection];
                head[1] += dc[headDirection];

                if (head[0] < 1 || head[0] > N || head[1] < 1 || head[1] > N || map[head[0]][head[1]] > 0) {
                    return time;
                } else if (map[head[0]][head[1]] == 0) {
                    int tailDirection = map[tail[0]][tail[1]] - 1;
                    map[tail[0]][tail[1]] = 0;
                    tail[0] += dr[tailDirection];
                    tail[1] += dc[tailDirection];
                }

                map[head[0]][head[1]] = headDirection + 1;
            }

            if (redirection.C.equals("L")) headDirection = (headDirection + 3) % 4;
            else headDirection = (headDirection + 1) % 4;
            map[head[0]][head[1]] = headDirection + 1;
        }

        return time;
    }
}

class Redirection {
    int X;
    String C;

    public Redirection(int X, String C) {
        this.X = X;
        this.C = C;
    }
}