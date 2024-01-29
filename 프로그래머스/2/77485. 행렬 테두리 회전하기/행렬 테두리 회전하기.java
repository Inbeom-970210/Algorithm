import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> res = new ArrayList<>();
        int[][] arr = new int[rows][columns];
        int idx = 0;
        
        for(int r = 0; r < rows; ++r) {
            for(int c = 0; c < columns; ++c) {
                arr[r][c] = ++idx;
            }
        }
        
        for(int q = 0; q < queries.length; ++q) {
            int end = arr[queries[q][0] - 1][queries[q][1] - 1];
            int min = end;
            
            for(int r = queries[q][0] + 1;  r <= queries[q][2]; ++r) {
                arr[r - 2][queries[q][1] - 1] = arr[r - 1][queries[q][1] - 1];
                min = Math.min(min, arr[r - 1][queries[q][1] - 1]);
            }
            
            for(int c = queries[q][1] + 1; c <= queries[q][3]; ++c) {
                arr[queries[q][2] - 1][c - 2] = arr[queries[q][2] - 1][c - 1];
                min = Math.min(min, arr[queries[q][2] - 1][c - 1]);
            }
            
            for(int r = queries[q][2] - 1;  r >= queries[q][0]; --r) {
                arr[r][queries[q][3] - 1] = arr[r - 1][queries[q][3] - 1];
                min = Math.min(min, arr[r - 1][queries[q][3] - 1]);
            }
            
            for(int c = queries[q][3] - 1; c >= queries[q][1]; --c) {
                arr[queries[q][0] - 1][c] = arr[queries[q][0] - 1][c - 1];
                min = Math.min(min, arr[queries[q][0] - 1][c - 1]);
            }
            
            if(queries[q][3] >= queries[q][1] + 1) arr[queries[q][0] - 1][queries[q][1]] = end;
            res.add(min);
        }
        
        
        int[] answer = new int[res.size()];
        idx = 0;
        for(int v : res) {
            answer[idx++] = v;
        }
        return answer;
    }
}