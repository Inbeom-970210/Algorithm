import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static int res;
    static int[] cat;
    static int[][] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        checked = new boolean[3];
        res = Integer.MAX_VALUE;
        cat = new int[2];
        people = new int[3][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        cat[0] = Integer.parseInt(st.nextToken());
        cat[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, cat);

        System.out.print(res);
    }

    private static void dfs(int depth, double length, int[] location) {
        if (depth == 3) res = Math.min(res, (int) length);

        for (int i = 0; i < 3; i++) {
            if (checked[i]) continue;

            checked[i] = true;
            double len = Math.sqrt(Math.pow(location[0] - people[i][0], 2) + Math.pow(location[1] - people[i][1], 2));
            dfs(depth + 1, length + len, people[i]);
            checked[i] = false;
        }
    }


}