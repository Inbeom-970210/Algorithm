import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int len = targets.length;
        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] <= o2[1]) return -1;
                else return 1;
            }
        });
        double last = 0;
        for(int[] target : targets) {
            if(target[0] >= last) {
                last = target[1] - 0.1;
                answer++;
            } 
        }
        
        return answer;
    }
}