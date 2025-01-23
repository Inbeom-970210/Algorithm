import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String info = br.readLine();
            int len = info.length();
            sb.append(validate(0, len - 1, info) ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean validate(int start, int end, String info) {
        if (start == end) return true;

        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            if (info.charAt(i) == info.charAt(end - i)) return false;
        }
        return validate(start, mid - 1, info) && validate(mid + 1, end, info);
    }

}