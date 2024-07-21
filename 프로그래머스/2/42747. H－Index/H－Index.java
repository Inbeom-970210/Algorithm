import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        
        for(int i = 0; i < len; i++) {
            if(citations[i] > len - i) {
                int h = len - i;
                answer = Math.max(answer, h);
                break;
            }
            
            answer = citations[i];
        }
        
        return answer;
    }
}