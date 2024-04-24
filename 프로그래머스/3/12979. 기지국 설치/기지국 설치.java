class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // 풀이: 기지국을 중심으로 영역을 나눔
        // 영역의 시작(start)과 끝(end), 기지국의 전파 범위(spread)를 설정
        // 영역은 연결된 공간이므로 전파 범위로 나누어 필요한 기지국 개수를 구함
        
        int start = 1;
        int spread = 2 * w + 1;
        for(int station : stations) {
            int end = station - w;
            int area = end - start;
            int needStation = area / spread;
            if(area % spread > 0) ++needStation;
            answer += needStation;
            start = station + w + 1;
        }
        
        if(start <= n) {
            int area = n - start;
            int needStation = area / spread + 1;
            answer += needStation;
        }
        
        return answer;
    }
}