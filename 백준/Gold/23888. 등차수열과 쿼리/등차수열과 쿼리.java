import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a;
    static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // a는 초항, b는 등차, q는 쿼리 수; 1 <= a <= 10^6, 0 <= b <= 10^6, 1 <= q <= 10^6
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(br.readLine());

        // type에 따른 쿼리 실행: 수열의 합(1), 수열의 GCD(2)
        // l은 수열의 시작, r은 수열의 마지막, 1 <= l <= r <= 10^6
        for(int query = 0; query < q; query++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long res = 0;

            switch (type) {
                case "1":
                    res = (r - l + 1) * a + (r - l + 1) * (l  + r - 2) * d / 2;
                    break;
                case "2":
                    if(l == r) {
                        res = a + (l - 1) * d;
                        break;
                    }
                    res = GCD(a + (l - 1) * d, a + l * d);
                    for(int i = l + 2; i <= r; i++) {
                        res = GCD(res, a + (i - 1) * d);
                    }
                    break;
            }

            sb.append(res).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }

    // 등차수열에서 GCD를 구하는 메서드
    private static long GCD(long num1, long num2) {
        if(num2 % num1 == 0) return num1;
        return GCD(num2 % num1, num1);
    }
}