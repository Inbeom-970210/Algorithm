import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();

        // 5 <= N <= 25
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        boolean[][] checked = new boolean[N][N];
        for (int r = 0; r < N; ++r) {
            map[r] = br.readLine().toCharArray();
        }

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (map[r][c] == '0') continue;
                if (checked[r][c]) continue;

                getComplexNum(r, c, map, checked, list);
            }
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); ++i) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    private static void getComplexNum(int row, int col, char[][] map, boolean[][] checked, LinkedList<Integer> list) {
        Queue<int[]> queue = new LinkedList<>();
        int complexNum = 0;

        checked[row][col] = true;
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            ++complexNum;

            for (int dir = 0; dir < 4; ++dir) {
                int nextR = curr[0] + D[dir][0];
                int nextC = curr[1] + D[dir][1];
                if (nextR < 0 || nextR >= map.length || nextC < 0 || nextC >= map[0].length) continue;
                if (map[nextR][nextC] == '0' || checked[nextR][nextC]) continue;

                checked[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC});
            }
        }

        list.offer(complexNum);
    }
}