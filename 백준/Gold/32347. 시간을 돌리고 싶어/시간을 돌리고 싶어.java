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
    boolean[] chargedDays = new boolean[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      if ("1".equals(st.nextToken())) {
        chargedDays[i] = true;
      }
    }

    int answer = N - 1;
    int min = 1;
    int max = N - 1;
    while (min <= max) {
      int mid = (max + min) / 2;

      if (validate(N, mid, K, chargedDays)) {
        answer = mid;
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    System.out.print(answer);
  }

  private static boolean validate(int location, int mid, int K, boolean[] chargedDays) {
    int before = -1;
    while (location >= 2) {
      if (location == before  || K == 0) {
        return false;
      } else if (chargedDays[location]) {
        before = location;
        location -= mid;
        K--;
      } else {
        location++;
      }
    }
    return true;
  }

}
