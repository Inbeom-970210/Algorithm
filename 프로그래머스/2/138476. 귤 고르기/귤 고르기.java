import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 풀이: Map과 내림차순 정렬
        // 1. Map에 귤 번호: 귤 갯수 저장
        // 2. 귤 갯수를 List에 저장하고 내림차순
        // 3. k에서 귤 갯수를 빼며 답을 구함
        Map<Integer, Integer> map = new HashMap<>();
        for(int item : tangerine) {
            if(map.get(item) == null) map.put(item, 1);
            else map.put(item, map.get(item) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int val : map.values()) {
            System.out.print(val + " ");
            list.add(val);
        }
        list.sort(Collections.reverseOrder());
        
        int answer = 0;
        int idx = -1;
        while(k > 0) {
            answer++;
            k -= list.get(++idx);
        }
        
        return answer;
    }
}           