import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[101][101];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> directions = getDirections(d, g);
            drawPoint(r, c, directions, map);
        }

        int answer = calculnumberOfSquares(map);
        System.out.print(answer);
    }

    // 방향 구하기: 끝 점을 기준으로 이전 방향의 반시계 방향을 directions에 추가
    private static List<Integer> getDirections(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while (g-- > 0) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                int nextDirection = (directions.get(i) + 1) % 4;
                directions.add(nextDirection);
            }
        }

        return directions;
    }

    // 점 찍기: 시작 위치와 directions을 고려하여 드래콘 커브에 맞게 점을 찍음
    private static void drawPoint(int r, int c, List<Integer> directions, boolean[][] map) {
        for (int direction : directions) {
            switch (direction) {
                case 0:
                    map[r][c++] = true;
                    break;
                case 1:
                    map[r--][c] = true;
                    break;
                case 2:
                    map[r][c--] = true;
                    break;
                case 3:
                    map[r++][c] = true;
                    break;
            }
        }
        map[r][c] = true;
    }

    // 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형 개수 구하기: 완전탐색으로 구함
    private static int calculnumberOfSquares(boolean[][] map) {
        int numberOfSquares = 0;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (map[r][c] && map[r + 1][c] && map[r][c + 1] && map[r + 1][c + 1]) numberOfSquares++;
            }
        }
        return numberOfSquares;
    }
}