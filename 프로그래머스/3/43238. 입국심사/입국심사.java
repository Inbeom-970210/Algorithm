class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 최악의 경우를 알기 위해 가장 오래걸리는 심사시간을 구함
        int max = 0;
        for(int time : times) {
            max = Math.max(max, time);
        }
        
        // 이분탐색을 사용해서 입국심사 최솟값을 구함
        long left = 1;
        long right = max * (long) n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            // cnt는 mid 시간으로 입국심사 할 수 있는 인원
            long cnt = 0;
            for(int time : times) {
                cnt += mid / time;
            }
            
            // 모두를 입국심사 할 수 없는 경우
            if(cnt < n) left = mid + 1;
            // 모두 그 이상을 입국심사 할 수 있는 경우
            else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}