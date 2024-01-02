import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] res = new int[7];
        flag = false;
        int[] arr = new int[9];
        boolean[] check = new boolean[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, res, arr, check);
    }

    static void dfs(int depth, int sum, int[] res, int[] arr, boolean[] check) {
        if(flag) return;
        if(depth == 7) {
            if(sum == 100) {
                flag = true;
                Arrays.sort(res);
                for(int i = 0; i < 7; i++) {
                    System.out.println(res[i]);
                }
            }

            return;
        }

        for(int i = 0; i < 9; i++) {
            if(check[i]) continue;
            check[i] = true;
            res[depth] = arr[i];
            dfs(depth + 1, sum + arr[i], res, arr, check);
            check[i] = false;
        }
    }
}