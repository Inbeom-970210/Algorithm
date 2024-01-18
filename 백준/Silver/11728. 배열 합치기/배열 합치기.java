import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N은 배열 A의 크기; 1 <= N <= 1,000,000
        // M은 배열 B의 크기; 1 <= M <= 1,000,000
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        // A, B 완성 후 오름차순 정렬
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; ++i) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        // A와 B의 값을 비교하여 작은 값을 결과 배열에 입력
        // 이후 남은 배열의 값을 결과 배열에 입력
        // 이를 통해 두 배열을 합치고 오름차순 정렬
        int[] res = new int[N + M];
        int idx = 0;
        int A_idx = 0;
        int B_idx = 0;

        while (A_idx < N && B_idx < M) {
            if(A[A_idx] > B[B_idx]) res[idx++] = B[B_idx++];
            else res[idx++] = A[A_idx++];
        }

        if(A_idx == N) {
            while (B_idx < M) {
                res[idx++] = B[B_idx++];
            }
        }
        else {
            while (A_idx < N) {
                res[idx++] = A[A_idx++];
            }
        }

        for(int i = 0; i < N + M; ++i) {
            sb.append(res[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
        
    }
}