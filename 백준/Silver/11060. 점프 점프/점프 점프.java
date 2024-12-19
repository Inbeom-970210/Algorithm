import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] jumps = new int[N];
        for (int i = 1; i < N; i++) {
            jumps[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if(arr[now] == 0) continue;
            for (int i = 1; i <= arr[now]; i++) {
                if(now + i >= N) continue;
                else if (jumps[now + i] > jumps[now] + 1) {
                    queue.offer(now + i);
                    jumps[now + i] = jumps[now] + 1;
                }
            }
        }

        System.out.print(jumps[N - 1] != Integer.MAX_VALUE ? jumps[N - 1] : -1);
    }
}