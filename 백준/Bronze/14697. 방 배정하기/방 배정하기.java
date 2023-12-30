import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A, B, C는 방의 정원; 1 <= A < B < C <= 50
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // N은 전체 학생 수; 1 <= N <= 300
        int N = Integer.parseInt(st.nextToken());
        int maxA = N / A;
        int maxB = N / B;
        int maxC = N / C;
        boolean flag = false;

        loof: for(int ANum = 0; ANum <= maxA; ANum++) {
            for(int BNum = 0; BNum <= maxB; BNum++) {
                for(int CNum = 0; CNum <= maxC; CNum++) {
                    if(A * ANum + B * BNum + C * CNum != N) continue;

                    flag = true;
                    break loof;
                }
            }
        }

        if(flag) System.out.print(1);
        else System.out.print(0);

    }
}