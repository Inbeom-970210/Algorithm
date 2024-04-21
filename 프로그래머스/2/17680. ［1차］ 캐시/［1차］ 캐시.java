import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        
        // 캐시가 없다면 모든 시티 cache miss로 처리
        if(cacheSize == 0) return cities.length * 5;
        
        // 시티 처리
        // 포함: 시티 삭제 -> 마지막에 시티 추가 -> 실행시간 5추가
        // 미포함: (캐시가 가득 찼으면 앞 시티 삭제) -> 마지막에 시티 추가 -> 실행시간 1추가 
        for(int i = 0; i < cities.length; ++i) {
            String city = cities[i].toUpperCase();
            
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                ++answer;
            } else {
                if(cache.size() == cacheSize) cache.remove(0);
                cache.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}