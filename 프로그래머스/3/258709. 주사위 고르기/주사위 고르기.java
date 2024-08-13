import java.util.*;

class Solution {
    private int n, maxWin, tempWin;
    private int[] answer, arrA, arrB;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        maxWin = Integer.MIN_VALUE;
        answer = new int[n / 2];
        arrA = new int[n / 2];
        arrB = new int[n / 2];
        
        select(0, 0, dice);
        
        return answer;
    }
    
    // dfs를 사용하여 주사위를 나눠 가짐
    // 절반의 주사위를 A가 가짐
    // 반복문을 통해 A가 가지지 않은 주사위를 B가 가짐
    public void select(int depth,int idx,int[][] dice) {
        if(idx == n / 2) {
            int index = -1;
            for(int i = 0; i < n; i++) {
                boolean flag = true;
                for(int val : arrA) {
                    if(val == i) {
                        flag = false;
                        break;
                    }
                }
                if(flag) arrB[++index] = i; 
            }
            
            calAnswer(dice);
            return;
        }
        
        if(depth == n) return;
        
        arrA[idx] = depth;
        select(depth + 1, idx + 1, dice);
        select(depth + 1, idx, dice);
    }
    
    // <sumList> 오름차순 정렬
    // 해당 주사위 조합에서 A의 승과 <maxWin>을 비교 후
    // <maxWin>, <answer> 갱신
    public void calAnswer(int[][ ] dice) {
        List<Integer> sumList = new ArrayList<>();
        calsumB(0, 0, sumList, dice);
        Collections.sort(sumList);
        
        tempWin = 0;
        calsumA(0, 0, sumList, dice);
        if(maxWin < tempWin) {
            maxWin = tempWin;
            for(int i = 0; i < n / 2; i++) {
                answer[i] = arrA[i] + 1;
            }
        }
    }
    
    // dfs를 사용해서 B가 가진 주사위로 만들 수 있는 합을 <sumList>에 저장
    public void calsumB(int depth, int sum, List<Integer> sumList, int[][] dice) {
        if(depth == n / 2) {
            sumList.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            calsumB(depth + 1, sum + dice[arrB[depth]][i], sumList, dice);
        }
    }
    
    // dfs를 사용해서 A가 가진 주사위로 만들 수 있는 합을 <sum>에 저장
    // bs를 사용해서 <sum>과 같으면서 인덱스가 가장 작은 or <sum>보다 크면서 가장 작은 인덱스인 <left>를 구함
    // <left>는 A가 B와 비교했을 때, 승리하는 수이므로 이를 <tempWin>에 더함
    // 이를 통해 해당 주사위 조합에서 A의 승리를 구할 수 있음
    public void calsumA(int depth, int sum, List<Integer> sumList, int[][] dice) {
        if(depth == n / 2) {
            int left = 0;
            int right = sumList.size() - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(sumList.get(mid) < sum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            tempWin += left;
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            calsumA(depth + 1, sum + dice[arrA[depth]][i], sumList, dice);
        }
    }
}