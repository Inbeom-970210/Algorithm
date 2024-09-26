import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        // 행, 열, 대각선 총 8가지 뒤집기 좌표 초기화
        List<int[][]> flipPositions = flipPositions();
        while (T-- > 0) {
            String[][] board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                board[i] = br.readLine().split(" ");
            }

            sb.append(Bfs(board, flipPositions)).append("\n");
        }

        System.out.print(sb);
    }

    // BFS 탐색
    // 1. (0,0) ~ (2,2)를 이진법으로 변환: H(1), D(0)
    // 1-ex.
    // H T T
    // H T T
    // T H H    => 100100011
    // 2. 512개의 경우의 수를 근거로 방문 체크(visited)
    // 3. 현재의 코인 모습(board)과 연산 횟수(cnt)를 검증(validate): 조건 충족하면 cnt 리턴
    // 4. 조건 충족하지 않으면 뒤집기를 적용한 board, cnt 고려
    // 5. bfs가 끝나도 조건을 충족하지 못하면 -1 리턴
    private static int Bfs(String[][] board, List<int[][]> flipPositions) {
        boolean[] visited = new boolean[512];
        visited[getIndex(board)] = true;
        Queue<GameStatus> q = new LinkedList<>();
        q.offer(new GameStatus(0, board));

        while (!q.isEmpty()) {
            GameStatus curStatus = q.poll();
            if (validate(curStatus.board)) return curStatus.cnt;

            for (int[][] flipPosition : flipPositions) {
                String[][] nextBoard = flip(curStatus, flipPosition);
                int nextIndex = getIndex(nextBoard);
                if (!visited[nextIndex]) {
                    visited[nextIndex] = true;
                    q.offer(new GameStatus(curStatus.cnt + 1, nextBoard));
                }
            }
        }

        return -1;
    }

    // 방문 처리를 위한 board index 계산
    private static int getIndex(String[][] board) {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if ("H".equals(board[r][c])) str.append(1);
                else str.append(0);
            }
        }

        return Integer.parseInt(String.valueOf(str), 2);
    }

    // 조건 충족 검증
    private static boolean validate(String[][] board) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!board[0][0].equals(board[r][c])) return false;
            }
        }

        return true;
    }

    // 코인 뒤집기
    private static String[][] flip(GameStatus curStatus, int[][] flipPosition) {
        String[][] board = curStatus.board;
        String[][] res = new String[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                res[r][c] = board[r][c];
            }
        }

        for (int[] position : flipPosition) {
            if ("H".equals(res[position[0]][position[1]])) res[position[0]][position[1]] = "T";
            else res[position[0]][position[1]] = "H";
        }

        return res;
    }

    // 8가지 뒤집기 초기화
    private static List<int[][]> flipPositions() {
        ArrayList<int[][]> res = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            int[][] temp = new int[3][2];
            temp[0] = new int[]{r, 0};
            temp[1] = new int[]{r, 1};
            temp[2] = new int[]{r, 2};
            res.add(temp);
        }

        for (int c = 0; c < 3; c++) {
            int[][] temp = new int[3][2];
            temp[0] = new int[]{0, c};
            temp[1] = new int[]{1, c};
            temp[2] = new int[]{2, c};
            res.add(temp);
        }

        int[][] temp = new int[3][2];
        temp[0] = new int[]{0, 0};
        temp[1] = new int[]{1, 1};
        temp[2] = new int[]{2, 2};
        res.add(temp);

        int[][] temp2 = new int[3][2];
        temp2[0] = new int[]{0, 2};
        temp2[1] = new int[]{1, 1};
        temp2[2] = new int[]{2, 0};
        res.add(temp2);

        return res;
    }
}

class GameStatus {
    int cnt;
    String[][] board;

    public GameStatus(int cnt, String[][] board) {
        this.cnt = cnt;
        this.board = board;
    }
}