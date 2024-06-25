import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
    
        int[][] score = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        List<int[]> list = new ArrayList<>();
        int cnt = picks[0] + picks[1] + picks[2];
        
        // 광물을 5개씩 끊어 각 곡갱이로 채굴할 때의 피로도를 list에 저장
        for(int i = 0; i < minerals.length; i += 5) {
            // 곡갱이 개수만큼만 구하기
            if(i / 5 + 1 > cnt) break;
            
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;
                
                int mineralVal = 0;
                String mineral = minerals[j];
                if(mineral.equals("iron")) mineralVal = 1;
                else if(mineral.equals("stone")) mineralVal = 2;
                
                diamond += score[0][mineralVal];
                iron += score[1][mineralVal];
                stone += score[2][mineralVal];
            }
            
            list.add(new int[]{diamond, iron, stone});
        }
        
        // 내림차순 정렬
        Collections.sort(list, (o1, o2) -> (o2[2] - o1[2]));
        
        // 피로도가 높은 광물에 따라 곡갱이 선택
        // diamond -> iron -> stone
        for(int[] items : list) {
            if(picks[0] > 0) {
                picks[0]--;
                answer += items[0];
                continue;
            }
            if(picks[1] > 0) {
                picks[1]--;
                answer += items[1];
                continue;
            }
            if(picks[2] > 0) {
                picks[2]--;
                answer += items[2];
            }
        }
        
        return answer;
    }
}