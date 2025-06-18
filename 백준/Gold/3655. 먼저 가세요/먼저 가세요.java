import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int total = 0;
      int n = Integer.parseInt(br.readLine());
      char[] groups = br.readLine().toCharArray();
      HashMap<Character, Integer> map = new HashMap<>();
      HashMap<Character, Integer> location = new HashMap<>();
      for (int j = 0; j < groups.length; j++) {
        map.put(groups[j], map.getOrDefault(groups[j], 0) + 1);
        location.put(groups[j], j);
      }

      StringBuilder after = new StringBuilder();
      for (int j = groups.length - 1; j >= 0; j--) {
        if (map.get(groups[j]) > 0) {
          for (int k = 0; k < map.get(groups[j]); k++) {
            after.append(groups[j]);
          }
          map.put(groups[j], 0);
        }
      }

      after = after.reverse();

      for (int j = n - 1; j >= 0; j--) {
        int dist = location.get(after.charAt(j)) - j;
        int cnt = 0;
        while (j > 0 && after.charAt(j) == after.charAt(j - 1)) {
          j--;
          cnt++;
        }
        cnt++;
        total += 5 * dist * cnt;
      }

      sb.append(total).append("\n");
    }

    System.out.print(sb);
  }

}
