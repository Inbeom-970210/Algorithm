import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            set.add(num);
            arr[i] = num;
        }

        int res = 0;
        for(int num : set) {
            int pre = -1;
            int len = 0;
            for(int i = 0; i < N; i++) {
                if(arr[i] == num) continue;
                if(arr[i] != pre) {
                    res = Math.max(res, len);
                    pre = arr[i];
                    len = 0;
                }
                len++;
            }
            res = Math.max(res, len);
        }

        System.out.print(res);
    }
}