import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        int locationR = 0;
        int locationC = 0;
        for (int r = 0; r < R; r++) {
            String[] row = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                String state = row[c];
                switch (state) {
                    case "D":
                        map[r][c] = 5;
                        break;
                    case "S":
                        map[r][c] = 4;
                        locationR = r;
                        locationC = c;
                        cnt++;
                        break;
                    case "X":
                        map[r][c] = 3;
                        break;
                    case "*":
                        map[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        cnt++;
                        break;
                    case ".":
                        map[r][c] = 0;

                }
            }
        }

        int answer = -1;
        queue.offer(new int[]{locationR, locationC, 0});
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        loop:
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nextR = cur[0] + dir[0];
                int nextC = cur[1] + dir[1];
                if (3 == cur.length && validate(nextR, nextC, map, true)) {
                    if (map[nextR][nextC] == 5) {
                        answer = cur[2] + 1;
                        break loop;
                    }
                    map[nextR][nextC] = 4;
                    queue.offer(new int[]{nextR, nextC, cur[2] + 1});
                } else if (validate(nextR, nextC, map, false)) {
                    map[nextR][nextC] = 2;
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }

        System.out.print(answer > -1 ? answer : "KAKTUS");
    }

    private static boolean validate(int r, int c, int[][] map, boolean isAnimal) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return false;
        else if (2 == map[r][c]) return false;
        else if (3 == map[r][c]) return false;
        else if (5 == map[r][c]) return isAnimal;
        else if (4 == map[r][c]) return !isAnimal;
        else return true;
    }
}