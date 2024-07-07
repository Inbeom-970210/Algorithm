import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;
        boolean[] visited = new boolean[100001];
        PriorityQueue<inf> q = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        q.offer(new inf(N, 0));

        // BFS를 통한 풀이
        // 1. 현재 위치에서 이동할 수 있는 장소 BFS 탐색(-1, +1, *2)
        // 2. 목적지에 도착하면 최소 시간 구함
        while (!q.isEmpty()) {
            inf cur = q.poll();
            if (visited[cur.location]) continue;
            visited[cur.location] = true;

            if (cur.location == K) {
                answer = cur.time;
                break;
            }


            int nextLocation;
            int nextTime = cur.time + 1;
            if (cur.location == 0) {
                nextLocation = cur.location + 1;
                move(nextLocation, nextTime, q);
            } else if (cur.location == 100000) {
                nextLocation = cur.location - 1;
                move(nextLocation, nextTime, q);
            } else if (cur.location <= 50000) {
                nextLocation = cur.location + 1;
                move(nextLocation, nextTime, q);

                nextLocation = cur.location - 1;
                move(nextLocation, nextTime, q);

                nextLocation = cur.location * 2;
                move(nextLocation, cur.time, q);
            } else {
                nextLocation = cur.location + 1;
                move(nextLocation, nextTime, q);

                nextLocation = cur.location - 1;
                move(nextLocation, nextTime, q);
            }

        }

        System.out.print(answer);
    }

    /**
     * 이동 메서드
     * 1. 방문한 적이 있다면 이동하지 않음
     * 2. 방문한 적이 없다면 방문지 정보 생성(new inf()) 후 이동(q.offer())
     *
     * @param location
     * @param time
     * @param q
     */
    public static void move(int location, int time, Queue q) {
        inf next = new inf(location, time);
        q.offer(next);
    }
}

class inf {

    int location;
    int time;

    public inf(int location, int time) {
        this.location = location;
        this.time = time;
    }
}