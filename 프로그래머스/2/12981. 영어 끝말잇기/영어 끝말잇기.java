import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        // 첫번째 입력
        set.add(words[0]);
        String pre = words[0];
        
        // 나머지 입력
        // 1. 이전 단어를 pre에 저장하고 마지막 단어를 last로 추출
        // 2. 현재 단어가 last로 시작하지 않거나 중복이면 결과를 구하고 종료
        // 3. 현재 단어가 문제 없으면 set에 저장 및 pre 변경
        for(int i = 1; i < words.length; i++) {
            String last = pre.substring(pre.length() - 1);
            if(!words[i].startsWith(last) || set.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            set.add(words[i]);
            pre = words[i];
        }

        return answer;
    }
}