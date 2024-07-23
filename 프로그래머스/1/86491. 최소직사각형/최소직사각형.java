class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            w = Math.max(w, max);
            h = Math.max(h, min);
        }
        
        return w * h;
    }
}