import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int RED = 1;
  static int GREEN = 2;
  static boolean isSuccess;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      isSuccess = true;
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] colors = new int[n + 1];
      ArrayList<ArrayList<Integer>> links = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        links.add(new ArrayList<>());
      }
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int circle1 = Integer.parseInt(st.nextToken());
        int circle2 = Integer.parseInt(st.nextToken());
        links.get(circle1).add(circle2);
        links.get(circle2).add(circle1);
      }

      for (int i = 1; i <= n; i++) {
        if (0 == colors[i]) {
          Dfs(i, RED, colors, links);
        }
      }

      sb.append(isSuccess ? "possible" : "impossible").append("\n");
    }

    System.out.print(sb);
  }

  private static void Dfs(int location, int currentColor, int[] colors,
      ArrayList<ArrayList<Integer>> links) {
    if (!isSuccess) {
      return;
    } else if (0 == colors[location]) {
      colors[location] = currentColor;
      for (int next : links.get(location)) {
        Dfs(next, currentColor == RED ? GREEN : RED, colors, links);
      }
    } else if (currentColor != colors[location]) {
      isSuccess = false;
    }
  }
}
