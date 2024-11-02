import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");

        calcul(-1, 0, arr);

        System.out.print(answer);
    }

    private static void calcul(int i, int sum, String[] arr) {
        if (i == N) {
            answer = Math.max(answer, sum);
            return;
        }

        if (i == -1) {
            if (i + 4 <= N)
                calcul(i + 4, oper(Integer.parseInt(arr[i + 1]), Integer.parseInt(arr[i + 3]), arr[i + 2]), arr);
            calcul(i + 2, Integer.parseInt(arr[0]), arr);
        } else {
            if (i + 4 <= N)
                calcul(i + 4, oper(sum, oper(Integer.parseInt(arr[i + 1]), Integer.parseInt(arr[i + 3]), arr[i + 2]), arr[i]), arr);
            calcul(i + 2, oper(sum, Integer.parseInt(arr[i + 1]), arr[i]), arr);
        }
    }

    private static int oper(int num1, int num2, String ope) {
        int temp = num1;
        switch (ope) {
            case "+":
                temp += num2;
                break;
            case "-":
                temp -= num2;
                break;
            case "*":
                temp *= num2;
        }

        return temp;
    }


}