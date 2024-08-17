class Solution {
    public int solution(int[] stones, int k) {
        int len = stones.length;
        int left = 0;
        int right = 1;
        for(int stone : stones) {
            right = Math.max(right, stone);
        }
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int temp = 0;
            for(int i = 0; i < len; i++) {
                if(stones[i] - mid <= 0) temp++;
                else {
                    cnt = Math.max(cnt, temp);
                    temp = 0;   
                }
            }
            cnt = Math.max(cnt, temp);
            
            if(cnt >= k) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }
}