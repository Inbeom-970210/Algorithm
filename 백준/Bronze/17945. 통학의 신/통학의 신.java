import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   // -1,000 <= A <= 1,000
        int B = Integer.parseInt(st.nextToken());   // -1,000 <= B <= 1,000

        // 근의 공식 사용
        int res_1 = (int) ((-2 * A) - Math.sqrt(Math.pow(2 * A, 2) - (4 * B))) / 2;
        int res_2 = (int) ((-2 * A) + Math.sqrt(Math.pow(2 * A, 2) - (4 * B))) / 2;

        System.out.print(res_1);
        if(res_1 != res_2) System.out.print(" " + res_2);
    }
}