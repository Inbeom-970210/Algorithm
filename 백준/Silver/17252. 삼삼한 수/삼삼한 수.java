import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.print("NO");
            return;
        }

        while(N != 1) {
            if(N % 3 > 1) {
                System.out.print("NO");
                return;
            }
            N /= 3;
        }

        System.out.print("YES");
    }
}