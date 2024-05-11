class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int col = 0;
        for(int i = (int) Math.sqrt(sum); i >= 0; i--) {
            if(sum % i == 0 && (i - 2) * (sum / i - 2) == yellow) {
                col = i;
                break;
            }
        }
        int row = sum / col;
        
        int[] answer = {Math.max(row, col), Math.min(row, col)};
        return answer;
    }
}