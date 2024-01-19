import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // G는 현재 몸무게^2 - 과거 몸무게^2; 1 <= G <= 100,000
        int G = Integer.parseInt(br.readLine());
        ArrayList<Integer> curs = new ArrayList<>();

        int pre = 1;
        int cur = 2;
        while (pre < cur && cur < G) {
            if(Math.pow(cur, 2) - Math.pow(pre, 2) == G) {
                curs.add(cur);
                ++cur;
                ++pre;
            }
            else if (Math.pow(cur, 2) - Math.pow(pre, 2) > G) ++pre;
            else ++cur;
        }

        if (curs.isEmpty()) {
            System.out.print(-1);
            return;
        }

        curs.sort(Comparator.naturalOrder());
        for(int c : curs) {
            sb.append(c).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }
}
