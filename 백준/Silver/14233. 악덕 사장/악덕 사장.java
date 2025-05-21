import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int[] deadLines = new int[N];

    for (int i = 0; i < N; i++) {
      deadLines[i] = Integer.parseInt(input[i]);
    }
    Arrays.sort(deadLines);

    int answer = Integer.MIN_VALUE;
    int min = 1;
    int max = 1000000000;
    while (min <= max) {
      int mid = (min + max) / 2;
      if (isFinishWork(mid, deadLines)) {
        answer = mid;
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.print(answer);
  }

  private static boolean isFinishWork(int mid, int[] deadLines) {
    int total = 0;
    for (int deadLine : deadLines) {
      total += mid;
      if (deadLine < total) {
        return false;
      }
    }

    return true;
  }

}
