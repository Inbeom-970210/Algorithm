import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        boolean[] visited = new boolean[100001];
        Queue<info> q = new LinkedList<>();

        q.offer(new info(N, 0));
        visited[N] = true;
        while (!q.isEmpty()) {
            info cur = q.poll();

            if (cur.location == K) {
                answer = cur.time;
                int[] temp = new int[answer + 1];
                int idx = answer + 1;
                while (cur != null) {
                    temp[--idx] = cur.location;
                    cur = cur.pre;
                }
                for (int val : temp) {
                    sb.append(val).append(" ");
                }
                break;
            }

            int nextLocation;
            int nextTime = cur.time + 1;
            if (cur.location == 0) {
                nextLocation = cur.location + 1;
                move(nextLocation, nextTime, cur, visited, q);
            } else if (cur.location == 100000) {
                nextLocation = cur.location - 1;
                move(nextLocation, nextTime, cur, visited, q);
            } else if (cur.location <= 50000) {
                nextLocation = cur.location + 1;
                move(nextLocation, nextTime, cur, visited, q);

                nextLocation = cur.location - 1;
                move(nextLocation, nextTime, cur, visited, q);

                nextLocation = cur.location * 2;
                move(nextLocation, nextTime, cur, visited, q);
            } else {
                nextLocation = cur.location + 1;
                move(nextLocation, nextTime, cur, visited, q);

                nextLocation = cur.location - 1;
                move(nextLocation, nextTime, cur, visited, q);
            }

        }

        System.out.println(answer);
        System.out.print(sb);
    }

    public static void move(int location, int time, info cur, boolean[] visited, Queue q) {
        if (visited[location]) return;

        visited[location] = true;
        info next = new info(location, time);
        next.setPre(cur);
        q.offer(next);
    }
}

class info {

    int location;
    int time;
    info pre;

    public info(int location, int time) {
        this.location = location;
        this.time = time;
    }

    public void setPre(info pre) {
        this.pre = pre;
    }
}