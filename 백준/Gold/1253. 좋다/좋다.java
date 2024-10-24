import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        // 풀이: 투포인트
        // 1. A를 오름차순으로 정렬
        // 2 - 1. left(0), right(N - 1)를 더했을 때 조건을 만족하면 카운트
        // 2 - 2. 크면 left 올림, 작으면 right -1
        // 중요! 기준값 기준 다른 두 수의 합이므로 left나 right가 기준값이 아니어야 한다.
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) left++;
                else if (right == i) right--;

                if (left == right) break;

                if (A[left] + A[right] == A[i]) {
                    answer++;
                    break;
                } else if (A[left] + A[right] < A[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.print(answer);
    }
}