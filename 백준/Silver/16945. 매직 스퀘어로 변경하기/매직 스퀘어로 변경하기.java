import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] square;
    static boolean[] visited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        square = new int[3][3];
        visited = new boolean[10];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        function(0, 0);

        System.out.print(res);
    }

    private static void function(int depth, int totalCost) {
        if (totalCost >= res) return;
        if (depth == 9) {
            int sum = square[0][0] + square[0][1] + square[0][2];
            if (isAvailable(sum)) res = totalCost;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int addCost = Math.abs(square[depth / 3][depth % 3] - i);
            int tmp = square[depth / 3][depth % 3];
            square[depth / 3][depth % 3] = i;
            function(depth + 1, totalCost + addCost);
            visited[i] = false;
            square[depth / 3][depth % 3] = tmp;
        }
    }

    private static boolean isAvailable(int sum) {
        if (sum != square[1][0] + square[1][1] + square[1][2]) return false;
        if (sum != square[2][0] + square[2][1] + square[2][2]) return false;
        if (sum != square[0][0] + square[1][0] + square[2][0]) return false;
        if (sum != square[0][1] + square[1][1] + square[2][1]) return false;
        if (sum != square[0][2] + square[1][2] + square[2][2]) return false;
        if (sum != square[0][0] + square[1][1] + square[2][2]) return false;
        return sum == square[0][2] + square[1][1] + square[2][0];
    }

}