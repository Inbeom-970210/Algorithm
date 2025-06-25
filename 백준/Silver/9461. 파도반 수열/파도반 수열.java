import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    long[] DP = new long[101];
    DP[1] = 1;
    DP[2] = 1;
    DP[3] = 1;
    DP[4] = 2;
    DP[5] = 2;

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      sb.append(getMax(N, DP)).append("\n");
    }

    System.out.print(sb);
  }

  private static long getMax(int N, long[] DP) {
    if (DP[N] < 1) {
      DP[N] = getMax(N - 1, DP) + getMax(N - 5, DP);
    }

    return DP[N];
  }
}
