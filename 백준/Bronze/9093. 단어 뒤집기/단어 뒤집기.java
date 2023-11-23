import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();

            for(int j = 0; j < cnt; j++) {
                char[] arr = st.nextToken().toCharArray();
                int len = arr.length;
                for(int k = len - 1; k >= 0; k--) {
                    sb.append(arr[k]);
                }

                if(j == cnt - 1) continue;
                sb.append(" ");
            }

            if(i == T - 1) break;
            sb.append("\n");
        }

        System.out.print(sb);
    }
}