import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 풀이: 그리디(진출 지점에 카메라 설치)
        // 1. 진출 지점을 기준으로 이동 경로 정렬
        // 2. 경로 탐색
        // 2-1. 단속 카메라에 잡히면 다음
        // 2-2. 단속 카메라에 안잡히면 카메라 설치 및 카운트
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int last = -30001;
        for(int[] route : routes) {
            if(route[0] <= last) continue;
            last = route[1];
            answer++;
        }
        
        return answer;
    }
}