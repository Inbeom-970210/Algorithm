import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int test = 0; test < t; test++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] candy = new char[r][c];
            int res = 0;

            for(int i = 0; i < r; i++) {
                char[] line = br.readLine().toCharArray();
                for(int j = 0; j < c; j++) {
                    candy[i][j] = line[j];
                }
            }

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(j + 2 < c && candy[i][j] == 62 && candy[i][j + 1] == 111 && candy[i][j + 2] == 60) res++;
                    if(i + 2 < r && candy[i][j] == 118 && candy[i + 1][j] == 111 && candy[i + 2][j] == 94) res++;
                }
            }

            System.out.println(res);
        }
    }
}