import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 풀이: 우선순위 큐
        // 1. 우선순위 큐를 내림차순으로 정의하고 값을 넣음
        // 2. 추출한 값이 K보다 크면 카운트하고 만족감을 계산 및 기록
        // 3. 조건을 충족하면 작업횟수와 만족감 출력
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }
        
        int cnt = 0;
        int before = 0;
        while (priorityQueue.peek() > K) {
            cnt++;
            int work = priorityQueue.poll();
            int satisfaction = (before / 2) + work;
            sb.append(satisfaction).append("\n");
            before = satisfaction;
            priorityQueue.offer(work - M);
        }

        System.out.println(cnt);
        System.out.print(sb);
    }
}