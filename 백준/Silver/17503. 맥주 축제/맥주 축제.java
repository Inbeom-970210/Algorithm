import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 맥주의 선호도(v)와 도수 레벨(c)
        // 마실 맥주를 선택할 때 도수가 낮고, 선호도가 높은 맥주를 우선함
        // 도수를 기준으로 오름차순 정렬, 선호도를 기준으로 내림차순 정렬
        int[][] beers = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers[i][0] = v;
            beers[i][1] = c;
        }
        Arrays.sort(beers, (o1, o2) -> {
            if (o1[1] == o2[1]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });

        // 마실 맥주를 바꿀 때 선호도가 낮고, 도수가 높은 맥주를 뺌
        // 선호도를 기준으로 오름차순 정렬, 도수를 기준으로 내림차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        }));
        int level = -1;
        int sum = 0;
        int idx = -1;

        // 맥주 N를 선택하면서 선호도 M이상이면 탈출 or 모든 맥주를 순회하면 탈출
        while ((sum < M || pq.size() < N) && idx < K - 1) {
            if (pq.size() == N) {
                sum -= pq.poll()[0];
            }

            pq.offer(beers[++idx]);
            sum += beers[idx][0];
        }

        if (sum >= M) {
            for (int[] beer : pq) {
                level = Math.max(level, beer[1]);
            }
        }

        System.out.print(level);
    }
}