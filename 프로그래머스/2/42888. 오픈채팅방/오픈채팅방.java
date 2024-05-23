import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        int cnt = 0;
        Map<String, String> map = new HashMap<>();
        for(String log : record) {
            String[] detail = log.split(" ");
            String method = detail[0];
            if(method.equals("Leave")) continue;
            if(method.equals("Change")) cnt++;
            String id = detail[1];
            String nickname = detail[2];
            
            map.put(id, nickname);
        }
        
        int len = record.length;
        int idx = 0;
        String[] answer = new String[len - cnt];
        for(int i = 0; i < len; i++) {
            String[] detail = record[i].split(" ");
            String method = detail[0];
            if(method.equals("Change")) continue;
            if(method.equals("Enter")) method = "들어왔습니다.";
            else method = "나갔습니다.";
            
            String id = detail[1];
            String nickname = map.get(id);
            
            answer[idx++] = nickname + "님이 " + method;
        }        
        
        return answer;
    }
}