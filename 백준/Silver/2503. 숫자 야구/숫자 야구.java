import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N은 질문 수; 1 <= N <= 100
        // questions는 질문; 질문 수(0), 스트라이크(1), 볼(2)
        int N = Integer.parseInt(br.readLine());
        int[][] questions = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
            questions[i][2] = Integer.parseInt(st.nextToken());
        }

        // 가능성이 있는 수 카운트
        int res = 0;
        for(int num = 123; num <= 987; num++) {
            int[] numArr = {num % 10, (num / 10) % 10, num / 100};

            if(numArr[0] == 0 || numArr[1] == 0 || numArr[2] == 0) continue;
            if(numArr[0] == numArr[1]) continue;
            if(numArr[0] == numArr[2]) continue;
            if(numArr[1] == numArr[2]) continue;

            boolean flag = true;
            for(int i = 0; i < N; i++) {
                int str = 0;
                int ball = 0;
                int[] testArr = {questions[i][0] % 10, (questions[i][0] / 10) % 10, questions[i][0] / 100};

                for(int numIdx = 0; numIdx < 3; numIdx++) {
                    for(int testIdx = 0; testIdx < 3; testIdx++) {
                        if(numIdx == testIdx && numArr[numIdx] == testArr[testIdx]) str++;
                        if(numIdx != testIdx && numArr[numIdx] == testArr[testIdx]) ball++;
                    }
                }

                if(questions[i][1] != str || questions[i][2] != ball) flag = false;
            }

            if(flag) res++;
        }

        System.out.print(res);

    }
}