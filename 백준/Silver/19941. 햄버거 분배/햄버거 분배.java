import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] table;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        table = br.readLine().toCharArray();
        visited = new boolean[N];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (table[i] == 'H') continue;
            for (int loc = i - K; loc <= i + K; loc++) {
                if (!validate(i, loc, N)) continue;
                cnt++;
                visited[loc] = true;
                break;
            }
        }

        System.out.print(cnt);
    }

    private static boolean validate(int i, int loc, int N) {
        if (loc < 0 || loc >= N || i == loc || visited[loc] || table[loc] == 'P') return false;
        return true;
    }
}