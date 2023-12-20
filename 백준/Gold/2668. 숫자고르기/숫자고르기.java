import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int[] arr;
    static boolean[] checked;
    static ArrayList<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 1 <= N <= 100
        arr = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        checked = new boolean[N + 1];
        res = new ArrayList<>();

        for(int i = 1; i < N + 1; i++) {
            checked[i] = true;
            dfs(i, i);
            checked[i] = false;
        }

        Collections.sort(res);
        sb.append(res.size()).append("\n");
        for(int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    private static void dfs(int start, int target) {
        if(!checked[arr[start]]) {
            checked[arr[start]] = true;
            dfs(arr[start], target);
            checked[arr[start]] = false;
        }
        if(arr[start] == target) res.add(target);
    }
}