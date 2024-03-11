import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] costs, friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 <= N <= 10,000; 0 <= M <= 10,000; 1 <= k <= 10,000,000
        // 1 <= A[i] <= 10,000; 1 <= i <= N
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        costs = new int[N + 1];
        friends = new int[N + 1];
        boolean[] checked = new boolean[N + 1];
        for (int i = 1; i <= N; ++i) {
            costs[i] = Integer.parseInt(st.nextToken());
            friends[i] = i;
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= N; ++i) {
            friends[i] = find(i);
        }

        int res = 0;
        for (int i = 1; i <= N; ++i) {
            if (checked[i]) continue;

            int high = find(i);
            res += costs[high];
            for (int j = 1; j <= N; ++j) {
                if (find(j) == high) checked[j] = true;
            }
        }

        if (res > k) System.out.print("Oh no");
        else System.out.print(res);
    }

    private static void union(int i1, int i2) {
        int high1 = find(i1);
        int high2 = find(i2);

        if (high1 == high2) return;

        if (costs[high1] < costs[high2]) friends[high2] = friends[high1];
        else friends[high1] = friends[high2];
    }

    private static int find(int idx) {
        if (friends[idx] == idx) return friends[idx];
        return find(friends[idx]);
    }

}