import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ArrayList<int[]> meetingRooms = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      meetingRooms.add(
          new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
    }
    meetingRooms.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      } else {
        return o1[0] - o2[0];
      }
    });

    int answer = 1;
    for (int i = 0; i < N; i++) {
      pq.offer(meetingRooms.get(i)[1]);
      if (meetingRooms.get(i)[0] >= pq.peek()) {
        pq.poll();
      }
      answer = Math.max(answer, pq.size());
    }

    System.out.print(answer);
  }
}
