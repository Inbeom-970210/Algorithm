import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static final int MAX = 1000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[] arr = br.readLine().toCharArray();
    int[] minEnergys = new int[N];
    Arrays.fill(minEnergys, -1);
    minEnergys[0] = 0;

    int energy = getMinEnergy(N - 1, arr, minEnergys);

    System.out.print(energy == MAX ? -1 : energy);
  }

  private static int getMinEnergy(int index, char[] arr, int[] minEnergys) {
    if (minEnergys[index] == -1) {
      char next = 0;
      switch (arr[index]) {
        case 'B':
          next = 'J';
          break;
        case 'O':
          next = 'B';
          break;
        case 'J':
          next = 'O';
      }

      int neededEnergy = MAX;
      for (int i = 0; i < index; i++) {
        if(arr[i] == next)
          neededEnergy = (int) Math.min(neededEnergy, getMinEnergy(i, arr, minEnergys) + Math.pow(index - i, 2));
      }
      minEnergys[index] = Math.min(neededEnergy, MAX);
    }

    return minEnergys[index];
  }

}
