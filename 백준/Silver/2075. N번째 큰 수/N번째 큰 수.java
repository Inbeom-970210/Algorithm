import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                priorityQueue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // 풀이: 우선순위큐
        // 모든 값을 우선순위큐(내림차순)에 넣음
        // N번째 꺼내는 수는 N번째 큰 수이다.
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = priorityQueue.poll();
        }

        System.out.print(answer);
    }
}