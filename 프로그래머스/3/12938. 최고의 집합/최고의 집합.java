import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        // s가 불가능한 수면 [-1] 리턴
        if(s < n) return new int[]{-1};
        
        // cnt: num + 1의 필요 개수
        // num: 중복을 고려했을 때, 기준 숫자
        int[] answer = new int[n];
        int cnt = s % n;
        int num = s / n;
         
        
        // cnt, num을 기반으로 answer 완성
        for(int i = n - 1; i >= 0; i--) {
            if(i >= n - cnt) answer[i] = num + 1;
            else answer[i] = num;
        }
        
        return answer;
    }
}