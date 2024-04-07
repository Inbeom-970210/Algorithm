import java.util.*;

class Solution {
    private boolean[][] pillars;
    private boolean[][] bos;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillars = new boolean[n + 1][n + 1];
        bos = new boolean[n + 1][n + 1];
        int cnt = 0;
        for(int i = 0; i < build_frame.length; ++i) {
            int row = n - build_frame[i][1];
            int col = build_frame[i][0];
            int type = build_frame[i][2];
            int action = build_frame[i][3];
            
            switch(action) {
                case 0: // 삭제
                    switch(type) {
                        case 0:
                            pillars[row][col] = false;
                            if(validateRemove(n)) --cnt;
                            else pillars[row][col] = true;
                            break;
                        case 1:
                            bos[row][col] = false;
                            if(validateRemove(n)) --cnt;
                            else bos[row][col] = true;
                            break;
                    }
                break;
                    
                case 1: // 설치
                    switch(type) {
                        case 0:
                            if(validatePillar(row, col, n)) {
                                pillars[row][col] = true;
                                ++cnt;
                            }
                            break;
                        case 1:
                            if(validateBo(row, col, n)) {
                                bos[row][col] = true;
                                ++cnt;
                            }
                            break;
                    }
                break;
            }
        }
        
        int[][] answer = new int[cnt][3];
        int idx = 0;
        for(int r = n; r >= 0; --r) {
            for(int c = 0; c <= n; ++c) {
                if(!pillars[r][c]) continue;
                answer[idx][0] = c;
                answer[idx][1] = n - r;
                answer[idx++][2] = 0;
            }
        }
        for(int r = n; r >= 0; --r) {
            for(int c = 0; c <= n; ++c) {
                if(!bos[r][c]) continue;
                answer[idx][0] = c;
                answer[idx][1] = n - r;
                answer[idx++][2] = 1;
            }
        }
        sort(answer);
        
        return answer;
    }
    
    public boolean validatePillar(int row, int col, int n) {
        if(row == n || (col > 0 && bos[row][col - 1]) || bos[row][col] || (row < n && pillars[row + 1][col])) return true;
        return false;
    }
    
    public boolean validateBo(int row, int col ,int n) {
        if((row < n && pillars[row + 1][col]) || (row < n && col < n && pillars[row + 1][col + 1]) || ((col < n && bos[row][col + 1]) && (col > 0 && bos[row][col - 1]))) return true;
        return false;
    }
    
    public boolean validateRemove(int n) {
        for(int r = n; r >= 0; --r) {
            for(int c = 0; c <= n; ++c) {
                if(pillars[r][c] && !validatePillar(r, c, n)) return false;
                if(bos[r][c] && !validateBo(r, c, n)) return false;
            }
        }
        
        return true;
    }
    
    
    public void sort(int[][] answer) {
        Arrays.sort(answer, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) return -1;
                else if(o1[0] > o2[0]) return 1;
                else {
                    if(o1[1] < o2[1]) return -1;
                    else if(o1[1] > o2[1]) return 1;
                    else {
                        if(o1[2] == 0) return -1;
                        else return 1;
                    }
                }
            }
        });
    }
}