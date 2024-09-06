import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 풀이: 회의 종료 시간을 오름차순하고, 회의 시작 시간과 회의실이 비는 시간을 비교하여 회의의 최대 개수를 구함
        // 1. 회의 끝나는 시간을 기준으로 오름차순 정렬
        // 2. 모든 회의를 탐색
        // 2-1. 회의의 시작시간이 회의실이 비는 시간(end) 이상이면, 해당 회의 선택(종료 시간 기준 가장 짧아 효율적)
        // 2-2. 회의실이 비지 않으면, 해당 회의 미선택
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end) return o1.start - o2.start;
            return o1.end - o2.end;
        });

        int answer = 0;
        int end = 0;
        for (Meeting m : meetings) {
            if (m.start >= end) {
                answer++;
                end = m.end;
            }
        }

        System.out.print(answer);
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}