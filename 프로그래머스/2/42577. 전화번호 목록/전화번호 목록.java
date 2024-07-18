import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Boolean> map = new HashMap<>();
        for(String val : phone_book) {
            map.put(val, false);
        }
        
        loof: for(String val : phone_book) {
            for(int i = 0; i < val.length(); i++) {
                if(map.containsKey(val.substring(0, i))) {
                    answer = false;
                    break loof;
                }
            }    
        }
        
        return answer;
    }
}