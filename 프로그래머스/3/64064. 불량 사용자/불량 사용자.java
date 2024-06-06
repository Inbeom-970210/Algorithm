import java.util.*;

class Solution {
    private boolean[] checked;
    private Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        checked = new boolean[user_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        
        function(0, "", user_id, banned_id);
        
        return set.size();
    }
    
    public void function(int depth, String res, String[] user_id, String[] banned_id) {
        if(depth == banned_id.length) {
            String[] arr = res.split(" ");
            Arrays.sort(arr);
            
            String str = "";
            for(String val : arr) {
                str += val;
            }
            
            set.add(str);
            return;
        }   
        
        for(int i = 0; i < user_id.length; i++) {
            if(checked[i] || !user_id[i].matches(banned_id[depth])) continue;
            
            checked[i] = true;
            function(depth + 1, res + " " + user_id[i], user_id, banned_id);
            checked[i] = false;
        }
    }
    
}