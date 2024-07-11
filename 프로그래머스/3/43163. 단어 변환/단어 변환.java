class Solution {
    private int answer;
    private boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        boolean flag = false;
        
        // flag를 통해 target이 words에 포함되는지 확인
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) flag = true;
            if(words[i].equals(begin)) visited[i] = true;
        }
        
        // target이 words에 있다면 dfs 수행으로 최소 단계 구하기
        if(flag) {
            answer = Integer.MAX_VALUE;
            dfs(0, begin, target, words);
        }
        
        return answer;
    }
    
    public void dfs(int depth, String begin, String target, String[] words) {
        // 최소값이 아니면 종료
        if(depth >= answer) return;
        
        // 최소값이 나오면 갱신
        if(begin.equals(target)) {
            answer = depth;
            return;
        }
        
        // words 완전 탐색
        // 1. 방문 여부 확인
        // 2. 다른 알파벳 개수(flag) 파악
        // 3-1. flag == 1이면 해당 단어로 변환
        // 3-2. flag != 1이면 다음 word 탐색
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            
            int flag = 0;
            for(int j = 0; j < words[i].length(); j++) {
                if(words[i].charAt(j) != begin.charAt(j) && flag == 0) {
                    flag++;
                } else if(words[i].charAt(j) != begin.charAt(j) && flag == 1) {
                    flag++;
                    break;
                }
            }
            
            if(flag == 0 || flag == 2) continue;
            
            visited[i] = true;
            dfs(depth + 1, words[i], target, words);
            visited[i] = false;
        }
        
    }
}