import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // 정수의 개수
        int[] dp = new int[n];         // dp
        int[] arr = new int[n];        // 주어진 정수가 입력된 배열
        
        for(int i = 0; i < n; i++) {    // 정수 입력, 가장 큰 수 구하기
            arr[i] = sc.nextInt();
        }
        
        int res = arr[0];              // 가장 큰 합
        dp[0] = arr[0];
        
        for(int idx = 1; idx < n; idx++) {
            dp[idx] = Math.max(dp[idx - 1] + arr[idx], arr[idx]);
            res = Math.max(res, dp[idx]);
        }
        
        System.out.print(res);
    }
}