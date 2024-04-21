import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= discount.length - 10; ++i) {
            boolean flag = true;
            
            // 10일 동안 할인품을 담음
            for(int j = 0; j < 10; ++j) {
                String curDiscount = discount[i + j];
                if(map.containsKey(curDiscount)) map.put(curDiscount, map.get(curDiscount) + 1);
                else map.put(curDiscount, 1);
            }
            
            // 각 할인품 수량이랑 내가 원하는 상품 수량을 비교 
            for(int j = 0; j < number.length; ++j) {
                if(!map.containsKey(want[j]) || number[j] != map.get(want[j])) {
                    flag = false;
                    break;
                }
            }
            
            // 비교했을 때, 동일하면 카운트
            if(flag) ++answer;
            map.clear();
        }
        
        
        return answer;
    }
}