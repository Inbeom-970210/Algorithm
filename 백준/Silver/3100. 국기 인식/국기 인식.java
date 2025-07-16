import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

  static HashMap<Character, Integer> map = new HashMap<>();
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[][] arr = new char[6][9];
    for (int r = 0; r < 6; r++) {
      arr[r] = br.readLine().toCharArray();
    }

    getMid(arr, 'R');
    getChangedNum(arr, 'R');

    getMid(arr, 'C');
    getChangedNum(arr, 'C');

    System.out.print(answer == Integer.MAX_VALUE ? 18 : answer);
  }

  private static void getChangedNum(char[][] arr, char flag) {
    HashMap<Character, Integer> sideMap1 = new HashMap<>();
    HashMap<Character, Integer> sideMap2 = new HashMap<>();

    if ('R' == flag) {
      for (int r = 0; r < 2; r++) {
        for (int c = 0; c < 9; c++) {
          sideMap1.put(arr[r][c], sideMap1.getOrDefault(arr[r][c], 0) + 1);
        }
      }
      for (int r = 4; r < 6; r++) {
        for (int c = 0; c < 9; c++) {
          sideMap2.put(arr[r][c], sideMap2.getOrDefault(arr[r][c], 0) + 1);
        }
      }
    } else {
      for (int r = 0; r < 6; r++) {
        for (int c = 0; c < 3; c++) {
          sideMap1.put(arr[r][c], sideMap1.getOrDefault(arr[r][c], 0) + 1);
        }
      }
      for (int r = 0; r < 6; r++) {
        for (int c = 6; c < 9; c++) {
          sideMap2.put(arr[r][c], sideMap2.getOrDefault(arr[r][c], 0) + 1);
        }
      }
    }

    for (Character key : map.keySet()) {
      for (Character sideKey1 : sideMap1.keySet()) {
        if (sideKey1 == key) {
          continue;
        }
        for (Character sideKey2 : sideMap2.keySet()) {
          if (sideKey2 == key) {
            continue;
          }
          int sum = map.get(key) + sideMap1.get(sideKey1) + sideMap2.get(sideKey2);
          answer = Math.min(answer, 54 - sum);
        }
      }
    }
  }

  private static void getMid(char[][] arr, char flag) {
    map.clear();
    if ('R' == flag) {
      for (int r = 2; r < 4; r++) {
        for (int c = 0; c < 9; c++) {
          map.put(arr[r][c], map.getOrDefault(arr[r][c], 0) + 1);
        }
      }
    } else {
      for (int r = 0; r < 6; r++) {
        for (int c = 3; c < 6; c++) {
          map.put(arr[r][c], map.getOrDefault(arr[r][c], 0) + 1);
        }
      }
    }
  }

}
