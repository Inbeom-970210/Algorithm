import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N은 기둥의 개수; 1 <= N <= 1,000
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int leftL = 1000;
        int rightL = 0;
        int maxL = 0;
        for(int i = 0; i < N; i++) {
            // L은 기둥 왼쪽 면의 위치, H는 기둥 높이; 1 <= L, H <= 1,000
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;

            if(H > 0) {
                leftL = Math.min(leftL, L);
                rightL = Math.max(rightL, L);
            }
            if(arr[maxL] < H) maxL = L;
        }

        // 왼쪽(→), 가장 높은 기둥, 오른쪽(←)으로 나눠서 면접을 계산
        // 왼쪽: 현재까지 가장 높은 기둥의 높이를 더하고, 다음 기둥을 확인해 가장 높은 기둥을 갱신
        // 오른쪽: 현재까지 가장 높은 기둥의 높이를 더하고, 다음 기둥을 확인해 가장 높은 기둥을 갱신
        int res = arr[maxL];
        for(int left = leftL; left < maxL; left++) {
            res += arr[leftL];
            if(arr[leftL] < arr[left + 1]) leftL = left + 1;
        }

        for(int right = rightL; right > maxL; right--) {
            res += arr[rightL];
            if(arr[rightL] < arr[right - 1]) rightL = right - 1;
        }

        System.out.print(res);
    }
}