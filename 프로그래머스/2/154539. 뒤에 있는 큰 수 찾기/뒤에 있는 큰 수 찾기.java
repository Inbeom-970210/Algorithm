import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }
            
            if(!stack.isEmpty()) answer[i] = stack.peek();
            
            stack.add(numbers[i]);
        }
        
        
        return answer;
    }
}