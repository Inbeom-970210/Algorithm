class Solution {
    private char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private boolean[] checked = new boolean[8];
    private char[] arr = new char[8];
    private int answer = 0;
    
    public int solution(int n, String[] data) {
        dfs(0, n, data);
        
        return answer;
    }
    
    public void dfs(int depth, int n, String[] data) {
        if(depth == 8) {
            if(validate(n, data)) ++answer;
            return;
        }
        
        for(int i = 0; i < 8; ++i) {
            if(checked[i]) continue;
            
            checked[i] = true;
            arr[depth] = friends[i];
            dfs(depth + 1, n, data);
            
            checked[i] = false;
        }
    }
    
    public boolean validate(int n, String[] data) {
        for(int i = 0; i < n; ++i) {
            char[] detail = data[i].toCharArray();
            int cur = -1;
            int target = -1;
            for(int j = 0; j < 8; ++j) {
                if(arr[j] == detail[0]) cur = j;
                if(arr[j] == detail[2]) target = j;
                if(cur != -1 && target != -1) break;
            }
            int distance = Math.abs(cur - target) - 1;
            int goalDistance = detail[4] - '0';
            
            switch(detail[3]) {
                case '=':
                    if(distance != goalDistance) return false;
                    break;
                case '<':
                    if(distance >= goalDistance) return false;
                    break;
                case '>':
                    if(distance <= goalDistance) return false;
                    break;
            }
        }
        
        return true;
    }
    
}