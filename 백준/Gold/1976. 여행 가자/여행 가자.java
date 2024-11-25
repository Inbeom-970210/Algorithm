import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] roots = new int[N + 1];
        for (int r = 1; r <= N; r++) {
            roots[r] = r;
        }
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp > 0) union(r, c, roots);
            }
        }

        String ans = "YES";
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= M; i++) {
            int end = Integer.parseInt(st.nextToken());
            if (roots[start] != roots[end]) {
                ans = "NO";
                break;
            }
        }

        System.out.print(ans);
    }

    private static void union(int start, int end, int[] roots) {
        start = find(start, roots);
        end = find(end, roots);
        if (start != end) {
            if (start <= end) roots[end] = start;
            else roots[start] = end;
        }
    }

    private static int find(int one, int[] roots) {
        if (roots[one] == one) return one;
        else return roots[one] = find(roots[one], roots);
    }
}