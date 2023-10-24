import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] moveY = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};

        loop: for(int t = 0; t < testCase; t++) {
            Queue<int[]> q = new LinkedList<>();
            int l = sc.nextInt();
            int[][] map = new int[l][l];
            boolean[][] visited = new boolean[l][l];
            int[] start = new int[2];
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            int[] end = new int[2];
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();

            q.offer(new int[] {start[0], start[1], 0});
            visited[start[0]][start[1]] = true;

            while(!q.isEmpty()) {
                int[] curr = q.poll();

                if(curr[0] == end[0] && curr[1] == end[1]) {
                    System.out.println(curr[2]);
                    continue loop;
                }
                
                for(int i = 0; i < 8; i++) {
                    int nextY = curr[0] + moveY[i];
                    int nextX = curr[1] + moveX[i];

                    if(nextY < 0 || nextY >= l) continue;
                    if(nextX < 0 || nextX >= l) continue;
                    if(visited[nextY][nextX]) continue;

                    visited[nextY][nextX] = true;
                    if(nextY == end[0] && nextX == end[1]) {
                        System.out.println(curr[2] + 1);
                        continue loop;
                    }
                    else {
                        q.offer(new int[] {nextY, nextX, curr[2] + 1});
                    }
                }
            
            }
        }
    }
}