import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char item : s.toCharArray()) {
            if(item == '(') {
                stack.add(item);
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}