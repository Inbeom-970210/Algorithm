import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n은 색종이의 수; map은 도화지
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[100][100];

        // 도화지에 색종이 붙이기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int c = x; c < x + 10; c++) {
                for(int r = y; r < y + 10; r++) {
                    map[r][c] = true;
                }
            }
        }

        // 검은 영역의 넓이 계산
        int res = 0;
        for (int c = 0; c < 100; c++) {
            for(int r = 0; r < 100; r++) {
                if(map[r][c]) res++;
            }
        }

        System.out.print(res);

    }
}