import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자의 범위 A이상 B이하; 1 <= A <= B <= 4,000,000, B <= A + 2,000,000
        // 범위 안에서 D를 포함하는 숫자 찾기
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String D = st.nextToken();
        boolean[] nums = new boolean[B + 1];
        for(int i = 2; i < B + 1; ++i) {
            nums[i] = true;
        }

        int res = 0;

        for(int i = 2; i <= Math.sqrt(B); ++i) {
            if(!nums[i]) continue;

            for(int j = i * i; j <= B; j += i) {
                nums[j] = false;
            }
        }

        for(int i = A; i <= B; i++) {
            if(!nums[i]) continue;

            if(Integer.toString(i).contains(D)) ++res;
        }

        System.out.print(res);

    }
}