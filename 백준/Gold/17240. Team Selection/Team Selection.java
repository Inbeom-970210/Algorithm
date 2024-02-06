import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, res;
    static int[][] arr;
    static int[] checked, order;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 5 <= n <= 20,000
        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        for(int r = 0; r < n; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 5; ++c) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        checked = new int[5];
        order = new int[5];
        visited = new boolean[5];


        // ★ 풀이
        // 능력치에 대해서 선별 순서를 정함
        // 해당 능력치가 가장 높은 사람은 뽑음(중복 불가능)
        res = 0;
        findOrder(0);

        System.out.print(res);
    }

    private static void findOrder(int depth) {
        if(depth == 5) {
            backtracking(0, 0);
            return;
        }

        for(int i = 0; i < 5; ++i) {
            if(visited[i]) continue;

            visited[i] = true;
            order[depth] = i;
            findOrder(depth + 1);
            visited[i] = false;
        }
    }

    private static void backtracking(int depth, int sum) {
        if(depth == 5) {
            res = Math.max(res, sum);
            return;
        }

        int idx = 0;
        for(int r = 0; r < n; ++r) {
            if(!isAvailable(r, depth)) continue;
            if(arr[r][order[depth]] > arr[idx][order[depth]]) idx = r;
        }
        checked[depth] = idx;
        backtracking(depth + 1, sum + arr[idx][order[depth]]);
    }

    private static boolean isAvailable(int r, int c) {
        for(int i = 0; i < c; ++i) {
            if(r == checked[i]) return false;
        }
        return true;
    }

}