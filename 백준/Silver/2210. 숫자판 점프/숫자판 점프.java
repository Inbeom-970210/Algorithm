import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] graph = new String[5][5];

        for (int r = 0; r < 5; r++) {
            graph[r] = br.readLine().split(" ");
        }

        Set<String> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                queue.offer(new Node(graph[r][c], r, c, 1));
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.len > 5) {
                set.add(cur.num);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nextR = cur.row + dr[d];
                int nextC = cur.col + dc[d];

                if (nextR >= 0 && nextR < 5 && nextC >= 0 && nextC < 5) {
                    queue.offer(new Node(cur.num + graph[nextR][nextC], nextR, nextC, cur.len + 1));
                }
            }
        }

        System.out.print(set.size());
    }
}

class Node {
    String num;
    int row;
    int col;
    int len;

    Node(String num, int row, int col, int len) {
        this.num = num;
        this.row = row;
        this.col = col;
        this.len = len;
    }
}