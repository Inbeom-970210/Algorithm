import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] temperature;
    static int[][][][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 5,000
        N = Integer.parseInt(br.readLine());
        temperature = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        DP = new int[N + 1][10][10][10];
        for (int[][][] arr3D : DP) {
            for (int[][] arr2D : arr3D) {
                for (int[] arr : arr2D) {
                    Arrays.fill(arr, -1);
                }
            }
        }

        /*
        풀이 : [0,0,0] -> [5, 0, 0]
                      -> [0, 5, 0]
                      -> [0, 0, 5]
        요리마다 인덕션의 수만큼 분기가 생긴다. 따라서 분기마다 클릭 수의 최소값을 구하고 이를 비교해서 답을 구한다.
        */
        int res = getMinClick(0, 0, 0, 0);
        System.out.print(res);
    }

    private static int getMinClick(int depth, int x, int y, int z) {
        if (depth == N) return 0;

        if (DP[depth][x][y][z] == -1) {
            int total = Integer.MAX_VALUE;
            total = Math.min(total, getMinClick(depth + 1, temperature[depth + 1], y, z) + getCiickNum(x, temperature[depth + 1]));
            total = Math.min(total, getMinClick(depth + 1, x, temperature[depth + 1], z) + getCiickNum(y, temperature[depth + 1]));
            total = Math.min(total, getMinClick(depth + 1, x, y, temperature[depth + 1]) + getCiickNum(z, temperature[depth + 1]));
            DP[depth][x][y][z] = total;
        }
        return DP[depth][x][y][z];
    }

    private static int getCiickNum(int pre, int cur) {
        int len = 0;
        if (Math.abs(pre - cur) <= 5) len = Math.abs(pre - cur);
        else len = 10 - Math.abs(pre - cur);

        return len;
    }

}