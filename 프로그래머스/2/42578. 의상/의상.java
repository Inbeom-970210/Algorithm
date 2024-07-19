import java.util.*;

class Solution {
    private int answer;
    private Map<String, Integer> map;
    
    public int solution(String[][] clothes) {
        answer = 0;
        
        map = new HashMap<>();
        for(String[] cloth : clothes) {
            String type = cloth[1];
            int val = map.getOrDefault(type, 0) + 1;
            map.put(type, val);
        }

        int len = map.size();
        int idx = -1;
        String[] keys = new String[len];
        for(String key : map.keySet()) {
            keys[++idx] = key;
        }
        
        // 풀이: 조합
        // 선택한 조합에서 각 의상 종류의 개수를 곱해서 코디의 종류를 구함
        dfs(0, 0, keys);
        
        return answer;
    }
    
    public void dfs(int depth, int total, String[] keys) {
        if(depth == map.size()) {
            answer += total;
            return;
        }
        
        String key = keys[depth];
        int cnt = total;
        if(cnt == 0) cnt = 1;
        cnt *= map.get(key);
        
        dfs(depth + 1, cnt, keys);
        dfs(depth + 1, total, keys);
        
    }
    
}