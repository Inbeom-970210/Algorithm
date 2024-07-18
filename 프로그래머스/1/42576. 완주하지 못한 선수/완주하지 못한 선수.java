import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 풀이: map<이름, 개수>을 사용한 조회로 개수가 다르면 정답 
        // map에 key가 없을 때 반환되는 null 고려 -> .getOrDefault() 사용
        Map<String, Integer> map = new HashMap<>();
        for(String val : participant) {
            int curVal = map.getOrDefault(val, 0);
            map.put(val, curVal + 1);
        }
        for(String val : completion) {
            map.put(val, map.get(val) - 1);
        }
        
        for(String val : participant) {
            if(map.get(val) > 0) {
                answer = val;
                break;
            }
        }
        
        return answer;
    }
}