import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] dolls = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      dolls[i] = Integer.parseInt(st.nextToken());
    }

    int setSize = -1;
    int left = 1;
    int right = N;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int cnt = 0;

      for (int i = 0; i < mid; i++) {
        if (1 == dolls[i]) {
          cnt++;
        }
      }

      int idx = mid;
      while (cnt < K && idx < N) {
        if (1 == dolls[idx]) {
          cnt++;
        }
        if (1 == dolls[idx - mid]) {
          cnt--;
        }
        idx++;
      }

      if (cnt >= K) {
        right = mid - 1;
        setSize = mid;
      } else {
        left = mid + 1;
      }
    }

    System.out.print(setSize);
  }
}
