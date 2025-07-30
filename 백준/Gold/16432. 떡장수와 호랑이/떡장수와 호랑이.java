import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static String output = "";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][];
    boolean[][] visited = new boolean[N][];
    int[] answer = new int[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int size = Integer.parseInt(st.nextToken());
      arr[i] = new int[size];
      visited[i] = new boolean[size];
      for (int j = 0; j < size; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, arr, visited, answer);

    System.out.print(output.length() > 0 ? output : -1);
  }

  private static void dfs(int depth, int before, int[][] arr, boolean[][] visited, int[] answer) {
    if (depth == arr.length) {
      StringBuilder sb = new StringBuilder();
      for (int num : answer) {
        sb.append(num).append("\n");
      }
      output = sb.toString();
      return;
    }

    for (int i = 0; i < arr[depth].length; i++) {
      if (arr[depth][i] != before && !visited[depth][i]) {
        visited[depth][i] = true;
        answer[depth] = arr[depth][i];
        dfs(depth + 1, arr[depth][i], arr, visited, answer);
      }
    }
  }

}
