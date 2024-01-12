import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 정수 개수; 1 <= N <= 200,000
        // K는 목표 부분합; |K| <= 2,000,000,000
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] arr = new long[N + 1];
        HashMap<Long, ArrayList<Integer>> map = new HashMap();

        // 누적합을 구하면서 누적합이 K와 같으면 카운트
        // 각 누적합에서 K까지 필요한 값을 map에서 찾아 카운트
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list;
        long res = 0;
        for (int i = 1; i <= N; ++i) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());

            if(arr[i] == K) ++res;
            if(map.get(arr[i] - K) != null) res += map.get(arr[i] - K).size();

            if (map.get(arr[i]) == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            } else {
                list = map.get(arr[i]);
                list.add(i);
                map.replace(arr[i], list);
            }
        }

        System.out.print(res);
    }
}