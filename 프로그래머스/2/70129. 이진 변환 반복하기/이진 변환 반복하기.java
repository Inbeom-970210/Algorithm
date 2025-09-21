class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        // s가 "1"일 될 때까지 반복
        while(!"1".equals(s)) {
            // 1. s의 모든 0을 제거 후 제거된 0의 갯수를 카운트
            String after = s.replace("0", "");
            answer[1] += s.length() - after.length();
            
            // 2. 길이를 2진법 문자열로 변환 후 카운트
            s = Integer.toBinaryString(after.length());
            answer[0]++;
        }
        
        return answer;
    }
}