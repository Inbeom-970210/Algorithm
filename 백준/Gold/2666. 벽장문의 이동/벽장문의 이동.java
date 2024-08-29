import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, testNum, answer;
    static int[] open, test;

    public static void main(String[] args) throws IOException {
        init();

        calculMinMoveCnt(0, 0);

        System.out.print(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        open = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        open[0] = Integer.parseInt(st.nextToken());
        open[1] = Integer.parseInt(st.nextToken());
        testNum = Integer.parseInt(br.readLine());
        test = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            test[i] = Integer.parseInt(br.readLine());
        }
        answer = Integer.MAX_VALUE;
    }

    // 벽장을 이용하는 경우는 열린 벽장(2) 만큼있다.
    private static void calculMinMoveCnt(int depth, int cnt) {
        if (cnt >= answer) return;
        if (depth == testNum) {
            answer = cnt;
            return;
        }

        int curLocation = open[0];
        open[0] = test[depth];
        calculMinMoveCnt(depth + 1, cnt + Math.abs(test[depth] - curLocation));
        open[0] = curLocation;

        curLocation = open[1];
        open[1] = test[depth];
        calculMinMoveCnt(depth + 1, cnt + Math.abs(test[depth] - curLocation));
        open[1] = curLocation;
    }
}