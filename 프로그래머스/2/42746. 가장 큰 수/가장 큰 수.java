import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        StringBuilder sb = new StringBuilder();
        int len = numbers.length;
        String[] arr = new String[len];
        for(int i = 0; i < len; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if(arr[0].equals("0")) return "0";
        for(String val : arr) {
            sb.append(val);
        }
        
        return sb.toString();
    }
}