import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  static int N;
  static int[] nums;
  static HashSet<Integer> set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    nums = new int[]{1, 5, 10, 50};
    set = new HashSet<>();

    dfs(0, 0, 0);

    System.out.print(set.size());
  }

  private static void dfs(int depth, int sum, int at) {
    if (depth == N) {
      set.add(sum);
      return;
    }

    for (int i = at; i < 4; i++) {
      dfs(depth + 1, sum + nums[i], i);
    }
  }
}
