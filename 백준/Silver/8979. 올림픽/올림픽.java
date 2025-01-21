import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] countries = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                countries[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(countries, (o1, o2) -> {
            if (o1[1] > o2[1]) return -1;
            else if (o1[1] < o2[1]) return 1;
            else {
                if (o1[2] > o2[2]) return -1;
                else if (o1[2] < o2[2]) return 1;
                else {
                    if (o1[3] < o2[3]) return 1;
                    else return -1;
                }
            }
        });

        int answer = 0;
        loop:
        for (int i = 0; i < N; i++) {
            if (K == countries[i][0]) {
                while (i > 0) {
                    answer = i + 1;
                    for (int j = 1; j < 4; j++) {
                        if (countries[i - 1][j] > countries[i][j]) break loop;
                    }
                    i--;
                }

                answer = 1;
                break;
            }
        }

        System.out.print(answer);
    }
}