import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // 풀이: set을 사용한 중복 제거
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        
        return Math.min(set.size(), nums.length / 2);
    }
}