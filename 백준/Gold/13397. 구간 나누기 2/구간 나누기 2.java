import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, left, right;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        int answer = calculAnswer();

        System.out.print(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        left = 0;
        right = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
    }

    // 이분탐색으로 정답을 구함
    // calculSection(mid)은 구간의 점수 최댓값을 mid로 했을 때 구간의 최소 개수를 구함
    // 이를 M과 비교하여 <=면 조건을 만족, 아니면 조건을 만족하지 못한다.
    // 반복문을 통과했을 때 left, right는 조건을 만족하는 최솟값이다.
    private static int calculAnswer() {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (calculSection(mid) <= M) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    private static int calculSection(int mid) {
        int section = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            int sectionScore = max - min;

            if (sectionScore > mid) {
                section++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }

        return section;
    }
}