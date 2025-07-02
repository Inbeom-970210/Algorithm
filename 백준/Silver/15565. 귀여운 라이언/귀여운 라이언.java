import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    ArrayList<Integer> locations = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      if ("1".equals(st.nextToken())) {
        locations.add(i);
      }
    }

    if (locations.size() < K) {
      System.out.print("-1");
    } else {
      int min = Integer.MAX_VALUE;
      for (int i = K - 1; i < locations.size(); i++) {
        min = Math.min(locations.get(i) - locations.get(i - K + 1) + 1, min);
      }
      System.out.print(min);
    }
  }
}
