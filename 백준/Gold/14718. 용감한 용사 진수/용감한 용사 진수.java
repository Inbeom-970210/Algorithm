import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 병사 수, K는 이겨할 수; 1 <= K <= N <= 100
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // arr는 병사의 능력치; 0 <= 힘(0), 민첩(1), 지능(2) <= 1,000,000
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        // 병사의 수치를 완전탐색하여 진수의 능력치를 만듬
        // 해당 스탯이 조건을 충족하면 res와 비교
        int res = 3000000;
        for(int stat1 = 0; stat1 < N; stat1++) {
            for(int stat2 = 0; stat2 < N; stat2++) {
                for(int stat3 = 0; stat3 < N; stat3++) {
                    int cnt = 0;
                    int[] jinsu = {arr[stat1][0], arr[stat2][1], arr[stat3][2]};

                    for(int i = 0; i < N; i++) {
                        if(jinsu[0] < arr[i][0]) continue;
                        if(jinsu[1] < arr[i][1]) continue;
                        if(jinsu[2] < arr[i][2]) continue;

                        cnt++;
                    }

                    if(cnt >= K) res = Math.min(res, jinsu[0] + jinsu[1] + jinsu[2]);
                }
            }
        }

        System.out.print(res);

    }
}