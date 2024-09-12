import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);
        int total = Integer.parseInt(br.readLine());

        int answer = getMaxBusdgets(total, budgets);
        System.out.print(answer);
    }

    // 이분탐색을 통해 예산들 중 최댓값을 구함
    private static int getMaxBusdgets(int total, int[] budgets) {
        int maxBudget = 0;
        int left = 0;
        int right = budgets[budgets.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int budget : budgets) {
                if (budget <= mid) sum += budget;
                else sum += mid;
            }

            if (sum <= total) {
                maxBudget = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxBudget;
    }
}